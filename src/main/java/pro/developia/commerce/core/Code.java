package pro.developia.commerce.core;

import org.springframework.http.HttpStatus;

public enum Code {
    SUCCESS(0, HttpStatus.OK, "success"),
    CREATED(1, HttpStatus.CREATED, "success"),
    BAD_REQUEST(2, HttpStatus.BAD_REQUEST, "bad_request"),
    UNAUTHENTICATED(3, HttpStatus.UNAUTHORIZED, "unauthenticated"),
    UNAUTHORIZED(4, HttpStatus.FORBIDDEN, "forbidden"),
    NOT_FOUND(5, HttpStatus.NOT_FOUND, "not_found"),
    TIMEOUT(990, HttpStatus.REQUEST_TIMEOUT, "timeout");

    private Integer id;
    private HttpStatus httpStatus;
    private String message;

    Code(Integer id, HttpStatus httpStatus, String message) {
        this.id = id;
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
