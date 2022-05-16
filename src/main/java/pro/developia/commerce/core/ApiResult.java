package pro.developia.commerce.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
public class ApiResult<T> {

    private ZonedDateTime time;

    private Code code;

    private T data;

    private T message;

    @JsonIgnore
    private HttpStatus httpStatus;

    public ApiResult<T> code(@NotNull Code code) {
        this.code = code;
        return this;
    }

    public ApiResult<T> message(T message) {
        this.message = message;
        return this;
    }

    public ApiResult<T> httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public static <T> ApiResult<T> ok() {
        return ok(null, null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return ok(data, null);
    }

    public static <T> ApiResult<T> ok(T data, T message) {
        return with(data).code(Code.SUCCESS).message(message).httpStatus(HttpStatus.OK);
    }

    public static <T> ApiResult<T> with(T data) {
        ApiResult<T> result = new ApiResult<>();
        result.data = data;
        result.time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return result;
    }

    public static <T> ApiResult<T> fail(Code code) {
        return with((T) null).code(code).httpStatus(code.getHttpStatus());
    }

    public static <T> ApiResult<T> fail(Code code, T message) {
        return with((T) null).code(code).message(message).httpStatus(code.getHttpStatus());
    }

    public static <T> ApiResult<T> fail(Code code, T message, HttpStatus httpStatus) {
        return with((T) null).code(code).message(message).httpStatus(httpStatus);
    }

    public ResponseEntity createResponseEntity() {
        return ResponseEntity.status(this.httpStatus).body(this);
    }
}
