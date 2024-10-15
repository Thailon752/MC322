package cabbieManager;

import utils.VehicleInfoGenerator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import exceptions.CarrovelhoException;



/**
 * Objeto usado para identificar o veiculo com o qual a corrida foi feita.
 * Contem atributos de modelo, numero de registro, ano, Id do veiculo no programa e Id do taxista dono dele. 
 */

@XmlRootElement(name = "Vehicle")
@XmlType(propOrder = {"vehicleId","registrationNumber","cabbieId", "model","year"})
public class Vehicle {
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private String cabbieId;
    
    
    public Vehicle(){
        
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
     * Pega o atributo do veiculo vehicleId.
     * @return a String vehicleId.
     */
    @XmlElement
    public String getVehicleId() {
        return this.vehicleId;
    }
    /**
     * Define o atributo vehicleId.
     * @param vehicleId uma String representando o ID do veículo.
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    /**
     * Pega o atributo do veiculo registrationNumber.
     * @return a String registrationNumber.
     */
    @XmlElement
    public String getRegistrationNumber(){
        return this.registrationNumber;
    }
    /**
     * Define o atributo registrationNumber.
     * @param registrationNumber uma String representando o número de registro do veículo.
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
     * Define o atributo model.
     * @param model uma String representando o modelo do veículo.
     */
    public void setmodel(String model) {
        this.model = model;
    }
    /**
     * Pega o atributo do veiculo year.
     * @return a int year.
     */
    @XmlElement
    public int getyear(){
        return this.year;
    }
    /**
     * Define o atributo year.
     * @param year um valor int representando o ano do veículo.
     */
    public void setyear(int year) {
        this.year = year;
    }
    /**
     * Pega o atributo do veiculo cabbieId.
     * @return a String cabbieId.
     */
    @XmlElement
    public String getCabbieId(){
        return this.cabbieId;
    }
    /**
     * Define o atributo cabbieId.
     * @param cabbieId uma String representando o ID do motorista (cabbie).
     */
    public void setCabbieId(String cabbieId) {
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
     * @throws CarrovelhoException 
     */
    public void updateVehicle(String field, String newValue) throws CarrovelhoException {

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
                if(e_year(newValue)){
                    this.year = Integer.parseInt(newValue);
                }
                else{
                    throw new CarrovelhoException("data errada ou carro muito velho");
                }
                
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
        return "Vehicle: " +" "+ this.model +" "+ this.vehicleId +" "+  this.year +" "+  this.registrationNumber+" "+ this.cabbieId;
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
            if(this.vehicleId.equalsIgnoreCase(prov.getVehicleId())){
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica se o ano fornecido está dentro de um intervalo de idade permitido.
     * 
     * O método converte o ano de fabricação fornecido (em formato String) para um inteiro
     * e calcula a diferença entre o ano atual (2024) e o ano fornecido.
     * Se a diferença for menor que 74 anos, o método retorna true, 
     * indicando que o veículo ainda está dentro do intervalo de idade permitido.
     * Caso contrário, retorna false.
     * 
     * @param year O ano de fabricação do veículo como String.
     * @return true se a diferença entre 2024 e o ano de fabricação for menor que 74, false caso contrário.
     * @throws NumberFormatException se o valor fornecido não puder ser convertido para um número inteiro.
     */
    private boolean e_year(String year){
        int yearint = Integer.parseInt(year);
        if((2024-yearint) < 74){
            return true;

        }else{
            return false;
        }
    }

    
}
