package pro.developia.api.dto.request.order;

import lombok.Getter;

@Getter
public class OrderCreateRequest {
    private Long memberId;
    private Long itemId;
    private Integer count;
    private Integer totalPrice;
}
