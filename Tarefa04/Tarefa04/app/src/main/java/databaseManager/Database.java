package databaseManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.Ride;
import cabbieManager.RidePayment;
import cabbieManager.Vehicle;

@XmlRootElement
public class Database{
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<RidePayment> ridepayments = new ArrayList<>();

    private final File file = new File("Tarefa04/app/data/database.xml");

    public Database() {
    
    }

    public Database(boolean load){
        if(load){
            this.load();
        }
    }

    @XmlElement
    public List<Passenger> getPassengers(){
        return this.passengers;
    }

    @XmlElement
    public List<Cabbie> getCabbies(){
        return this.cabbies;
    }

    @XmlElement
    public List<Ride> getRides(){
        return this.rides;
    }

    @XmlElement
    public List<Vehicle> getVehicles(){
        return this.vehicles;
    }

    @XmlElement
    public List<RidePayment> getRidePayments(){
        return this.ridepayments;
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
        try {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputStream = new FileOutputStream(this.file);
            marshaller.marshal(this, outputStream);
            outputStream.close();

                
        } catch (JAXBException | IOException e) {
                e.printStackTrace();
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
                this.ridepayments = db.getRidePayments();
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
