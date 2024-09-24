package taxi3;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ride {
    
    private String rideId;
    private String passengerId;
    private String cabbieId;
    private String vehicleId;
    private String status;

    // Adcionar campos do Trabalho3
    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private float distance;


    //Adicionar os métodos da classe Ride


    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * Requests a ride by a passenger.
     * 
     * @param pickupLocation  the location where the passenger wants to be picked up
     * @param dropLocation    the location where the passenger wants to be dropped off
     * 
     * The ride status is set to "REQUESTED".
     * The startTime is set to the current time.
     * 
     * A message is printed to the console with the information of the ride.
     */
    public String getCabbieId() {
        return cabbieId;
    }
    // Método para normalizar o nome da localização (remover acentos e espaços)
    private String normalizeLocationName(String locationName) {
        locationName = Normalizer.normalize(locationName, Normalizer.Form.NFD);
        locationName = locationName.replaceAll("[^\\p{ASCII}]", ""); 
        return locationName.replaceAll("\\s", "").toUpperCase(); 
}


    public String getPassengerId() {
        return passengerId;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getStatus() {
        return status;
    }
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
     * Calculates the distance between the pickup and drop locations.
     * 
     * The distance is calculated as the Euclidean distance between the two points.
     * 
     * @return the calculated distance.
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
     * Se o status for "ACEPTED", armazena o ID do motorista e do veiculo que
     * aceitou a corrida.
     * 
     * @param status  o novo status da corrida
     * @param cabbieId o ID do motorista que aceitou a corrida, se status for
     *                "ACCEPTED"
     * @param vehicleId o ID do veiculo que aceitou a corrida, se status for
     *                  "ACCEPTED"
     */
    public void updateRideStatus(String status, String cabbieId, String vehicleId) {
        
        // IMPLEMENTAR METODO UPDATE RIDE STATUS
        if (status.equalsIgnoreCase("ACEITA")){
            this.status =  "em corrida";
            this.cabbieId = cabbieId;
            this.vehicleId = vehicleId;

        }
        


    }
    public void completeRide(Cabbie motora) {
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
        motora.getaval(note);  // Passa a nota para o motorista
        System.out.println("Corrida finalizada");
    }

    /**
     * Sets the pickup location of this ride.
     * @param pickupLocation The new pickup location.
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }


    /**
     * Sets the drop location of this ride.
     * @param dropLocation The new drop location.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    /**
     * Gets the ID of this ride.
     * 
     * @return the ID of this ride (a UUID)
     */
    public String getRideId() {
        return this.rideId;
    }

    /**
     * Gets the start time of this ride.
     * 
     * @return the start time of this ride (a LocalDateTime)
     */
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the distance of this ride.
     * 
     * @return the distance of this ride (a float)
     */
    public float getRideDistance() {
        // TODO Auto-generated method stub
        return this.distance;
    }


    
}
