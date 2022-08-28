package pro.developia.commerce.service.config.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.domain.config.Config;
import pro.developia.commerce.dto.request.config.ConfigCreateRequest;
import pro.developia.commerce.mongodb.config.ConfigRepository;
import pro.developia.commerce.service.config.ConfigService;

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
