package pro.developia.commerce.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Code {
    SUCCESS("S000", HttpStatus.OK, "Success"),
    CREATED("S001", HttpStatus.CREATED, "Created"),
    BAD_REQUEST("E400", HttpStatus.BAD_REQUEST, "Bad request"),
    UNAUTHENTICATED("E401", HttpStatus.UNAUTHORIZED, "Unauthenticated"),
    UNAUTHORIZED("E403", HttpStatus.FORBIDDEN, "Forbidden"),
    NOT_FOUND("E404", HttpStatus.NOT_FOUND, "Not found"),
    TIMEOUT("E408", HttpStatus.REQUEST_TIMEOUT, "Timeout"),
    INTERNAL_SERVER_ERROR("E500", HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

    PRODUCT_OUT_OF_STOCK("E1000", HttpStatus.BAD_REQUEST, "상품 재고가 부족합니다."),
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

    Code(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
