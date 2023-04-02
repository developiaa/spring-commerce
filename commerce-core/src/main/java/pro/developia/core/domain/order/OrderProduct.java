package pro.developia.core.domain.order;

import lombok.*;
import pro.developia.core.domain.common.BaseTime;

import java.math.BigDecimal;

@Setter
@Getter
public class OrderProduct extends BaseTime {
    private Long id;
    private String orderNumber;
    private BigDecimal orderPrice;
    private Integer orderCount;
}
