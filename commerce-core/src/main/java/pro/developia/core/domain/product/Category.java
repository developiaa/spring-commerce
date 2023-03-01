package pro.developia.core.domain.product;

import lombok.Getter;
import lombok.Setter;
import pro.developia.core.domain.common.BaseTime;

@Getter
@Setter
public class Category extends BaseTime {
    private Long id;
    private String name;
}
