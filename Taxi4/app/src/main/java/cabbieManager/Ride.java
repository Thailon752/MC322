package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * O objeto ride vai ser usado como um intermediario para registrar que a corrida aconteceu.
 * Para isso ela dispoe dos atribustos rideId, passengerId,cabbieId,vehicleId,status,pickupLocation
 * dropLocation,startTime,distance.
 * Cada atributo tem sua fncionalidade implicita no nome.
 */

@XmlRootElement
public class Ride {
    
    private String rideId;
    private String passengerId;
    private String cabbieId;
    private String vehicleId;
    private String status;
    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private float distance;
    /**
     * Construtor da corrida, para existir a corrida so precisa de um passenger.
     * @param passengerId uma String que é o id do passenger.
     */

    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }
    /**
     * Pega o atributo distance.
     * @return o float distance.
     */
    public float getRideDistance() {
        return this.distance;
    }
    /**
     * Pega o atributo startTime.
     * @return LocalDateTime da corrida startTime.
     */
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    /**
     * Pega o atributo rideId.
     * @return a String rideId.
     */
    public String getRideId() {
        return this.rideId;
    }
    /**
     * Pega o atributo cabbieId.
     * @return a String cabbieId.
     */
    public String getCabbieId() {
        return this.cabbieId;
    }
    /**
     * Pega o atributo passengerId.
     * @return a String passengerId.
     */
    public String getPassengerId() {
        return this.passengerId;
    }
    /**
     * Pega o atributo vehicleId .
     * @return a String vehicleId.
     */
    public String getVehicleId() {
        return this.vehicleId;
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
    public String getStatus() {
        return status;
    }
    /**
     * Normaliza a String dada para melhorar ser mais facil ser reconhecida.
     * Método para normalizar o nome da localização (remover acentos e espaços)
     * @param locationName String com o nome do metodo para ser normalizado
     * @return uma String normalizada.
     */
    private String normalizeLocationName(String locationName) {
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
     */
    public void requestRide(String pickupLocationName, String dropLocationName) {
        this.startTime = LocalDateTime.now();
        this.status = "Solicitada";
        pickupLocationName = normalizeLocationName(pickupLocationName);
        dropLocationName = normalizeLocationName(dropLocationName);
        switch (pickupLocationName.toUpperCase()) {
            case "AEROPORTO":
                this.pickupLocation = Location.AEROPORTO;
                break;
            case "ESTACAODETREM":
                this.pickupLocation = Location.ESTAÇÃODETREM;
                break;
            case "SHOPPING":
                this.pickupLocation = Location.SHOPPING;
                break;
            case "ESCOLA":
                this.pickupLocation = Location.ESCOLA;
                break;
            case "PARQUE":
                this.pickupLocation = Location.PARQUE;
                break;
            case "HOSPITAL":
                this.pickupLocation = Location.HOSPITAL;
                break;
            case "BIBLIOTECA":
                this.pickupLocation = Location.BIBLIOTECA;
                break;
            case "ESTADIO":
                this.pickupLocation = Location.ESTADIO;
                break;
            default:
                System.out.println("Localização de pickup não encontrada.");
                return;
        }

        switch (dropLocationName.toUpperCase()) {
            case "AEROPORTO":
                this.dropLocation = Location.AEROPORTO;
                break;
            case "ESTACAODETREM":
                this.dropLocation = Location.ESTAÇÃODETREM;
                break;
            case "SHOPPING":
                this.dropLocation = Location.SHOPPING;
                break;
            case "ESCOLA":
                this.dropLocation = Location.ESCOLA;
                break;
            case "PARQUE":
                this.dropLocation = Location.PARQUE;
                break;
            case "HOSPITAL":
                this.dropLocation = Location.HOSPITAL;
                break;
            case "BIBLIOTECA":
                this.dropLocation = Location.BIBLIOTECA;
                break;
            case "ESTADIO":
                this.dropLocation = Location.ESTADIO;
                break;
            default:
                System.out.println("Localização de drop não encontrada.");
                return;
        }
        calculateDistance();
        System.out.println("Status: " + this.status);
        System.out.println("Corrida solicitada de " + this.pickupLocation.getNome() +
        " para " + this.dropLocation.getNome() + " (" + String.format("%02f", this.distance)+ "km)" +
        " às " + this.startTime.getHour() + ":" + String.format("%02d", this.startTime.getMinute()));

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

        this.distance = distanceTruncated;
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
     * Seta a localização de embarque
     * @param pickupLocation String com o nome da localização
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }


    /**
     *Seta a localização do desembarque
     * @param dropLocation enum location, vai ter as coordenadas e o nome.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
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


    
}
