package pro.developia.core.domain.order;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
public class OrderProduct {
    private Long id;
    private String orderNumber;
    private BigDecimal orderPrice;
    private Integer orderCount;
}
