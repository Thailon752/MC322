package databaseManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.RidePayment;
import cabbieManager.Ride;
import cabbieManager.Vehicle;

public class Database{
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<RidePayment> Ridepayments = new ArrayList<>();




    
    private final File file = new File("app/data/database.xml");

    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    
    public List<Passenger> getPassengers(){
        return this.passengers;
    }
    public List<Cabbie> getCabbies(){
        return this.cabbies;
    }
    public List<Ride> getRides(){
        return this.rides;

    }
    public List<Vehicle> getVehicles(){
        return this.vehicles;
    }
    public List<RidePayment> getRidePayments(){
        return this.Ridepayments;
    }

    public void insert(Object object){
        if(object instanceof Passenger){
            this.passengers.add((Passenger) object);
        }

        this.save();
    }

    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }

    public void update(Object object){
        if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }else{
            return;
        }
        this.save();       
    }

    private void save(){
        if(file.exists()){
            try {
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                OutputStream outputStream = new FileOutputStream(this.file);
                marshaller.marshal(this, outputStream);
                outputStream.close();

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void load() {
        if (file.exists()) {
            try {
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                InputStream inputStream = new FileInputStream(this.file);
                Database db = (Database) unmarshaller.unmarshal(inputStream);
                inputStream.close();
                this.cabbies = db.getCabbies();
                this.passengers = db.getPassengers();
                this.rides = db.getRides();
                this.vehicles = db.getVehicles();
                this.Ridepayments = db.getRidePayments();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}