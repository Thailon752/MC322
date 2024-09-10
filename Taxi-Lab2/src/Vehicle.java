

public class Vehicle {
    private final int vehicleid;
    private final String registrationnumber;
    private final String model;
    private final String year;
    private int cabbieid;


    //Adicionar os atributos da classe Vehicle
    public Vehicle(int vehicleid, String registrationnumber, String model, String year,int cabbieid ) {
        this.vehicleid = vehicleid;
        this.registrationnumber = registrationnumber;
        this.model = model;
        this.year = year;
        this.cabbieid = cabbieid;
    }
    public String getModel() {
        return this.model;
    }
    public int getCabbieid() {
        return this.cabbieid;
    }
    public String getYear() {
        return this.year;
    }
    public int getVehicleid() {
        return this.vehicleid;
    }
    public String getRegistrationnumber() {
        return this.registrationnumber;
    }
    //Adicionar os métodos da classe VehicleV

    //Adicionar os métodos da classe Vehicle
}
