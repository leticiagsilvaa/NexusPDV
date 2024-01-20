package supermercado.negocio.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String msg){
        super(msg);
    }
}
