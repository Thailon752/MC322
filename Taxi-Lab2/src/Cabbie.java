
public class Cabbie extends Person{
    private final int cabbieid;
    private final String licensenumber;
    private float rating;
    private int numaval;
    private boolean status;
    //Adicionar os atributos da classe Cabbie

    //Adicionar os métodos da classe Cabbie

    public Cabbie(int cabbieid,String name,String email,String phone,String licensenumber) {
        super(name, email, phone);
        this.numaval=0;
        status=true;
        this.licensenumber = licensenumber;
        this.cabbieid = cabbieid;
    }

    public void getaval(float avalia){
        calcularating(avalia);
    }
    private void calcularating(float avalia){
        this.numaval=this.numaval+1;
        this.rating=((this.rating+avalia)/this.numaval);

    }

    public int getCabbieid() {
        return cabbieid;
    }
    public boolean getstatus(){
        return this.status;
    }
    

    public float getRating() {
        return rating;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getName() {
        return this.name;
    }
    @Override
    public void update(String field, String newValue){
    
    }



}
