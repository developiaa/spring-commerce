package pro.developia.commerce.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResult<String>> handlerApiException(ApiException e) {
        Code code = e.getCode();
        String message = e.getMessage();
        HttpStatus httpStatus = e.getHttpStatus();
        return new ResponseEntity<>(ApiResult.fail(code, message), httpStatus);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResult<String>> handleNullPointerException(final NullPointerException e) {
        log.error("handleNullPointerException : {}", e.getMessage());
        return new ResponseEntity<>(ApiResult.fail(Code.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
