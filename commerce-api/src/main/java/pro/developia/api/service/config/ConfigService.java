package pro.developia.api.service.config;

import com.querydsl.core.types.Predicate;
import pro.developia.api.domain.config.Config;
import pro.developia.api.dto.request.config.ConfigCreateRequest;

import java.util.List;

public interface ConfigService {
    void createConfig(ConfigCreateRequest configCreateRequest);

    List<Config> getConfigList(Predicate predicate);
}
