package cabbieManager;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class RidePayment implements Payment{
    
    private final String paymentId;
    private final String rideId;
    private final LocalDateTime rideStartTime;
    private final float rideDistance;
    private float amount;
    private final PaymentOption paymentMethod;


       
    // IMPLEMENTAR CONSTRUTUOR DA CLASS
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
    

    public RidePayment(String corridId,LocalDateTime datahora, float distancia,String metodopag){
        this.rideId =  corridId;
        this.rideStartTime = datahora;
        this.rideDistance = distancia;
        this.paymentMethod = PaymentOption.valueOf(normalizar(metodopag));
        System.out.printf("Forma de pagamento selecionada: %s\n", this.paymentMethod.getnome());
        this.paymentId = UUID.randomUUID().toString();
        calcula_value();
        System.out.printf("Valor da corrida: %.2f\n", this.amount);
    }

    /**
     * Recebe um texto e tira os espaços e coloca em UPERCASE
     * 
     * @param texto o texto a ser normalizado
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
     * @param rideStartTime
     * 
     * @return uma string com o periodo do dia
     */

    private String noite_dia(LocalDateTime horario){
        if(this.rideStartTime.getHour()<=18 && this.rideStartTime.getHour()>=5){
            return "Diurno";
        }
        else{
            return "Noturno";
        }
    }

    /**
     * Calcula o valor da corrida
     * 
     * Usando uma tabela para fazer as contas dependendo da distancia recebida pelo construtor
     * Utiliza a função noite_dia para saber o em qual periodo a corrida foi chamada
     * 
     * @return o valor da corrida.
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
     * E seta a quantidade a pagar pela corrida no objeto
     */
    private void calcula_value(){
        float taxa =(float) this.paymentMethod.gettaxa()/100;
        this.amount = Math.round((valor_da_corrida()+taxa*valor_da_corrida())* 100.0f) / 100.0f;

    }
    /**
     * Geters de todos os atributos
     * @return os atributos que são chamados.
     */
    
    public float getamont(){
        return this.amount;
    }
    public float getridedistance(){
        return this.rideDistance;
    }
    public PaymentOption getoption(){
        return this.paymentMethod;
    }
    public String getpayid(){
        return this.paymentId;
    }
    public  String getrideid(){
        return this.rideId;
    }
    public LocalDateTime getSTime(){
        return this.rideStartTime;
    }

    /**
     * Processa o pagamento da corrida.
     * @param Pagamentos Array que registra os pagamentos feitos
     * Guardando o objeto dentro de um Array fornecido e printando um sinal de pagamaento realizado
    */
    @Override
    public void processPayment(ArrayList<RidePayment> Pagamentos) {
        Pagamentos.add(this);
        System.out.println("Pagamento realizado com sucesso!");
    }


}
