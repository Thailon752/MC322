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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.RidePayment;
import cabbieManager.Ride;
import cabbieManager.Vehicle;


@XmlRootElement
public class Database{
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<RidePayment> Ridepayments = new ArrayList<>();

    private final File file = new File("app/data/database.xml");

    public Database(){

    }
    
    public Database(boolean load){
        if(load){
            load();
        }
        
    }
    @XmlElementWrapper(name="cabbies")
    @XmlElement(name = "cabbie")
    public List<Cabbie> getcabbies() {
        return this.cabbies;
    }
    @XmlElementWrapper(name="passengers")
    @XmlElement(name = "passenger")
    public List<Passenger> getpassengers() {
        return this.passengers;
    }
    @XmlElementWrapper(name="rides")
    @XmlElement(name = "ride")
    public List<Ride> getrides() {
        return this.rides;
    }
    @XmlElementWrapper(name="vehicles")
    @XmlElement(name = "vehicle")
    public List<Vehicle> getvehicles() {
        return this.vehicles;
    }
    @XmlElementWrapper(name="ridePayments")
    @XmlElement(name = "ridePayment")
    public List<RidePayment> getridePayments() {
        return this.Ridepayments;
    }
    

    public void insert(Object object){
        if(object instanceof Passenger){
            this.passengers.add((Passenger) object);
        }
        else if(object instanceof Cabbie){
            this.cabbies.add((Cabbie) object);
        }
        else if(object instanceof Ride){
            this.rides.add((Ride) object);
        }
        else if(object instanceof Vehicle){
            this.vehicles.add((Vehicle) object);
        }
        else if(object instanceof RidePayment){
            this.Ridepayments.add((RidePayment) object);
        }

        this.save();
    }

    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            T item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
                break;
            }
        }
    }

    public void update(Object object){
        if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }
        else if(object instanceof Cabbie){
            this.update((Cabbie) object, this.cabbies);
        }
        else if(object instanceof Vehicle){
            this.update((Vehicle) object, this.vehicles);
        }
        else if(object instanceof Ride){
            this.update((Ride) object, this.rides);
        }
        else if(object instanceof RidePayment){
            this.update((RidePayment) object, this.Ridepayments);
        }
        else{
            return;
        }
        this.save();       
    }

    private void save(){
        if(file.exists()){
            try {
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "app/data/database.xsd");
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
    
        
    
                // Atribua os dados carregados
                this.cabbies = db.getcabbies();
                this.passengers = db.getpassengers();
                this.rides = db.getrides();
                this.vehicles = db.getvehicles();
                this.Ridepayments = db.getridePayments();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}