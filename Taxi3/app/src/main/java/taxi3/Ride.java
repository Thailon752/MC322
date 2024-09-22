package taxi3;

import java.time.LocalDateTime;

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
        switch (pickupLocationName.toUpperCase()) {
            case "AEROPORTO":
                this.pickupLocation = Location.AEROPORTO;
                break;
            case "ESTACAO_DE_TREM":
                this.pickupLocation = Location.ESTACAO_DE_TREM;
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
            case "ESTACAO_DE_TREM":
                this.dropLocation = Location.ESTACAO_DE_TREM;
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

        System.out.println("Corrida solicitada de " + this.pickupLocation.getNome() +
                           " para " + this.dropLocation.getNome());
    }


    /**
     * Calculates the distance between the pickup and drop locations.
     * 
     * The distance is calculated as the Euclidean distance between the two points.
     * 
     * @return the calculated distance.
     */

     public float calculateDistance(Location locini, Location locfin) {
        float varx, vary, varf;    
        varx = locfin.getCoordenadaX() - locini.getCoordenadaX();
        vary = locfin.getCoordenadaY() - locini.getCoordenadaY();
        varf = (float) Math.sqrt(Math.pow(varx, 2) + Math.pow(vary, 2));  
        return varf;
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
        this.status = status;
        this.cabbieId = cabbieId;
        this.vehicleId = vehicleId;


    }

    public void completeRide() {
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
