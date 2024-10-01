package taxi3;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Person{
    //Adicionar os atributos da classe Person
    public String name;
    public String email;
    public String phone;


    // Métodos a serem implementados da classe Person
    public abstract void register();
    public abstract void update(String field, String newValue);
    public abstract String toString();
    public String getname(){
        return this.name;
    }
    public String getemail(){
        return this.email;
    }
    public String getphone(){
        return this.phone;
    }
}