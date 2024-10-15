package cabbieManager;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import exceptions.CarrovelhoException;
import exceptions.EmailFormatException;
import exceptions.LetterFormatException;
import utils.CabbieInfoGenerator;

/**
 * O objeto Cabbie funciona como um motorista no programa.
 * Ele é uma extensão de Person que tem nome,phone e email.
 * E tem seus atributos próprios como cabbieId,rating,licenseNumber e status.
 * O cabbieID é para identificar ele de outro Cabbie com mesmo nome.
 * O ranting é a nota que ele teria no nosso programa, essa nota é dada pelos passengers.
 * O LicenseNumber é a licensa que pode ser validada dentro de um banco de dados, para saber se ele ta apto.
 * a ser motorista(Isso não foi implementado ainda, mas é por isso que o atributo existe).
 * O status é algo fluido que vai ser atualizado como True quando ele está com passagers e False quando não esta.
 * é mais para dizer sobre a disponibilidade dele para aceitar uma corrida que foi pedida.
 * A função dele é fazer uma corrida de um ponto a outro.
 */
@XmlRootElement(name = "Cabbie")
@XmlType(propOrder = {"name","cabbieId","rating", "phone","email","licenseNumber","status"})
public class Cabbie extends Person{
    private String cabbieId;
    private float rating;
    private String licenseNumber;
    private boolean status;
    
    public Cabbie(){
        
    }
    
