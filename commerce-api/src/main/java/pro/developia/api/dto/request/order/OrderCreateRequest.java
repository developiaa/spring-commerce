package pro.developia.api.dto.request.order;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderCreateRequest {
    private Long memberId;
    private Long itemId;
    private Integer count;
    private BigDecimal totalPrice;
}
