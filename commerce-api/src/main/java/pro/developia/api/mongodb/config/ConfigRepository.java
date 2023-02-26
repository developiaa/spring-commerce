package pro.developia.api.mongodb.config;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pro.developia.api.domain.config.Config;

public interface ConfigRepository extends MongoRepository<Config, String>,
        QuerydslPredicateExecutor<Config>,
        ConfigRepositoryCustom {
}
