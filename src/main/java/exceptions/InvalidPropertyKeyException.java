package exceptions;

/**
 * Exception to be thrown when an invalid property key is passed
 */
public class InvalidPropertyKeyException extends RuntimeException {

    public InvalidPropertyKeyException(String message) {
        super(message);
    }
}
