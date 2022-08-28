package pro.developia.commerce.mongodb.config;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.ObjectUtils;

import static pro.developia.commerce.domain.config.QConfig.config;

public class ConfigPredicate {
    private final BooleanBuilder booleanBuilder = new BooleanBuilder();

    public void keyEq(String key) {
        if (!ObjectUtils.isEmpty(key)) {
            booleanBuilder.and(config.key.eq(key));
        }
    }

    public void valueLike(String value) {
        if (!ObjectUtils.isEmpty(value)) {
            booleanBuilder.and(config.value.like("%" + value + "%"));
        }
    }

    public void isUsedEq(Boolean isUsed) {
        if (!ObjectUtils.isEmpty(isUsed)) {
            booleanBuilder.and(config.isUsed.eq(isUsed));
        }
    }

    public Predicate values() {
        return booleanBuilder.getValue();
    }
}
