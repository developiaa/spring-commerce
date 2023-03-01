package pro.developia.core.domain.product;

import lombok.Getter;
import lombok.Setter;
import pro.developia.core.domain.common.BaseTime;

import java.math.BigDecimal;

@Getter
@Setter
public class Product extends BaseTime {
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;
}
