package pro.developia.api.mongodb.config;

import com.querydsl.core.types.Predicate;
import pro.developia.api.domain.config.Config;

import java.util.List;

public interface ConfigRepositoryCustom {
    List<Config> findByPredicate(Predicate predicate);
}
