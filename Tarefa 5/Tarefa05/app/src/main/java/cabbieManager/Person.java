package cabbieManager;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Person é um objeto abstrato que tem suas extensões Passenger e Cabbie
 * Tem seus atributos que vão ser compartilhados com as extenções
 * e eles são nome,email e phone.
 */
@XmlRootElement
@XmlSeeAlso({Passenger.class, Cabbie.class})
public abstract class Person{
    protected String name;
    protected String email;
    protected String phone;

    /**
     * a função register, registra uma nova extensão com dados aleatórios.
     * 
     */
    public abstract void register();
    /**
     * a função update, permite que seja atualizado alguns dos atributos das extensões.
     * @param field atributo a ser atualizado. São dados em forma de string.
     * @param newValue novo atributo. São dados tem forma de string.
     */
    public abstract void update(String field, String newValue);
    /**
     * a função toString, printa uma string que simboliza o objeto.
     * @return String que representa o objeto.
     */
    public abstract String toString();
    /**
     * a função isequals verifica se o objeto dado é igual ao objeto que chamou a função
     * @param clas objeto a ser comparado.
     * @return retorna um boolean, true caso for igual e false caso for diferente.
     */
    public abstract boolean isequals(Object clas);
    
    
    
}