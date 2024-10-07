package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;

@XmlRootElement(name = "ride")
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

    public Ride() {
    }

    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }

    public void requestRide(String pickupLocation, String dropLocation) {
        this.rideId = UUID.randomUUID().toString();
        this.pickupLocation = this.returnLocation(pickupLocation);
        this.dropLocation= this.returnLocation(dropLocation);
        this.startTime = LocalDateTime.now();

        System.out.println("Corrida chamada por pessoa passageira " + this.passengerId + " de " + pickupLocation + " para " + dropLocation);
        this.updateRideStatus("CHAMADA", null, null);

        this.distance = this.calculateDistance();
    }

    private Location returnLocation(String locationName) {
        return Location.valueOfName(locationName);
    }

    public float calculateDistance() {
        int x_pickup = pickupLocation.getX();
        int y_pickup = pickupLocation.getY();
        int x_drop = dropLocation.getX();
        int y_drop = dropLocation.getY();

        float distance = (float) Math.sqrt(Math.pow(x_drop - x_pickup, 2) + Math.pow(y_drop - y_pickup, 2));
        distance = Math.round(distance * 100) / 100.0f;
        System.out.println(("Distância calculada: " + distance));
        return distance;
    }

    public void updateRideStatus(String status, String cabbieId, String vehicleId) {
        this.status = status;

        if (status.equals("ACEITA")) {
            this.cabbieId = cabbieId;
            this.vehicleId = vehicleId;
            System.out.println(("Corrida aceita por pessoa motorista " + this.cabbieId));
        } else {
            System.out.println("Status da corrida: " + this.status);
        }
    }

    public void completeRide() {
        System.out.println("Corrida finalizada");
    }

    @XmlElement(name = "pickupLocation")
    public Location getPickLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @XmlElement(name = "dropLocation")
    public Location getDropLocation() {
        return this.dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    @XmlElement(name = "rideId")
    public String getRideId() {
        return this.rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name = "startTime")
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    @XmlElement(name = "distance")
    public float getRideDistance() {
        return this.distance;
    }

    @XmlElement(name = "passengerId")
    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    @XmlElement(name = "cabbieId")
    public String getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    @XmlElement(name = "vehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "distance")
    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (o instanceof Ride) {
            Ride ride = (Ride) o;
            return Objects.equal(this.rideId, ride.getRideId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ride: " + this.rideId;
    }
}
