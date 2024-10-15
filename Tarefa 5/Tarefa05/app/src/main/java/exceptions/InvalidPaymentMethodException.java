package exceptions;
/**
 * Exceção que lida com o erro de dar um metodo de pagamento que não é suportado.
 */


public class InvalidPaymentMethodException extends RuntimeException{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public InvalidPaymentMethodException(String message){
        super(message);
    }
    /**
     * Construção da exceção com mensagem e condição.
     * @param message String a ser mostrada caso a condição seja atendida.
     * @param causa exceção que sera dada como condição.
     */
    public InvalidPaymentMethodException(String message, Throwable causa){
        super(message,causa);
    }
}
