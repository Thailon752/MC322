package cabbieManager;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import utils.PassengerInfoGenerator;
/**
 * O objeto passenger funciona como passageiro no nosso programa.
 * Ele é uma extensão de person que contem name,phone e email.
 * E também tem seu atributo próprio que é o passengerId que é usado para diferenciar de outros
 * passenger com possiveis nomes,email e telefones iguais. Teoricamente são unicos no programa.
 * No programa o passenger requesita corrida para onde ele deseja ir.
 */


@XmlRootElement
public class Passenger extends Person{
    private String passengerId;

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
     * Geter do Id do passageiro.
     * 
     * @return o id do passageiro e ele está no formato UUID
     */
    @XmlElement
    public String getPassengerId() {
        return this.passengerId;
    }


    /**
     * Retorna uma representação do objeto em formato de string
     * 
     * O formato é: "nome, id do passageiro, telefone e email"
     * 
     * @return String que representa o objeto
     */
    @Override
    public String toString() {
        return String.format(this.name, this.passengerId,this.phone,this.email);
    }
}
