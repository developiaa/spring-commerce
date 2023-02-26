package pro.developia.api.dto.request.config;

import lombok.Getter;

@Getter
public class ConfigCreateRequest {
    private String key;

    private String value;

    private String target;

    private Boolean isUsed;
}
