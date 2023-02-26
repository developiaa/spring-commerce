package pro.developia.api.domain.config;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import pro.developia.api.dto.request.config.ConfigCreateRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Document(collection = "config")
public class Config {
    @Id
    private String id;

    @Field
    private String key;

    @Field
    private String value;

    @Field
    private String target;

    @Field
    private Boolean isUsed;

    @Field
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Config(String key, String value, String target, Boolean isUsed) {
        this.key = key;
        this.value = value;
        this.target = target;
        this.isUsed = isUsed;
    }

    public static Config createConfig(ConfigCreateRequest configCreateRequest) {
        return Config.builder()
                .key(configCreateRequest.getKey())
                .value(configCreateRequest.getValue())
                .target(configCreateRequest.getTarget())
                .isUsed(configCreateRequest.getIsUsed())
                .build();
    }

}
