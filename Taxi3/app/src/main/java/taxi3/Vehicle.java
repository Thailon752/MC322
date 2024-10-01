package taxi3;
import javax.xml.bind.annotation.XmlRootElement;

import utils.VehicleInfoGenerator;

@XmlRootElement
public class Vehicle {
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private String cabbieId;
    


    public Vehicle(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Registers a vehicle by generating random information.
     * This method assigns a random ID, registration number, model and year to the vehicle.
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
     * Updates a field of the Vehicle.
     * 
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     * 
     * The valid fields are:
     * <ul>
     * <li>vehicleId</li>
     * <li>registrationNumber</li>
     * <li>model</li>
     * <li>year</li>
     * </ul>
     * 
     * If the field is not valid, a message is printed and the field is not updated.
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
     * Returns a string representation of the Vehicle.
     * 
     * @return a string containing the ID, registration number, model, year and
     *         cabbie ID of the vehicle, separated by commas.
     */

    public String toString() {
        return String.format(this.vehicleId, this.registrationNumber, this.model, this.year, this.cabbieId);
    }

    /**
     * Gets the ID of the Vehicle.
     * 
     * @return the ID of the vehicle (a UUID)
     */
    public String getVehicleId() {
        return this.vehicleId;
    }
}
