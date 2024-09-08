
public class Passenger extends Person{
    //Adicionar os atributos da classe Passenger
    private final int  userid;

    //Adicionar os métodos da classe Passenger

    public Passenger(int userid,String name,String email,String phone) {
        super(name, email, phone); 
        this.userid=userid;
    }
    public int getUserid() {
        return userid;
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
