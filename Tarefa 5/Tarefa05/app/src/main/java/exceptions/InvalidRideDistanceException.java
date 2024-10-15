package exceptions;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

/**
 * Exceção que lida com o erro de ser dado uma distancia Nula para o calculo do valor a ser pago.
 */
public class InvalidRideDistanceException extends Exception{
    /**
     * Construtor da exceção com mensagem
     * @param message mensagem a ser dada caso a Exceção aconteça.
     */
    public InvalidRideDistanceException(String message){
        super(message);
    }
    /**
     * Menssagem a ser dada caso haja exceção.
     */
    @OverridingMethodsMustInvokeSuper
    public String getMessage(){
        return "Ride distance must be greater than zero";

    }
    
}