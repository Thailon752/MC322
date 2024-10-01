package cabbieManager;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import utils.PassengerInfoGenerator;

@XmlRootElement
public class Passenger extends Person{
    private String passengerId;

    /**
     * Registers a passenger by generating random information.
     * This method assigns a random email, name, phone number, and user ID to the passenger.
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
     * Updates a field of the passenger.
     * 
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     * 
     * The valid fields are:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>passengerId</li>
     * </ul>
     * 
     * If the field is not valid, a message is printed and the field is not updated.
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
     * Gets the ID of the passenger.
     * 
     * @return the ID of the passenger (a UUID)
     */
    public String getPassengerId() {
        return this.passengerId;
    }


    /**
     * Returns a string representation of the object.
     * 
     * The format is: "email name phone passengerId"
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format(this.email, this.name, this.phone, this.passengerId);
    }
}
