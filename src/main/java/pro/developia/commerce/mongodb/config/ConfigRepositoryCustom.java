package pro.developia.commerce.mongodb.config;

import com.querydsl.core.types.Predicate;
import pro.developia.commerce.domain.config.Config;

import java.util.List;

public interface ConfigRepositoryCustom {
    List<Config> findByPredicate(Predicate predicate);
}
