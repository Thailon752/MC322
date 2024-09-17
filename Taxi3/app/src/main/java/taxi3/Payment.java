package taxi3;
public interface Payment {
    
    // INTERFACE PAYMENT 
    public abstract float getamont();
    public abstract float getridedistance();
    public abstract PaymentOption getoption();
    public abstract String getpayid();
    public abstract String getrideid();
    public abstract void processPayment();
    
}
