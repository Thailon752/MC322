public class Payment {
    //Adicionar os atributos da classe Payment
    private String paymentid;
    private String rideid;
    private double valor;
    private String prymentMethodo;
    //Adicionar os métodos da classe Payment
    public void processapagamento(String rideid,String paymethodo, double amont){
        this.rideid = rideid;
        this.prymentMethodo = paymethodo;
        this.valor = amont;
        this.paymentid = geraid(rideid,paymethodo);

    }
    private String geraid(String idride,String metodo){
        String paymenid = idride+metodo;
        return paymenid;
    }
}
