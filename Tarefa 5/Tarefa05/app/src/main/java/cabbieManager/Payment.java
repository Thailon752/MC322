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
    public abstract String getpaymentId();
    /**
    * Pega o atributo rideId.
    * @return uma String rideId no formato UUID.
    */
    public abstract String getrideId();
    /**
    * Pega o atributo ridedistance.
    * @return um float ridedistance que tem precisão de 2 casas.
    */
    public abstract float getrideDistance();
    /**
     * Pega o atributo paymentMethodo.
     * @return o paymentMethodo que pode ser qualquer um dos que estão registrados no enum PaymentOption.
     */
    public abstract PaymentOption getpaymentMethod();
    /**
     * Pega o atributo startTime.
     * @return LocalDateTime da corrida startTime.
     */
    public abstract LocalDateTime getrideStartTime();
    /**
     * Define o atributo amount.
     * @param amount valor de amount com precisão de 2 casas decimais.
     */
    public abstract void setamount(float amount);

    /**
     * Define o atributo rideDistance.
     * @param rideDistance valor de rideDistance com precisão de 2 casas decimais.
     */
    public abstract void setrideDistance(float rideDistance);

    /**
     * Define o atributo paymentMethod.
     * @param paymentMethod uma opção de pagamento do enum PaymentOption.
     */
    public abstract void setpaymentMethod(PaymentOption paymentMethod);

    /**
     * Define o atributo paymentId.
     * @param paymentId uma String no formato UUID representando o ID do pagamento.
     */
    public abstract void setpaymentId(String paymentId);

    /**
     * Define o atributo rideId.
     * @param rideId uma String no formato UUID representando o ID da corrida.
     */
    public abstract void setrideId(String rideId);

    /**
     * Define o atributo rideStartTime.
     * @param rideStartTime um LocalDateTime representando o horário de início da corrida.
     */
    public abstract void setrideStartTime(LocalDateTime rideStartTime);


    /**
     * Processa o Pagamento.
     */
    public abstract void processPayment();
    /**
     * Determina se o objeto dado como parametro é o mesmo que o objeto em si.
     * @param clas É um objeto genérico que pode ou não ser do tipo Cabbie.
     * @return A função retorna verdadeiro ou falso dependendo do objeto dado.
     * Caso seja um objeto igual é verdadeiro, caso seja de outra classe ou outro objeto da mesma classe retorna falso.
     */
    public abstract boolean isequals(Object clas);
    
}
