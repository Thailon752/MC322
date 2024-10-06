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
    protected String name;
    protected String email;
    protected String phone;

    /**
     * Essas funções são abstratas e vão ser implementadas nas extensões
     * com o @Override para que ela não sejam iguais para as duas extensões
     * a função register, registra uma nova extensão com dados aleatórios
     * a função update, permite que seja atualizado alguns dos atributos das extensões
     * a função toString, printa uma string que simboliza a extensão.
     * a função isequals compara o objeto com outro dado.
     */
    public abstract void register();
    public abstract void update(String field, String newValue);
    public abstract String toString();
    public abstract boolean isequals(Object clas);
    /**
     * Pega o atributo nome.
     * @return uma String name da pessoa.
     */
    @XmlElement
    public String getname(){
        return this.name;
    }
    /**
     * Pega o atributo email.
     * @return uma String email da pessoa.
     */
    @XmlElement
    public String getemail(){
        return this.email;
    }
    /**
     * Pega o atributo phone.
     * @return uma String phone da pessoa.
     */
    @XmlElement
    public String getphone(){
        return this.phone;
    }
    
    
}