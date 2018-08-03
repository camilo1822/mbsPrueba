/**
 * 
 */
package prueba.exception;

import prueba.jpa.util.ConstantJPA;

/**
 * @author juan.arboleda
 *
 */
public class JPAException extends Exception {

    private static StringBuilder errorType;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public JPAException() {
    }

    /**
     * @param message
     */
    public JPAException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public JPAException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public JPAException(EnumJPAException tipo, String message,
            Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     */
    public JPAException(String message, Throwable cause) {
        super(message, cause);
        errorType = new StringBuilder(ConstantJPA.DATABASE_OPERATION_ERROR);
        errorType.append(message);
    }

    /**
     * Retorn el error que se construyó en el Constructor
     * 
     * @return
     */
    public String getErrorDesc() {
        return errorType.toString();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public JPAException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