     /**
     * Pega o atributo de Cabbie cabbieId.
     * @return uma String cabbieId.
     */
    @XmlElement(name = "cabbieId")
    public String getcabbieId() {
        return this.cabbieId;
    }
    /**
     * Seta o cabbieId do Cabbie.
     * @param cabbieId String que sera colocada no cabbieId.
     */
    public void setcabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }
     /**
     * Pega o atributo de Cabbie rating.
     * @return um float rating.
     */
    @XmlElement
    public float getrating() {
        return this.rating;
    }
    /**
     * Seta o rating do Cabbie.
     * @param rating float que sera atribuido ao ranting.
     */
    public void setrating(float rating) {
        this.rating = rating;
    }
     /**
     * Pega o atributo de Cabbie status.
     * @return um boolean status.
     */
    @XmlElement
    public boolean getstatus(){
        return this.status;
    }
    /**
     * Seta o status do Cabbie.
     * @param status boolean que vai ser colocado no status.
     */
    public void setstatus(boolean status) {
        this.status = status;
    }
    /**
     * Pega o atributo nome.
     * @return uma String name da pessoa.
     */
    @XmlElement
    public String getname(){
        return this.name;
    }
    /**
     * Seta o name do Cabbie.
     * @param name String que vai ser colocado no status.
     */
    public void setname(String name) {
        this.name = name;
    }
    /**
     * Pega o atributo email.
     * @return uma String email da pessoa.
     */
    @XmlElement(name = "email")
    public String getemail(){
        return this.email;
    }
    /**
     * Seta o email do Cabbie.
     * @param email String que sera colocada no email.
     */
    public void setemail(String email) {
        this.email = email;
    }
    /**
     * Pega o atributo phone.
     * @return uma String phone da pessoa.
     */
    @XmlElement
    public String getphone(){
        return this.phone;
    }
    /**
     * Seta o phone do Cabbie.
     * @param phone String que sera colocada no phone.
     */
    public void setphone(String phone) {
        this.phone = phone;
    }
     /**
     * Pega o atributo de Cabbie licenseNumber.
     * @return uma String licenseNumber.
     */
    @XmlElement(name = "licenseNumber")
    public String getlicenseNumber(){
       return this.licenseNumber;
    }
    /**
     * Seta licenseNumber do Cabbie.
     * @param licenseNumber String que sera colocada no licenseNumber.
     */
    public void setlicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    /**
     * Seta o rating do taxista
     * @param avalia parametro float que é a nota que ele recebeu pela corrida.
     * O parametro pode variar de 0-5.
     * Chama a função privada caclularanting dando o parametro avalia para ela.
     */
    public void setaval(float avalia){
        this.rating =calcularating(avalia);
    }
    /**
     * Calcula o ranting novo.
     * @param avalia parametro float que é a nota que ele recebeu pela corrida.
     * O parametro pode variar de 0-5.
     * A função calcula fazendo uma média simples com o valor do rating antigo e a nota nova.
     */
    private float calcularating(float avalia){
        return ((this.rating+avalia)/2);

    }
    

    
    /**
     * Registra um taxista gerando informações aleatórias.
     * Este método atribui um nome, email, número de telefone, ID do taxista,
     * nota e número da licença aleatórios ao taxista.
     * E gera um printe de saida mostrando que ele foi gerado.
     */
    @Override
    public void register() {

        CabbieInfoGenerator cab = new CabbieInfoGenerator();
        this.name = cab.getName();
        this.email = cab.getEmail();
        this.phone = cab.getPhone();
        this.cabbieId = cab.getCabbieId();
        this.rating = cab.getRate();
        this.licenseNumber = cab.getLicenseNumber();
        System.out.println("Pessoa motorista " + this.cabbieId + " (" + this.name + ") criada com sucesso");
    
    }

    /**
     * Atualiza um campo do taxista.
     * 
     * @param field O campo a ser atualizado.
     * @param newValue O novo valor para o campo.
     * 
     * Os campos válidos são:
     * <ul>
     * <li>name</li>
     * <li>email</li> 
     * <li>phone</li>
     * <li>cabbieId</li>
     * <li>rate</li>
     * <li>licenseNumber</li>
     * </ul>
     * 
     * Se o campo não for válido, uma mensagem é exibida e o campo não é atualizado.
     */
    @Override
    public void update(String field, String newValue){

        boolean validField = true;

        switch (field) {
            case "name":
                if(e_nome(newValue)){
                    this.name = newValue;
                }
                else{
                    throw new LetterFormatException("o nome não pode conter numeros");
                }
                
                break;
            case "email":
                if(e_email(newValue)){
                    this.email = newValue;
                }
                else{
                    throw new EmailFormatException("email invalido");
                }
                
            case "phone":

                try{
                    Integer.parseInt(newValue);
                    this.phone = newValue;
                }
                catch(NumberFormatException e){
                    throw new NumberFormatException("Input contains non-numeric characters: " + newValue);
                }
                
                break;
            case "cabbieId":
                this.cabbieId = newValue;
                break;
            case "rate":
                this.rating = Float.parseFloat(newValue);
                break;
            case "licenseNumber":
                this.licenseNumber = newValue;
                break;
            default:
                validField = false;
                System.out.println("Campo inválido");
                break;
        }

        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }

    }
    /**
     * Verifica se o nome fornecido contém apenas letras.
     * 
     * @param name O nome a ser verificado.
     * @return true se o nome contiver apenas letras, false se houver qualquer outro caractere.
     */
    
    private boolean e_nome(String name) {
        for (char letra : name.toCharArray()) {
            if (!Character.isLetter(letra)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica se o e-mail fornecido está no formato correto.
     * 
     * @param email O e-mail a ser verificado.
     * @return true se o e-mail contiver "@" e for válido, false se não for.
     */
    private boolean e_email(String email) {
        if (email != null && email.contains("@")) {
            return true; // Retorna true se o e-mail contém '@'
        }
        return false; // Retorna false se não contém '@' ou é nulo
    }
    
    
    
    /**
     * Determina se o objeto dado como parametro é o mesmo que o objeto em si.
     * @param clas É um objeto genérico que pode ou não ser do tipo Cabbie.
     * @return A função retorna verdadeiro ou falso dependendo do objeto dado.
     * Caso seja um objeto igual é verdadeiro, caso seja de outra classe ou outro objeto da mesma classe retorna falso.
     */
    @Override
    public boolean isequals(Object clas){
        if (this.getClass().equals(clas.getClass())){
            Cabbie prov = (Cabbie) clas;
            if(this.cabbieId.equalsIgnoreCase(prov.getcabbieId())){
                return true;
            }
        }
        return false;
    }
   

    /**
     * Retorna uma representação em string do objeto.
     * 
     * O formato é: "nome identidade numero de licensa nota telefone e email".
     * 
     * @return uma representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Cabbie: "+" "+this.name+" "+this.cabbieId+" "+this.licenseNumber+" "+this.rating+" "+this.phone+" "+this.email;
    }
}
