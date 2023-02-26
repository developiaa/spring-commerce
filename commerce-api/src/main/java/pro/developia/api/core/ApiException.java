package pro.developia.api.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 6878108859817666414L;

    private final Code code;

    private final HttpStatus httpStatus;

    public ApiException(Code code) {
        super(code.getMessage());
        this.code = code;
        this.httpStatus = code.getHttpStatus();
    }

    public ApiException(Code code, String message) {
        super(message);
        this.code = code;
        this.httpStatus = code.getHttpStatus();
    }

    public ApiException(Code code, HttpStatus httpStatus) {
        super(code.getMessage());
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(Code code, HttpStatus httpStatus, String message) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(Code code, HttpStatus httpStatus, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(Code code, HttpStatus httpStatus, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
