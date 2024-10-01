package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Person é um objeto abstrato que tem suas extensões Passenger e Cabbie
 * Tem seus atributos que vão ser compartilhados com as extenções
 * e eles são nome,email e phone.
 */

@XmlSeeAlso({Passenger.class, Cabbie.class})
@XmlRootElement
public abstract class Person{
    public String name;
    public String email;
    public String phone;

    /**
     * Essas funções são abstratas e vão ser implementadas nas extensões
     * com o @Override para que ela não sejam iguais para as duas extensões
     * a função register, registra uma nova extensão com dados aleatórios
     * a função update, permite que seja atualizado alguns dos atributos das extensões
     * a função toString, printa uma string que simboliza a extensão.
     */
    public abstract void register();
    public abstract void update(String field, String newValue);
    public abstract String toString();
    /**
     * Geters para os atributos
     * @return o atributo do geter.
     */
    @XmlElement
    public String getname(){
        return this.name;
    }
    @XmlElement
    public String getemail(){
        return this.email;
    }
    @XmlElement
    public String getphone(){
        return this.phone;
    }
    
}