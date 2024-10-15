package exceptions;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
/**
 * Exceção que lida quando o nome não tem apenas caracteres de letras.
 */

public class LetterFormatException extends IllegalArgumentException{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public LetterFormatException(String message){
        super(message);
    }
     /**
     * Menssagem a ser dada caso haja exceção.
     */
    @OverridingMethodsMustInvokeSuper
    public String getMessage(){
        return "Input contains non-letter characters";

    }
}




