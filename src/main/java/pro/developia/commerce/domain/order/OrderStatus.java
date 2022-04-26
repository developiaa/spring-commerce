package pro.developia.commerce.domain.order;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ORDER("order"),                 // 주문완료
    WAITING("waiting"),             // 대기중
    IS_DELIVERING("is_delivering"), // 배송중
    COMPLETE("complete"),           // 배송완료
    RETURN("return"),               // 반품
    CANCEL("cancel");               // 취소

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
