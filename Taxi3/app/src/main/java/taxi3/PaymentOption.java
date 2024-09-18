package taxi3;

public enum PaymentOption {

    // IMPLEMENTAÇÃO ENUM PAYMENT OPTION
    CreditCard("Cartão de Crédito",6),
    DebitCard("Cartão de Débito",4),
    Cash("Dinheiro",0),
    Pix("Pix",1),
    Voucher("Voucher",3);

    private final String nome;
    private final int taxa;

    PaymentOption(String nome,int taxa){
        this.nome =  nome;
        this.taxa = taxa;
    }

    public String getnome(){
        return nome;
    }
    public int gettaxa(){
        return taxa;
    }

    public String info(){
        return String.format("%s taxa de %d", nome,taxa);
    }

}