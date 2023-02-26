package pro.developia.api.dto.request.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConfigQueryRequest {
    private String key;

    private String value;

    private String target;

    private Boolean isUsed;
}
