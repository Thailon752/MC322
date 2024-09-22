package taxi3;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public void requestRide(String pickupLocation, String dropLocation) {

        // IMPLEMENTAR METODO REQUEST RIDE (JAVADOC PARA GUIAR SE PRECISAR)
    }


    /**
     * Calculates the distance between the pickup and drop locations.
     * 
     * The distance is calculated as the Euclidean distance between the two points.
     * 
     * @return the calculated distance.
     */
    public float calculateDistance() {
        return 1;
        // IMPLEMENTAR METODO CALCULATE DISTANCE
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
