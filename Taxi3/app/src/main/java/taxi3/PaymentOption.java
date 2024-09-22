package taxi3;

public enum PaymentOption {

    // IMPLEMENTAÇÃO ENUM PAYMENT OPTION
    CARTÃODECRÉDITO("Cartão de Crédito",6),
    CARTÃODEDÉBITO("Cartão de Débito",4),
    DINHEIRO("Dinheiro",0),
    PIX("Pix",1),
    VOUCHER("Voucher",3);

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