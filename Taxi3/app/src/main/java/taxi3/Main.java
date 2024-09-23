package taxi3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        //Aqui você deve realizar a simulação do funcionamento do sistema.
        //----------------------------------------------------------------

        List<Cabbie> availableCabbies = new ArrayList<>();
        List<Cabbie> inUsageCabbies = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        ArrayList<RidePayment> pagamentos = new ArrayList<>();
        // Create Instances

        Cabbie cab = new Cabbie();
        cab.register();
        
        Passenger p = new Passenger();
        p.register();

        Vehicle v = new Vehicle(cab.getCabbieId());
        v.registerVehicle();

        // Save Instances

        availableCabbies.add(cab);
        passengers.add(p);
        vehicles.add(v);


        // Update Instances

        cab.update("name", "Martina");
        p.update("name", "Estevão");
        v.updateVehicle("registrationNumber", "ABD123");


        // Create Ride
        Ride ride = new Ride(passengers.get(0).getPassengerId());
        ride.requestRide("Shopping", "Estação de Trem");

        // Accept Ride
        inUsageCabbies.add(cab);
        availableCabbies.remove(0);
        ride.updateRideStatus("ACEITA", inUsageCabbies.get(0).getCabbieId(), vehicles.get(0).getVehicleId());
        ride.updateRideStatus("EM_PROGRESSO", null, null);


        //Payment
        RidePayment payment = new RidePayment(ride.getRideId(), ride.getStartTime(), ride.getRideDistance(), "Cartão de Crédito");
        payment.processPayment(pagamentos);

        //Finish Ride
        ride.completeRide(cab);
        inUsageCabbies.remove(0);
        availableCabbies.add(cab);


         // Create Ride
         Ride ride_2 = new Ride(passengers.get(0).getPassengerId());
         ride_2.requestRide("Parque", "Biblioteca");
 
         // Accept Ride
         inUsageCabbies.add(cab);
         availableCabbies.remove(0);
         ride_2.updateRideStatus("ACEITA", inUsageCabbies.get(0).getCabbieId(), vehicles.get(0).getVehicleId());
         ride_2.updateRideStatus("EM_PROGRESSO", null, null);
 
 
         //Payment
         RidePayment payment2 = new RidePayment(ride_2.getRideId(), ride_2.getStartTime(), ride_2.getRideDistance(), "Pix");
         payment2.processPayment(pagamentos);
 
         //Finish Ride
         ride.completeRide(cab);
         inUsageCabbies.remove(0);
         availableCabbies.add(cab);

    }
}
