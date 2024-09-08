
public class Cabbie extends Person{
    private final int cabbieid;
    private final String licensenumber;
    private float rating;
    //Adicionar os atributos da classe Cabbie

    //Adicionar os métodos da classe Cabbie

    public Cabbie(int cabbieid,String name,String email,String phone,String licensenumber) {
        super(name, email, phone);
        this.licensenumber = licensenumber;
        this.cabbieid = cabbieid;
    }
    
    

    @Override
    public void update(String field, String newValue){
    
    }



}
