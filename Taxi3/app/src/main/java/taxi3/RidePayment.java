package taxi3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class RidePayment implements Payment{
    
    private final String paymentId;
    private final String rideId;
    private final LocalDateTime rideStartTime;
    private final float rideDistance;
    private float amount;
    private final PaymentOption paymentMethod;


       
    // IMPLEMENTAR CONSTRUTUOR DA CLASS

    public RidePayment(String corridId,LocalDateTime datahora, float distancia,String metodopag){
        this.rideId =  corridId;
        this.rideStartTime = datahora;
        this.rideDistance = distancia;
        this.paymentMethod = PaymentOption.valueOf(metodopag);
        this.paymentId = UUID.randomUUID().toString();
        calcula_value();
    }
    
    /**
     * Com base na hora do dia, retorna se é Dia ou noite.
     * 
     * Usa a Localdatetime para saber a hora
     * 
     * @return uma string com o periodo do dia
     */

    private String noite_dia(LocalDateTime horario){
        if(this.rideStartTime.getHour()<=18 && this.rideStartTime.getHour()<=5){
            return "Diurno";
        }
        else{
            return "Noturno";
        }
    }

    /**
     * Calcula o valor da corrida
     * 
     * Usando a tabela para fazer as contas dependendo da distancia
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
                valor =(float) (2.5 + 2*this.rideDistance);
            }
            else{
                valor = (float)(3.5 + 2.5*this.rideDistance);
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
     * Usa a tabela de taxas
     * 
     * E seta a quantidade a pagar pela corrida no objeto
     */
    private void calcula_value(){
        this.amount = valor_da_corrida()+paymentMethod.gettaxa()*valor_da_corrida();

    }

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

    /**
     * Processa o pagamento da corrida.
     * Guardando o objeto dentro de um Array fornecido e printando um sinal de pagamaento realizado
    */
    @Override
    public void processPayment(ArrayList<RidePayment> Pagamentos) {
        Pagamentos.add(this);
        System.out.println("Pagamento realizado com sucesso!");
    }


}
