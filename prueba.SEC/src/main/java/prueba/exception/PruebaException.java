/**
 * 
 */
package prueba.exception;

/**
 * @author juan.arboleda
 *
 */
public class PruebaException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3551944729909835454L;

    /**
     * 
     */
    public PruebaException() {
    }

    /**
     * @param message
     */
    public PruebaException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public PruebaException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public PruebaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PruebaException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
