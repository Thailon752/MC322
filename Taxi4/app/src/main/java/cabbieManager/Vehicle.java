package cabbieManager;
import com.google.common.base.Objects;

import utils.VehicleInfoGenerator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import utils.VehicleInfoGenerator;

/**
 * Objeto usado para identificar o veiculo com o qual a corrida foi feita.
 * Contem atributos de modelo, numero de registro, ano, Id do veiculo no programa e Id do taxista dono dele. 
 */

@XmlRootElement
public class Vehicle {
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private String cabbieId;
    
    /**
     * Pega o atributo do veiculo vehicleId.
     * @return a String vehicleId.
     */
    @XmlElement
    public String getVehicleId() {
        return this.vehicleId;
    }
    /**
     * Pega o atributo do veiculo registrationNumber.
     * @return a String registrationNumber.
     */
    @XmlElement
    public String getregistration(){
        return this.registrationNumber;
    }
    /**
     * Pega o atributo do veiculo model.
     * @return a String model.
     */
    @XmlElement
    public String getmodel(){
        return this.model;
    }
    /**
     * Pega o atributo do veiculo year.
     * @return a int year.
     */
    @XmlElement
    public int getano(){
        return this.year;
    }
    /**
     * Pega o atributo do veiculo cabbieId.
     * @return a String cabbieId.
     */
    @XmlElement
    public String getVcabID(){
        return this.cabbieId;
    }

    /**
     * Construtor do veiculo 
     * @param cabbieId identificação do dono do carro
     * Apenas seta o dono.
     */
    public Vehicle(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Registra o veiculo com informações randomizadas fornecidas pelo Vehicleinforgenerator.
     * Esse método seta o id do veiculo, o numero de registro, modelo e ano.
     */
    public void registerVehicle() {
        VehicleInfoGenerator veh = new VehicleInfoGenerator();
        this.vehicleId = veh.getVehicleId();
        this.registrationNumber = veh.getRegistrationNumber();
        this.model = veh.getModel();
        this.year = veh.getYear();

        System.out.println("Veículo " + this.vehicleId + " (" + this.model + " " + this.year + ") criado com sucesso");
    }

    /**
     * Atualiza os atributos do veiculo
     * 
     * @param field campo a ser atualizado
     * @param newValue novo falor do campo selecionado
     * 
     * Campos validos são:
     * <ul>
     * <li>vehicleId</li>
     * <li>registrationNumber</li>
     * <li>model</li>
     * <li>year</li>
     * </ul>
     * 
     * Se o campo selecionado não é válido é printado uma mensagem de campo invalido
     */
    public void updateVehicle(String field, String newValue) {

        boolean validField = true;

        switch (field) {
            case "vehicleId":
                this.vehicleId = newValue;
                break;
            case "registrationNumber":
                this.registrationNumber = newValue;
                break;
            case "model":
                this.model = newValue;
                break;
            case "year":
                this.year = Integer.parseInt(newValue);
                break;
            default:
                validField = false;
                System.out.println("Campo inválido, tente novametne");
                break;
        }

        if (validField) {
            System.out.println("Campo " + field + " alterado com sucesso");
        }


        return;
    }

    /**
     * Retorna uma string de apresentação do objeto
     * 
     * @return a string tem id do veiculo, numero de registro, modelo, ano e
     *         o id do taxista dono dele, separados por virgula.
     */

    public String toString() {
        return String.format(this.vehicleId, this.registrationNumber, this.model, this.year, this.cabbieId);
    }
    /**
     * Determina se o objeto dado como parametro é o mesmo que o objeto em si.
     * @param clas É um objeto genérico que pode ou não ser do tipo Cabbie.
     * @return A função retorna verdadeiro ou falso dependendo do objeto dado.
     * Caso seja um objeto igual é verdadeiro, caso seja de outra classe ou outro objeto da mesma classe retorna falso.
     */
    public boolean isequals(Object clas){
        if (this.getClass().equals(clas.getClass())){
            Vehicle prov = (Vehicle) clas;
            if(this.vehicleId.equalsIgnoreCase(prov.getVcabID())){
                return true;
            }
        }
        return false;
    }

    
}
