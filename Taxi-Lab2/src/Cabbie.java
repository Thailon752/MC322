
public class Cabbie extends Person{
    private final int cabbieid;
    private final String licensenumber;
    private float rating;
    private boolean status;
    private int vehicleid;

    //Adicionar os atributos da classe Cabbie

    //Adicionar os métodos da classe Cabbie

    public Cabbie(int cabbieid,String name,String email,String phone,String licensenumber,float rating) {
        super(name, email, phone);

        this.status=true;
        this.licensenumber = licensenumber;
        this.cabbieid = cabbieid;   
        this.rating = rating;
    }

    public void getaval(float avalia){
        calcularating(avalia);
    }
    private void calcularating(float avalia){
        this.rating=((this.rating+avalia)/2);

    }
    public void setveiculo(int Idveiculo){
        this.vehicleid = Idveiculo;
    }
    public int getVehicleId(){
        return this.vehicleid;
    }

    public int getCabbieid() {
        return this.cabbieid;
    }
    public boolean getstatus(){
        return this.status;
    }
    

    public float getRating() {
        return this.rating;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getName() {
        return this.name;
    }
    public String getemail(){
        return this.email;
    }
    public String getphone(){
        return this.phone;
    }
    @Override
    public void update(String field, String newValue){
        if (field.equalsIgnoreCase("name")){
            this.name=newValue;
        }
        if (field.equalsIgnoreCase("email")){
            this.email=newValue;
        }
        if (field.equalsIgnoreCase("phone")){
            this.phone=newValue;
        }
    
    }



}
