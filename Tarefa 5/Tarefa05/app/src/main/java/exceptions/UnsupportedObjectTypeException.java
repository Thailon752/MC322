package exceptions;

//Implement Exception
/**
 * Exceção que lida com o erro de ser dado um Objeto não suportado pelo banco de dados.
 */
public class UnsupportedObjectTypeException extends Exception {
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public UnsupportedObjectTypeException(String message){
        super(message);
    }
    /**
     * Construção da exceção com mensagem e condição.
     * @param message String a ser mostrada caso a condição seja atendida.
     * @param causa exceção que sera dada como condição.
     */
    public UnsupportedObjectTypeException(String message,Throwable cause){
        super(message,cause);
    }
} 
