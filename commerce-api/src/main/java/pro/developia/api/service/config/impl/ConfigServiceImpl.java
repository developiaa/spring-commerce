package pro.developia.api.service.config.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.api.domain.config.Config;
import pro.developia.api.dto.request.config.ConfigCreateRequest;
import pro.developia.api.mongodb.config.ConfigRepository;
import pro.developia.api.service.config.ConfigService;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ConfigServiceImpl implements ConfigService {
    private final ConfigRepository configRepository;

    @Override
    public void createConfig(ConfigCreateRequest configCreateRequest) {
        configRepository.save(Config.createConfig(configCreateRequest));
    }

    @Override
    public List<Config> getConfigList(Predicate predicate) {
        return configRepository.findByPredicate(predicate);
    }
}
