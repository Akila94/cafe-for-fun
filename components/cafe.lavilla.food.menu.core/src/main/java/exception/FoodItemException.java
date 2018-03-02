package exception;

/**
 * Exception that throws from the DAO layer.
 */
public class FoodItemException extends Exception {
    private String errorCode;

    public FoodItemException() {
        super();
    }

    public FoodItemException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FoodItemException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
