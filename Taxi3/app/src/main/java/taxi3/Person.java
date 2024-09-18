package taxi3;

public abstract class Person{
    //Adicionar os atributos da classe Person
    public String name;
    public String email;
    public String phone;


    // Métodos a serem implementados da classe Person
    public abstract void register();
    public abstract void update(String field, String newValue);
    public abstract String toString();

}