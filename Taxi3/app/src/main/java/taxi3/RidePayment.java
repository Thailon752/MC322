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



    /**
     * Calculates the value of the ride.
     * 
     * The value is calculated using the price table
     * 
     * @return the calculated value of the ride.
     */
    public float calculateValue() {

        switch (this.rideDistance) {
            case this.rideDistance<=5:
                
                break;
            case this.rideDistance<=10:

                break;
            case this.rideDistance<=15:
                break;
            case this.rideDistance<=20:

                break;

            case this.rideDistance>20:
            
            default:
                break;
        }

        // IMPLEMENTAR METODO CALCULATE VALUE (CONSIDERANDO TAXA DO MÉTODO DE PAGAMENTO)
    }

    
    /**
     * Processa o pagamento da corrida.
    */
    public void processPayment() {
        // IMPLEMENTAR METODO PROCESS PAYMENT
    }


}
