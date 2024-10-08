package cabbieManager;



import databaseManager.Database;

/**
 * Registra novos passageiros, taxistas, veiculos, realiza corridas e pagamentos.
 * E guarda os objetos criados em uma database em Xlm.
 * @author João Pedro Rogeri RA: 242346
 * @author Thailon Mendes de Oliveira RA:266861
 */

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui você deve realizar a simulação do funcionamento do sistema.
        //----------------------------------------------------------------
        Database db = new Database(false);
        
        // Create Instances

        Cabbie cab = new Cabbie();
        cab.register();
        
        Passenger p = new Passenger();
        p.register();

        Vehicle v = new Vehicle(cab.getcabbieId());
        v.registerVehicle();

        // Save Instances into the XML database
        
        db.insert(cab);
        db.insert(p);
        db.insert(v);

        // Update Instances

        cab.update("name", "Martina");
        p.update("name", "Estevão");
        v.updateVehicle("registrationNumber", "ABD123");

        // Save Instancesinto the XML database
        db.update(cab);
        db.update(p);
        db.update(v);

        // Create Ride
        Ride ride = new Ride(db.getpassengers().get(0).getPassengerId());
        ride.requestRide("Shopping", "Estação de Trem");
        db.insert(ride);

        // Accept Ride
        cab.update("isBusy", "true");
        ride.updateRideStatus("ACEITA", cab.getcabbieId(), v.getVehicleId());
        ride.updateRideStatus("EM_PROGRESSO", null, null);

        db.update(cab);
        db.insert(ride);

        //Payment
        RidePayment payment = new RidePayment(ride.getRideId(), ride.getStartTime(), ride.getrideDistance(), "Cartão de Crédito");
        payment.processPayment();
        
        db.insert(payment);

        //Finish Ride
        ride.completeRide(cab,false);
        cab.update("isBusy", "false");

        db.update(ride);
        db.update(cab);


        // Create Ride
        Ride ride_2 = new Ride(db.getpassengers().get(0).getPassengerId());
        ride_2.requestRide("Parque", "Biblioteca");

        db.insert(ride_2);
    

        // Accept Ride
        cab.update("isBusy", "true");
        ride_2.updateRideStatus("ACEITA", cab.getcabbieId(), v.getVehicleId());
        ride_2.updateRideStatus("EM_PROGRESSO", null, null);

        db.update(cab);
        db.update(ride_2);

        //Payment
        RidePayment payment2 = new RidePayment(ride_2.getRideId(), ride_2.getStartTime(), ride_2.getrideDistance(), "Pix");
        payment2.processPayment();

        db.insert(payment2);

        //Finish Ride
        ride.completeRide(cab,true);
        cab.update("isBusy", "false");

        db.update(ride);
        db.update(cab);

        System.out.println("-----------------------------------");
        System.out.println("Fechando e reabrindo banco de dados\n");

        db = new Database(true);

        System.out.println("Printando dados:");
        System.out.println(db.getpassengers());
        System.out.println(db.getcabbies());
        System.out.println(db.getvehicles());
        System.out.println(db.getrides());
        System.out.println(db.getridePayments());

        System.out.println("-----------------------------------\n");
        System.out.println("Realizando nova corrida:");
        // Create Ride
        
    }
}
