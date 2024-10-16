package cabbieManager;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import exceptions.InvalidPaymentMethodException;
import exceptions.InvalidRideDistanceException;
import utils.LocalDateTimeAdapter;

import java.time.LocalDateTime;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto ridepaymente implementa a interface Payment.
 * Os atributos servem para registro da corrida e para ação de pagamento.
 * PaymentId atributo para diferenciar de outras corridas
 * rideId atributo para saber de qual corrida é referente o pagamento.
 * rideStartTime atributo para calcular o valor a ser pago. Ele contem o dia e horario da corrida
 * rideDistance atributo para calcular o valor a ser pago. Ele tem a distancia dos pontos
 * de embarque e desembarque em float.
 * amount atributo que é o pago pela corrida. Em float.
 * paymentMethod atributo que contem um enum para dependendo da opção selecionada saber a taxa do pagamento
 * selecionado.
 * 
 */





@XmlRootElement(name = "ridePayment")
@XmlType(propOrder = {"paymentId","rideId","rideDistance", "amount","rideStartTime","paymentMethod"})
public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

       
    // IMPLEMENTAR CONSTRUTUOR DA CLASS
  
    
    public RidePayment(){

    }
    /**
     * O construtor recebe o id corrida a data e hora, a distancia e o metodo de pagamento.
     * @param corridaid id da corrida a ser paga.
     * @param datahora horario da corrida para calcular o valor
     * @param distancia a distancia entre os pontos de inicio e fim da corrida
     * @param metodopag metodo de pagamento definido.
     * Usa os parametros para inicializar o objeto e calcular o valor a ser pago.
     * Dentro do construtor já é definido também o id do objeto pela biblioteca UUID.
     * Gera algumas saidas para melhor comunicação como a forma do pagamento e o valor a ser pago.
     */

    public RidePayment(String corridId, LocalDateTime datahora, float distancia, String metodopag) throws InvalidRideDistanceException, InvalidPaymentMethodException {
        try {
            if(distancia<= 0)throw new InvalidRideDistanceException("Ride distance must be greater than zero");
            this.rideId = corridId;
            this.rideStartTime = datahora;
            this.rideDistance = distancia;
            this.paymentMethod = PaymentOption.valueOf(normalizar(metodopag));
            System.out.printf("Forma de pagamento selecionada: %s\n", this.paymentMethod.getnome());
            this.paymentId = UUID.randomUUID().toString();
            calcula_value();
            System.out.printf("Valor da corrida: %.2f\n", this.amount);
        } catch (IllegalArgumentException e) {
            throw new InvalidPaymentMethodException("The PaymentMethod "+ metodopag + " is not suported");
        }
    }  

    /**
     * Recebe um texto e tira os espaços e coloca em UPERCASE
     * 
     * @param texto o texto a ser normalizado do tipo String
     * 
     * @return retorna uma string em maiusculo do texto sem espaços
     */
    private String normalizar(String texto) {
        return texto.trim().replaceAll("\\s+", "").toUpperCase();
    }
    
    /**
     * Com base na hora do dia, retorna se é Dia ou noite.
     * 
     * Usa a Localdatetime para saber a hora
     * @param horario do tipo LocalDate time
     * Usa apenas o getHour do LocalDateTime para saber o periodo
     * 
     * @return uma string com o periodo do dia
     */

    private String noite_dia(LocalDateTime horario){
        try{
            if(this.rideStartTime.getHour()<=18 && this.rideStartTime.getHour()>=5){
                return "Diurno";
            }
            else{
                return "Noturno";
            }
        }
        catch(NullPointerException e){
            throw new NullPointerException("Start time of the ride to be paid cannot be null");

        }
        
    }

    /**
     * Calcula o valor da corrida
     * 
     * Usando uma tabela para fazer as contas dependendo da distancia recebida pelo construtor
     * Utiliza a função noite_dia para saber o em qual periodo a corrida foi chamada
     * Com base nessas informações retorna o valor pela distancia percorrida
     * 
     * @return retorna um float que representa o valor pela distania da corrida
     */
    
    private float valor_da_corrida() {
        float valor =0;
        if(this.rideDistance <=5){
            if(noite_dia(this.rideStartTime).equalsIgnoreCase("Diurno")){
                valor =(float) (5 + 2*this.rideDistance);
            }
            else{
                valor = (float)(6 + 2.5*this.rideDistance);
            }
        }
        else if(this.rideDistance<=10){
            if(noite_dia(this.rideStartTime).equalsIgnoreCase("Diurno")){
                valor =(float) (4 + 2.5*this.rideDistance);
            }
            else{
                valor = (float)(5 + 3*this.rideDistance);
            }
        }
        else if(this.rideDistance<=15){
            if(noite_dia(this.rideStartTime).equalsIgnoreCase("Diurno")){
                valor =(float) (3.5 + 3*this.rideDistance);
            }
            else{
                valor = (float)(4.5 + 3.5*this.rideDistance);
            }
        }
        else if(this.rideDistance<=20){
            if(noite_dia(this.rideStartTime).equalsIgnoreCase("Diurno")){
                valor =(float) (3 + 4*this.rideDistance);
            }
            else{
                valor = (float)(4 + 4.5*this.rideDistance);
            }
        }
        else if(this.rideDistance>20){
            if(noite_dia(this.rideStartTime).equalsIgnoreCase("Diurno")){
                valor =(float) (2.5 + 3.5*this.rideDistance);
            }
            else{
                valor = (float)(3.5 + 4*this.rideDistance);
            }
        }
        return valor;
    }
    
    /**
     * Calcula o total a ser pago
     * 
     * Usa a função valor_da_corrida para saber o valor por distancia e 
     * acrescenta a taxa dependendo do tipo de pagamento.
     * 
     * Usa o enum PaymentOption para saber a taxa do metodo dado no construtor.
     * 
     * E seta a quantidade a pagar pela corrida.
     * 
     * O valor setado sera um float com duas casas.
     */
    private void calcula_value(){
        float taxa =(float) this.paymentMethod.gettaxa()/100;
        this.amount = Math.round((valor_da_corrida()+taxa*valor_da_corrida())* 100.0f) / 100.0f;

    }
     /**
    * Pega o atributo amount.
    * @return um float amount com precisão de 2 casas.
    */
    @Override
    @XmlElement(name = "amount")
    public float getamount(){
        return this.amount;
    }
    /**
     * Define o atributo amount.
     * @param amount valor de amount com precisão de 2 casas decimais.
     */
    public void setamount(float amount) {
        this.amount = amount;
    }
    /**
    * Pega o atributo ridedistance.
    * @return um float ridedistance que tem precisão de 2 casas.
    */
    @Override
    @XmlElement(name = "rideDistance")
    public float getrideDistance(){
        return this.rideDistance;
    }
    /**
     * Define o atributo rideDistance.
     * @param rideDistance valor de rideDistance com precisão de 2 casas decimais.
     */
    public void setrideDistance(float rideDistance) {
        this.rideDistance = rideDistance;
    }
    /**
     * Pega o atributo paymentMethodo.
     * @return o paymentMethodo que pode ser qualquer um dos que estão registrados no enum PaymentOption.
     */
    @Override
    @XmlElement(name = "paymentMethod")
    public PaymentOption getpaymentMethod(){
        return this.paymentMethod;
    }
    /**
     * Define o atributo paymentMethod.
     * @param paymentMethod uma opção de pagamento do enum PaymentOption.
     */
    public void setpaymentMethod(PaymentOption paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    /**
    * Pega o atributo paymentId.
    * @return uma String paymentId no formato UUID.
    */
    @Override
    @XmlElement
    public String getpaymentId(){
        return this.paymentId;
    }
    /**
     * Define o atributo paymentId.
     * @param paymentId uma String no formato UUID representando o ID do pagamento.
     */
    public void setpaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    /**
    * Pega o atributo rideId.
    * @return uma String rideId no formato UUID.
    */
    @Override
    @XmlElement(name = "rideId")
    public  String getrideId(){
        return this.rideId;
    }
    /**
     * Define o atributo rideId.
     * @param rideId uma String no formato UUID representando o ID da corrida.
     */
    public void setrideId(String rideId) {
        this.rideId = rideId;
    }
    /**
     * Pega o atributo startTime.
     * @return LocalDateTime da corrida startTime.
     */
    @Override
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name = "rideStartTime")
    public LocalDateTime getrideStartTime(){
        return this.rideStartTime;
    }
    /**
     * Define o atributo rideStartTime.
     * @param rideStartTime um LocalDateTime representando o horário de início da corrida.
     */
    public void setrideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    /**
     * Processa o pagamento da corrida.
    */
    @Override
    public void processPayment() {
        System.out.println("Pagamento realizado com sucesso!");
    }
    /**
     * Determina se o objeto dado como parametro é o mesmo que o objeto em si.
     * @param clas É um objeto genérico que pode ou não ser do tipo Cabbie.
     * @return A função retorna verdadeiro ou falso dependendo do objeto dado.
     * Caso seja um objeto igual é verdadeiro, caso seja de outra classe ou outro objeto da mesma classe retorna falso.
     */
    @Override
    public boolean isequals(Object clas){
        if (this.getClass().equals(clas.getClass())){
            RidePayment prov = (RidePayment) clas;
            if(this.paymentId.equalsIgnoreCase(prov.getpaymentId())){
                return true;
            }
        }
        return false;
    }
    /**
     * Função que imprimi uma String que representa o Objeto.
     * String com o formato: paymentId,rideId,rideStarTime,amount,rideDistance, paymentMethod.
     * @return uma String que representa um objeto.
     */
    public String toString(){
        return "RidePayment:"+" "+this.paymentId+" "+this.rideId+" "+this.rideStartTime+" "+this.amount+" "+this.rideDistance+" "+this.paymentMethod;
    }
}
