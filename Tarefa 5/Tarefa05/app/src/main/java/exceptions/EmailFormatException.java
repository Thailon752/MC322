package exceptions;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class EmailFormatException extends IllegalArgumentException{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public EmailFormatException(String message){
        super(message);
    }
     /**
     * Menssagem a ser dada caso haja exceção.
     */
    @OverridingMethodsMustInvokeSuper
    public String getMessage(){
        return "Email invalido";

    }
}


