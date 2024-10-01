package taxi3;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

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
        return this.nome;
    }
    public int gettaxa(){
        return this.taxa;
    }

    public String info(){
        return String.format("%s taxa de %d", this.nome,this.taxa);
    }

}