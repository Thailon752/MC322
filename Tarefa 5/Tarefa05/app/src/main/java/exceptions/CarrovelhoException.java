package exceptions;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class CarrovelhoException extends Exception{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public CarrovelhoException(String message){
        super(message);
    }
     /**
     * Menssagem a ser dada caso haja exceção.
     */
    @OverridingMethodsMustInvokeSuper
    public String getMessage(){
        return "data errada ou carro muito velho";

    }
}


