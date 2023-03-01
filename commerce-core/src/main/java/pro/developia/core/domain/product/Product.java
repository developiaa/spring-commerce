package pro.developia.core.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;
}
