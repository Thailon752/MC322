
public abstract class Person{
    //Adicionar os atributos da classe Person
    protected  String name;
    protected  String email;
    protected  String phone;

    public Person(String name,String email,String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    // Métodos a serem implementados da classe Person
    public abstract void update(String field, String newValue);
    

}