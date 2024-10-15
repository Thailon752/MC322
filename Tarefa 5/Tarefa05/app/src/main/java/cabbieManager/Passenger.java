package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import utils.PassengerInfoGenerator;
/**
 * O objeto passenger funciona como passageiro no nosso programa.
 * Ele é uma extensão de person que contem name,phone e email.
 * E também tem seu atributo próprio que é o passengerId que é usado para diferenciar de outros
 * passenger com possiveis nomes,email e telefones iguais. Teoricamente são unicos no programa.
 * No programa o passenger requesita corrida para onde ele deseja ir.
 */
@XmlRootElement(name = "Passenger")
@XmlType(propOrder = {"name","passengerId","phone", "email"})
public class Passenger extends Person{
    private String passengerId;

    public Passenger(){
        
    }
    /**
     * Registra um Passenger dando atributos aleatórios gerados pelo PassengerInforGernerator
     * Esse metodo seta randomicament o email, name, phone number e ID do passenger.
     * 
     */
    @Override
    public void register() {

        PassengerInfoGenerator pass = new PassengerInfoGenerator();
        this.email = pass.getEmail();
        this.name = pass.getName();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        System.out.println("Pessoa passageira " + this.passengerId + " (" + this.name + ") criada com sucesso");
    
    }
    /**
     * Atualiza um campo do passageiro.
     * 
     * @param field O campo a ser atualizado.
     * @param newValue O novo valor para o campo.
     * 
     * Os campos válidos são:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>passengerId</li>
     * </ul>
     * 
     * Se o campo não for válido, uma mensagem é exibida e o campo não é atualizado.
     */
    @Override
    public void update(String field, String newValue){

        boolean validField = true;

        switch (field) {
            case "name":
                this.name = newValue;
                break;
            case "email":
                this.email = newValue;
                break;
            case "phone":
                this.phone = newValue;
                break;
            case "passengerId":
                this.passengerId = newValue;
                break;
            default:
                System.out.println("Campo inválido");
                validField = false;       
        }

        if (validField) {
            System.out.println("Campo " + field + " atualizado com sucesso!");
        }

    
    }
    /**
     * Pega o atributo nome.
     * @return uma String name da pessoa.
     */
    @XmlElement(name = "name")
    public String getname(){
        return this.name;
    }
    /**
     * Seta o name do Passenger.
     * @param name String que vai ser colocado no status.
     */
    public void setname(String name) {
        this.name = name;
    }
    /**
     * Pega o atributo passengerId.
     * 
     * @return o id do passageiro e ele está no formato UUID.
     */
    @XmlElement(name = "passengerId")
    public String getPassengerId() {
        return this.passengerId;
    }
    /**
     * Seta o passengerId do Passenger.
     * @param ID String que sera colocada no passengerId.
     */
    public void setPassengerId(String ID){
        this.passengerId = ID;
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
     * Seta o email do Passenger.
     * @param email String que sera colocada no email.
     */
    public void setemail(String email) {
        this.email = email;
    }
    /**
     * Pega o atributo phone.
     * @return uma String phone da pessoa.
     */
    @XmlElement(name = "phone")
    public String getphone(){
        return this.phone;
    }
    /**
     * Seta o phone do Passenger.
     * @param phone String que sera colocada no phone.
     */
    public void setphone(String phone) {
        this.phone = phone;
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
            Passenger prov = (Passenger) clas;
            if(this.passengerId.equalsIgnoreCase(prov.getPassengerId())){
                return true;
            }
        }
        return false;
    }


    /**
     * Retorna uma representação do objeto em formato de string.
     * 
     * O formato é: "nome, id do passageiro, telefone e email".
     * 
     * @return String que representa o objeto.
     */
    @Override
    public String toString() {
        return "Passenger: " +" "+ this.name +" "+ this.passengerId +" "+  this.phone +" "+  this.email;
    }
}
