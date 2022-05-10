package pro.developia.commerce.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

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


    public ApiResult<T> code(@NotNull Code code) {
        this.code = code;
        return this;
    }

    public ApiResult<T> message(T message) {
        this.message = message;
        return this;
    }

    public static <T> ApiResult<T> ok() {
        return ok(null, null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return ok(data, null);
    }

    public static <T> ApiResult<T> ok(T data, T message) {
        return with(data).code(Code.SUCCESS).message(message);
    }

    public static <T> ApiResult<T> with(T data) {
        ApiResult<T> result = new ApiResult<>();
        result.data = data;
        result.time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return result;
    }
}
