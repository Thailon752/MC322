package cabbieManager;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import databaseManager.*;
import exceptions.*;
@SuppressWarnings("unused")
public class HackerTest {

    //IMPLEMENTE ABAIXO OS TESTES UNITÁRIOS ADICIONAIS PARA OS 3 TRATAMENTOS DE ERRO IDENTIFICADOS
    

    //-----------------------------------------------------------------------------------------------------
    // CONJUNTO DE TESTES JÁ FEITO PARA A TAREFA (NÃO PODE SER ALTERADO)
    
    

    /**
     * Tests if the method update throws an IllegalArgumentException when the phone number is not valid.
     * 
     * The method update should throw an IllegalArgumentException when the phone number is not valid.
     * 
     * This test case tests this by calling the method update with an invalid phone number and asserting that an IllegalArgumentException is thrown.
     * The expected error message is "Input contains non-numeric characters: 999999999a"
     */
    @Test
    public void testUpdateCabbie_throwsIllegalArgumentException_InvalidPhoneArgument() {
        Cabbie cabbieTest = new Cabbie();
        cabbieTest.register();
        

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cabbieTest.update("phone", "999999999a"); 
        });

        assertEquals("Input contains non-numeric characters: 999999999a", exception.getMessage());
    }

    /**
     * Tests if the method requestRide throws an IllegalArgumentException when the drop location is not one of the valid locations.
     * 
     * The method requestRide should throw an IllegalArgumentException when the drop location is not one of the valid locations.
     * 
     * This test case tests this by calling the method requestRide with an invalid drop location and asserting that an IllegalArgumentException is thrown.
     * The expected error message is "Invalid location name: Museu".
     */
    @Test
    public void testRide_thorwsIllegalArgumentException_InvalidDropLocation() {
        Ride testRide = new Ride();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testRide.requestRide("Aeroporto", "Museu"); // Invalid phone number with non-numeric characters
        });

        assertEquals("Invalid location name: Museu", exception.getMessage());

    }

    

    /**
     * Tests if the constructor RidePayment throws a NullPointerException when the start time of the ride to be paid is null.
     * 
     * The constructor RidePayment should throw a NullPointerException when the start time of the ride to be paid is null.
     * This test case tests this by calling the constructor with a null start time and asserting that a NullPointerException is thrown.
     * The expected error message is "Start time of the ride to be paid cannot be null".
     */
    @Test
    public void testRidPayment_throwsNullPointforStartTime() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            RidePayment rpTest = new RidePayment("rideId", null, 5.0f, "Dinheiro"); // Invalid phone number with non-numeric characters
        });

        assertEquals("Start time of the ride to be paid cannot be null", exception.getMessage());
    }

    /**
     * Tests if the method insert from the class Database throws an UnsupportedObjectTypeException when trying to insert an object of an unsupported type.
     * 
     * The method insert should throw an UnsupportedObjectTypeException when trying to insert an object of an unsupported type.
     * This test case tests this by calling the method insert with an object of an unsupported type and asserting that an UnsupportedObjectTypeException is thrown.
     * The expected error message is "Trying to insert unsupported object type for database insertion".
     */
    @Test
    public void testDatabase_InsertIllegalTypeObject() {
        Location loc = Location.AEROPORTO;
        Database db = new Database();
        Exception exception = assertThrows(UnsupportedObjectTypeException.class, () -> {
            db.insert(loc);
        });

        assertEquals("Trying to insert unsupported object type for database insertion", exception.getMessage());


    }

    /**
     * Tests if the constructor RidePayment throws an InvalidRideDistanceException when the ride distance is equal to zero.
     * 
     * The constructor RidePayment should throw an InvalidRideDistanceException when the ride distance is equal to zero.
     * This test case tests this by calling the constructor with a ride distance of zero and asserting that an InvalidRideDistanceException is thrown.
     * The expected error message is "Ride distance must be greater than zero".
     */
    @Test
    public void testRidePayment_throwsInalidRideDistanceEqualsZero() {
    
        Exception exception = assertThrows(InvalidRideDistanceException.class, () -> {
            RidePayment rp = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 0.0f, "Dinheiro");
        });

        assertEquals("Ride distance must be greater than zero", exception.getMessage());
    
    
    }
    /**
     * Tests if the constructor RidePayment throws an InvalidPaymentMethodException 
     * when an unsupported payment method is used.
     * 
     * The constructor RidePayment should throw an InvalidPaymentMethodException when
     * the payment method is not one of the supported types.
     * 
     * This test case tests this by calling the constructor with an unsupported payment method 
     * and asserting that an InvalidPaymentMethodException is thrown.
     * The expected error message is "The PaymentMethod Cash is not supported".
     */
    @Test
    public void test_method(){
        Exception exception = assertThrows(InvalidPaymentMethodException.class, () -> {
            RidePayment rp = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 3.0f, "Cash");
        });
        assertEquals("The PaymentMethod Cash is not suported", exception.getMessage());
    }

    /**
     * Tests if the method update from the class Cabbie throws a LetterFormatException 
     * when the name contains non-letter characters.
     * 
     * The method update should throw a LetterFormatException when the name is invalid.
     * This test case tests this by calling the update method with a name containing numeric characters 
     * and asserting that a LetterFormatException is thrown.
     * The expected error message is "Input contains non-letter characters".
     */
    @Test
    public void test_name() {
        Exception exception2 = assertThrows(LetterFormatException.class, () -> {
            Cabbie cb = new Cabbie();
            cb.update("name", "joao1"); // Passa um nome inválido contendo um número
        });
    
        assertEquals("Input contains non-letter characters", exception2.getMessage());
    }

    /**
     * Tests if the method updateVehicle throws a CarrovelhoException when the 
     * year provided for the vehicle is too old or incorrectly formatted.
     * 
     * The method updateVehicle should throw a CarrovelhoException when the year 
     * is invalid (e.g., the year is too far in the past or improperly formatted).
     * This test case tests this by calling updateVehicle with an invalid year 
     * and asserting that a CarrovelhoException is thrown.
     * The expected error message is "data errada ou carro muito velho".
     */
    @Test
    public void test_year() {
        Exception exception = assertThrows(CarrovelhoException.class, () -> {
            Vehicle ve = new Vehicle();
            ve.updateVehicle("year", "199"); // Passa uma data inválida contendo um número
        });
    
        assertEquals("data errada ou carro muito velho", exception.getMessage());
    }

    /**
     * Tests if the method update from the class Cabbie throws an EmailFormatException 
     * when the email provided is not in a valid format.
     * 
     * The method update should throw an EmailFormatException when the email 
     * does not contain the necessary "@" symbol.
     * This test case tests this by calling the update method with an invalid email 
     * and asserting that an EmailFormatException is thrown.
     * The expected error message is "Email invalido".
     */
    @Test
    public void test_email() {
        Exception exception = assertThrows(EmailFormatException.class, () -> {
            Passenger pb = new Passenger();
            pb.update("email", "thailonmendesgmail.com"); // Passa um email inválido sem o '@'
        });
    
        assertEquals("Email invalido", exception.getMessage());
    }







}
