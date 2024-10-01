package cabbieManager;

 /**
     * Interface do RidePayment
     * As funçãoes publicas que são implementadas do RidePayment
     */
public interface Payment {
    
   
    public abstract float getamont();
    public abstract float getridedistance();
    public abstract PaymentOption getoption();
    public abstract String getpayid();
    public abstract String getrideid();
    public abstract void processPayment();
    
}
