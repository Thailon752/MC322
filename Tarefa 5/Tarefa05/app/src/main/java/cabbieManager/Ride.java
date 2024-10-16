package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import utils.LocalDateTimeAdapter;
import java.text.Normalizer;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * O objeto ride vai ser usado como um intermediario para registrar que a corrida aconteceu.
 * Para isso ela dispoe dos atribustos rideId, passengerId,cabbieId,vehicleId,status,pickupLocation
 * dropLocation,startTime,distance.
 * Cada atributo tem sua fncionalidade implicita no nome.
 */

@XmlRootElement(name = "ride")
@XmlType(propOrder = {"rideId","passengerId","cabbieId", "vehicleId","pickupLocation","dropLocation","rideDistance","status","startTime"})
public class Ride {
    
    private String rideId;
    private String passengerId;
    private String cabbieId;
    private String vehicleId;
    private String status;
    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private float rideDistance;

    public Ride(){
        
    }
    /**
     * Construtor da corrida, para existir a corrida so precisa de um passenger.
     * @param passengerId uma String que é o id do passenger.
     */

    public Ride(String passengerId) {
        this.passengerId = passengerId;
        this.rideId = UUID.randomUUID().toString();
    }
    /**
     * Pega o atributo rideId.
     * @return a String rideId.
     */
    @XmlElement(name = "rideId")
    public String getRideId() {
        return this.rideId;
    }
    /**
     * Define o atributo rideId.
     * @param rideId uma String representando o ID da corrida.
     */
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }
    /**
     * Pega o atributo distance.
     * @return o float distance.
     */
    @XmlElement
    public float getrideDistance() {
        return this.rideDistance;
    }
    /**
     * Define o atributo rideDistance.
     * @param distance um valor float representando a distância da corrida.
     */
    public void setrideDistance(float distance) {
        this.rideDistance = distance;
    }
    /**
     * Pega o atributo startTime.
     * @return LocalDateTime da corrida startTime.
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    /**
     * Define o atributo startTime.
     * @param startTime um LocalDateTime representando o horário de início da corrida.
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    /**
     * Pega o atributo cabbieId.
     * @return a String cabbieId.
     */
    @XmlElement
    public String getCabbieId() {
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
     * Pega o atributo passengerId.
     * @return a String passengerId.
     */
    @XmlElement
    public String getPassengerId() {
        return this.passengerId;
    }
    /**
     * Define o atributo passengerId.
     * @param passengerId uma String representando o ID do passageiro.
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    /**
     * Pega o atributo vehicleId .
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
     * Pega o atributo status.
     * @return a String status.
     * Os status válidos são:
     * <ul>
     * <li>Aceita</li>
     * <li>Em progresso</li>
     * <li>Finalizada</li>
     * <li>Solicitada</li>
     * </ul>
     */
    @XmlElement
    public String getStatus() {
        return status;
    }
    /**
     * Define o atributo status.
     * @param status uma String representando o status da corrida. 
     * Os status válidos são:
     * <ul>
     * <li>Aceita</li>
     * <li>Em progresso</li>
     * <li>Finalizada</li>
     * <li>Solicitada</li>
     * </ul>
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Pega o atributo pickupLocation
     * @return retorna o atributo pickupLocation no formato Location
     */
    @XmlElement
    public Location getPickupLocation(){
        return this.pickupLocation;
    }
    /**
     * Seta a localização de embarque
     * @param pickupLocation Location para ser colocada no pickupLocation
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    /**
     * Pega o atributo dropLocation
     * @return 
     */
    @XmlElement
    public Location getDropLocation(){
        return this.dropLocation;
    }
    /**
     *Seta a localização do desembarque
     * @param dropLocation enum location, vai ter as coordenadas e o nome.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    /**
     * Normaliza a String dada para ser mais facil ser reconhecida.
     * Método para normalizar o nome da localização (remover acentos e espaços)
     * @param locationName String com o nome do metodo para ser normalizado
     * @return uma String normalizada.
     */
    public String normalizeLocationName(String locationName) {
        locationName = Normalizer.normalize(locationName, Normalizer.Form.NFD);
        locationName = locationName.replaceAll("[^\\p{ASCII}]", ""); 
        return locationName.replaceAll("\\s", "").toUpperCase(); 
}


    
    /**
     * Solicita uma corrida por um passageiro.
     * 
     * @param pickupLocation  o local onde o passageiro deseja ser buscado.
     * @param dropLocation    o local onde o passageiro deseja ser deixado.
     * 
     * O status da corrida é definido como "SOLICITADA".
     * O startTime é definido como o horário atual.
     * 
     * Uma mensagem é exibida no console com as informações da corrida.
     * Alerta exceções caso tenha localização invalida,
     */
    public void requestRide(String pickupLocationName, String dropLocationName) {
        this.startTime = LocalDateTime.now();
        this.status = "Solicitada";
        System.out.println(normalizeLocationName(dropLocationName)+normalizeLocationName(pickupLocationName));

        try{
            this.dropLocation = Location.valueOf(normalizeLocationName(dropLocationName));
            this.pickupLocation = Location.valueOf(normalizeLocationName(pickupLocationName));
            calculateDistance();
            System.out.println("Status: " + this.status);
            System.out.println("Corrida solicitada de " + this.pickupLocation.getNome() +
            " para " + this.dropLocation.getNome() + " (" + String.format("%02f", this.rideDistance)+ "km)" +
            " às " + this.startTime.getHour() + ":" + String.format("%02d", this.startTime.getMinute()));
        }
        catch(IllegalArgumentException e){
            if (e.getMessage().contains(normalizeLocationName(dropLocationName))) {
                throw new IllegalArgumentException("Invalid location name: " + dropLocationName);
            } else if (e.getMessage().contains(normalizeLocationName(pickupLocationName))) {
                throw new IllegalArgumentException("Invalid location name: " + pickupLocationName);
            }
        }
        

       
        

    }
    
    
    /**
     * Calcula a distância entre os locais de origem e destino.
     * 
     * A distância é calculada como a distância euclidiana entre os dois pontos.
     * 
     * @return a distância calculada.
     */
     public float calculateDistance() {
        float varx, vary, varf;    
        varx = dropLocation.getCoordenadaX() - pickupLocation.getCoordenadaX();
        vary = dropLocation.getCoordenadaY() - pickupLocation.getCoordenadaY();
        varf = (float) Math.sqrt(Math.pow(varx, 2) + Math.pow(vary, 2));
        float distanceTruncated = (float) ((int) (varf * 100)) / 100;

        this.rideDistance = distanceTruncated;
        return distanceTruncated;
    }
    
    


    /**
     * Atualiza o status da corrida.
     * 
     * Se o status for "Aceita", armazena o ID do motorista e do veiculo que
     * aceitou a corrida.
     * 
     * @param status  o novo status da corrida.
     * @param cabbieId o ID do motorista que aceitou a corrida, se status for
     *                "Aceita" é salvo no objeto, caso contrário não.
     * @param vehicleId o ID do veiculo que aceitou a corrida, se status for
     *                  "Aceita" é salvo no objeto, caso contrário não.
     */
    public void updateRideStatus(String status, String cabbieId, String vehicleId) {
        
        // IMPLEMENTAR METODO UPDATE RIDE STATUS
        if (status.equalsIgnoreCase("ACEITA")){
            this.status =  "em corrida";
            this.cabbieId = cabbieId;
            this.vehicleId = vehicleId;

        }
    }
    /**
     * Finaliza a corrida e faz as mudanças necessárias.
     * @param motora objeto do tipo Cabbie. Usado para poder atualizar a nota do taxista
     * @param fecha boolean usado para saber se é necessário fechar o scanner
     * 
     * Finaliza a corrida e pede a nota para o pessenger a nota.
     * 
     */



    public void completeRide(Cabbie motora, boolean fecha) {
        this.status = "finalizada";
        float note = -1; 
        Scanner sc = new Scanner(System.in);  
        System.err.println("Corrida finalizada.");

        while (note < 0 || note > 5) {
            try {
                System.out.print("Digite a nota do motorista indo de 0 a 5: ");
                note = sc.nextFloat();
                if (note < 0 || note > 5) {
                    System.out.println("Por favor, insira uma nota válida entre 0 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número entre 0 e 5.");
                sc.next();  // Limpar a entrada inválida
            }
        }
        motora.setaval(note);  // Passa a nota para o motorista
        System.out.println("Corrida finalizada");
        if(fecha){
            fecha_scanner(sc);
        }
    }
    /**
     * funcão para fechar o scanner apenas quando é necessário
     * @param sc scan a ser fechado.
     */
    private void fecha_scanner(Scanner sc){
        sc.close();
    }

    
    /**
     * Determina se o objeto dado como parametro é o mesmo que o objeto em si.
     * @param clas É um objeto genérico que pode ou não ser do tipo Cabbie.
     * @return A função retorna verdadeiro ou falso dependendo do objeto dado.
     * Caso seja um objeto igual é verdadeiro, caso seja de outra classe ou outro objeto da mesma classe retorna falso.
     */
    
    public boolean isequals(Object clas){
        if (this.getClass().equals(clas.getClass())){
            Ride prov = (Ride) clas;
            if(this.rideId.equalsIgnoreCase(prov.getRideId())){
                return true;
            }
        }
        return false;
    }
    /**
     * Função que imprimi uma String que representa o Objeto.
     * String com o formato: rideId,passengerId,cabbieId,rideDistance,vehicleId,status.
     * @return uma String que representa um objeto.
     */
    public String toString(){
        return "Ride:"+" "+this.rideId+" "+this.passengerId+" "+this.cabbieId+" "+this.rideDistance+" "+this.vehicleId+" "+this.status;
    }

    
}
