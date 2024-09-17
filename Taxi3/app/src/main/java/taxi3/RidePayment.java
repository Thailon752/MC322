package taxi3;
import java.util.UUID;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;


       
    // IMPLEMENTAR CONSTRUTUOR DA CLASS

    private String noite_dia(LocalDateTime horario){
        if(this.rideStartTime.getHour()<=19 && this.rideStartTime.getHour()<=5){
            return "Diurno";
        }
        else{
            return "Noturno";
        }
    }

    /**
     * Calculates the value of the ride.
     * 
     * The value is calculated using the price table
     * 
     * @return the calculated value of the ride.
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
        return this.paymentId;
    }

    /**
     * Processa o pagamento da corrida.
    */
    @Override
    public void processPayment() {
        
        // IMPLEMENTAR METODO PROCESS PAYMENT
    }


}
