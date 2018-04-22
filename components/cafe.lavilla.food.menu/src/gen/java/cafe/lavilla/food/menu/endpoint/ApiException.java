package cafe.lavilla.food.menu.endpoint;

//comment
public class ApiException extends Exception {
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
