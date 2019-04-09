package page.exception;

/**
 * Created by wangyang on 2019/4/9.
 */
public class MathException extends RuntimeException {

    public MathException() {
    }

    public MathException(String message) {
        super(message);
    }

    public MathException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathException(Throwable cause) {
        super(cause);
    }
}
