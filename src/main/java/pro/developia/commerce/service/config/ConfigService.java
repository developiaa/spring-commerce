package pro.developia.commerce.service.config;

import com.querydsl.core.types.Predicate;
import pro.developia.commerce.domain.config.Config;
import pro.developia.commerce.dto.request.config.ConfigCreateRequest;

import java.util.List;

public interface ConfigService {
    void createConfig(ConfigCreateRequest configCreateRequest);

    List<Config> getConfigList(Predicate predicate);
}
