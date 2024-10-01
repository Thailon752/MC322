package cabbieManager;
/**
 * Tabela que contem o tipo de pagamento relacionado com umma taxa sobre o valor
 * 
 */
public enum PaymentOption {

    // IMPLEMENTAÇÃO ENUM PAYMENT OPTION

    CARTÃODECRÉDITO("Cartão de Crédito",6),
    CARTÃODEDÉBITO("Cartão de Débito",4),
    DINHEIRO("Dinheiro",0),
    PIX("Pix",1),
    VOUCHER("Voucher",3);

    private final String nome;
    private final int taxa;
    /**
     * Construtor para as opções de pagamento
     * @param nome Nome da opção de pagamento
     * @param taxa Taxa a ser paga pela escolha
     */

    PaymentOption(String nome,int taxa){
        this.nome =  nome;
        this.taxa = taxa;
    }
    /**
     * Geters dos atributos de cada atributo
     * @return o atributo que foi pedido da opção de pagamento.
     */
    public String getnome(){
        return this.nome;
    }
    public int gettaxa(){
        return this.taxa;
    }
    /**
     * Mostra qual é o nome e a taxa do metodo selecionado
     * @return uma string com o nome e taxa do metodo.
     */
    public String info(){
        return String.format("%s taxa de %d", this.nome,this.taxa);
    }

}