package exceptions;

public class LetterFormatException extends IllegalArgumentException{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public LetterFormatException(String message){
        super(message);
    }
    /**
     * Construção da exceção com mensagem e condição.
     * @param message String a ser mostrada caso a condição seja atendida.
     * @param causa exceção que sera dada como condição.
     */
    public LetterFormatException(String message, Throwable causa){
        super(message,causa);
    }
}




