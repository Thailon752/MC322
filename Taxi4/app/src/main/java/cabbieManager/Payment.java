package cabbieManager;
import java.time.LocalDateTime;
 /**
     * Interface do RidePayment.
     */
public interface Payment {
    
   /**
    * Pega o atributo amount.
    * @return um float amount com precisão de 2 casas.
    */
    public abstract float getamount();
    /**
    * Pega o atributo paymentId.
    * @return uma String paymentId no formato UUID.
    */
    public abstract String getpayid();
    /**
    * Pega o atributo rideId.
    * @return uma String rideId no formato UUID.
    */
    public abstract String getrideid();
    /**
    * Pega o atributo ridedistance.
    * @return um float ridedistance que tem precisão de 2 casas.
    */
    public abstract float getridedistance();
    /**
     * Pega o atributo paymentMethodo.
     * @return o paymentMethodo que pode ser qualquer um dos que estão registrados no enum PaymentOption.
     */
    public abstract PaymentOption getoption();
    /**
     * Pega o atributo startTime.
     * @return LocalDateTime da corrida startTime.
     */
    public abstract LocalDateTime getSTime();
    /**
     * Processa o Pagamento.
     */
    public abstract void processPayment();
    
}
