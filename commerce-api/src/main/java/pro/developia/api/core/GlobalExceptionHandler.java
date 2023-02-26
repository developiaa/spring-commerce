package pro.developia.api.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResult<String>> apiExceptionHandler(ApiException e) {
        Code code = e.getCode();
        String message = e.getMessage();
        HttpStatus httpStatus = e.getHttpStatus();
        return new ResponseEntity<>(ApiResult.fail(code, message), httpStatus);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResult<String>> nullPointerExceptionHandler(final NullPointerException e) {
        log.error("nullPointerExceptionHandler : {}", e.getMessage());
        return new ResponseEntity<>(ApiResult.fail(Code.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult<String>> methodArgumentNotValidExceptionHandler(Exception e) {
        log.error("methodArgumentNotValidExceptionHandler : {}", e.getMessage());
        return new ResponseEntity<>(ApiResult.fail(Code.BAD_REQUEST,
                ((MethodArgumentNotValidException) e).getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
