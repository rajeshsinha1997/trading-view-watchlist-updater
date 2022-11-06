package exceptions;

/**
 * Exception to be thrown when an unsupported browser name is passed
 */
public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException(String message) {
        super(message);
    }
}
