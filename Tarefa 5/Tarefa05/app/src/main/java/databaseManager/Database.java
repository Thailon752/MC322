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
import exceptions.UnsupportedObjectTypeException;

/**
 * Objeto que funciona como banco de dados.
 * Contém listas de Passenger, Cabbie, Ride, Vehicle, RidePayment.
 */
@XmlRootElement
public class Database {
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<RidePayment> Ridepayments = new ArrayList<>();

    private final File file = new File("app/data/database.xml");

    public Database() {

    }

    /**
     * Construtor que ou carrega o banco de dados existente ou cria um novo.
     * 
     * @param load boolean que indica se vai carregar o banco de dados existente ou criar um novo
     */
    public Database(boolean load) {
        if (load) {
            load();
        }
    }

    /**
     * Retorna a lista de motoristas cadastrados (Cabbie).
     * 
     * @return Lista de objetos Cabbie.
     */
    @XmlElementWrapper(name = "cabbies")
    @XmlElement(name = "cabbie")
    public List<Cabbie> getcabbies() {
        return this.cabbies;
    }

    /**
     * Retorna a lista de passageiros cadastrados (Passenger).
     * 
     * @return Lista de objetos Passenger.
     */
    @XmlElementWrapper(name = "passengers")
    @XmlElement(name = "passenger")
    public List<Passenger> getpassengers() {
        return this.passengers;
    }

    /**
     * Retorna a lista de corridas registradas (Ride).
     * 
     * @return Lista de objetos Ride.
     */
    @XmlElementWrapper(name = "rides")
    @XmlElement(name = "ride")
    public List<Ride> getrides() {
        return this.rides;
    }

    /**
     * Retorna a lista de veículos cadastrados (Vehicle).
     * 
     * @return Lista de objetos Vehicle.
     */
    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "vehicle")
    public List<Vehicle> getvehicles() {
        return this.vehicles;
    }

    /**
     * Retorna a lista de pagamentos de corrida registrados (RidePayment).
     * 
     * @return Lista de objetos RidePayment.
     */
    @XmlElementWrapper(name = "ridePayments")
    @XmlElement(name = "ridePayment")
    public List<RidePayment> getridePayments() {
        return this.Ridepayments;
    }

    /**
     * Verifica se o objeto fornecido é uma das classes suportadas pelo banco de dados.
     * 
     * @param obj Objeto a ser verificado.
     * @return true se o objeto for uma das classes suportadas, false caso contrário.
     */
    private boolean existe(Object obj) {
        return obj instanceof Cabbie || obj instanceof Passenger || obj instanceof Ride ||
                obj instanceof RidePayment || obj instanceof Vehicle;
    }

    /**
     * Insere um novo objeto no banco de dados.
     * Se o tipo do objeto não for suportado, lança uma exceção.
     * 
     * @param object Objeto a ser inserido.
     * @throws UnsupportedObjectTypeException se o tipo de objeto não for suportado.
     */
    public void insert(Object object) throws UnsupportedObjectTypeException {
        if (!existe(object)) {
            throw new UnsupportedObjectTypeException("Trying to insert unsupported object type for database insertion");
        }
        if (object instanceof Passenger) {
            this.passengers.add((Passenger) object);
        } else if (object instanceof Cabbie) {
            this.cabbies.add((Cabbie) object);
        } else if (object instanceof Ride) {
            this.rides.add((Ride) object);
        } else if (object instanceof Vehicle) {
            this.vehicles.add((Vehicle) object);
        } else if (object instanceof RidePayment) {
            this.Ridepayments.add((RidePayment) object);
        }
        System.out.println("Salvando...");
        this.save();
    }

    /**
     * Atualiza um objeto existente no banco de dados.
     * 
     * @param <T> Tipo do objeto a ser atualizado.
     * @param newItem Novo item que substituirá o antigo.
     * @param data Lista de objetos onde o item será atualizado.
     */
    private <T> void update(T newItem, List<T> data) {
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);

            if (item.equals(newItem)) {
                data.set(i, newItem);
                break;
            }
        }
    }

    /**
     * Atualiza um objeto no banco de dados com base no seu tipo.
     * 
     * @param object Objeto a ser atualizado.
     */
    public void update(Object object) {
        if (object instanceof Passenger) {
            this.update((Passenger) object, this.passengers);
        } else if (object instanceof Cabbie) {
            this.update((Cabbie) object, this.cabbies);
        } else if (object instanceof Vehicle) {
            this.update((Vehicle) object, this.vehicles);
        } else if (object instanceof Ride) {
            this.update((Ride) object, this.rides);
        } else if (object instanceof RidePayment) {
            this.update((RidePayment) object, this.Ridepayments);
        } else {
            return;
        }
        this.save();
    }

    /**
     * Salva o estado atual do banco de dados no arquivo XML.
     */
    private void save() {
        if (file.exists()) {
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

    /**
     * Carrega o banco de dados a partir do arquivo XML.
     * Substitui os dados atuais pelos dados carregados.
     */
    private void load() {
        if (file.exists()) {
            try {
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                InputStream inputStream = new FileInputStream(this.file);
                Database db = (Database) unmarshaller.unmarshal(inputStream);
                inputStream.close();

                // Atribui os dados carregados
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
