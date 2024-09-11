
public class Payment {
    //Adicionar os atributos da classe Payment
    private String paymentid;
    private String rideid;
    private double valor;
    private String prymentMethodo;
    //Adicionar os métodos da classe Payment
    public int processapagamento(String rideid,String paymethodo, double amont){
        String[] mets = new String[3];
        mets[0]=  "Credit Card";
        mets[1]= "Cash";
        mets[2]= "Debit Card";
        for (int i=0;i<3;i++){
            if(paymethodo.equalsIgnoreCase(mets[i])){
                this.rideid = rideid;
                this.prymentMethodo = paymethodo;
                this.valor = amont;
                this.paymentid = geraid(rideid,paymethodo);
                System.out.println("Forma de pagamento aceita.");
                return 1;
            }
        }
        System.out.println("Forma de pagamento nao reconhecida!!");
        return 0;

    }
    private String geraid(String idride,String metodo){
        String paymenid = idride+metodo;
        return paymenid;
    }

}
