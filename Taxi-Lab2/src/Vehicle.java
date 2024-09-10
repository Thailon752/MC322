

public class Vehicle {
    private final int vehicleid;
    private final String registrationnumber;
    private final String model;
    private final String year;
    private int cabbieid;


    //Adicionar os atributos da classe Vehicle
    public Vehicle(int vehicleid, String registrationnumber, String model, String year ) {
        this.vehicleid = vehicleid;
        this.registrationnumber = registrationnumber;
        this.model = model;
        this.year = year;
    }
    public void update(int cabbieid){
        this.cabbieid=cabbieid;
    }
    public String getModel() {
        return this.model;
    }
    //Adicionar os métodos da classe VehicleV

    //Adicionar os métodos da classe Vehicle
}
