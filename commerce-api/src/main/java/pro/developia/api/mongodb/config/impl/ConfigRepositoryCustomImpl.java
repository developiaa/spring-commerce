package pro.developia.api.mongodb.config.impl;

import com.querydsl.core.types.Predicate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import pro.developia.api.domain.config.Config;
import pro.developia.api.mongodb.config.ConfigRepositoryCustom;

import java.util.List;

import static pro.developia.api.domain.config.QConfig.config;

@Repository
public class ConfigRepositoryCustomImpl extends QuerydslRepositorySupport implements ConfigRepositoryCustom {
    public ConfigRepositoryCustomImpl(MongoOperations operations) {
        super(operations);
    }

    @Override
    public List<Config> findByPredicate(Predicate predicate) {
        return from(config)
                .where(predicate)
                .fetch();
    }


}
