package pro.developia.orderdomain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_product")
public class OrderProduct extends pro.developia.core.domain.order.OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    // 주문 번호
    @Column(name = "order_number")
    public String getOrderNumber() {
        return super.getOrderNumber();
    }

    @Column(name = "product_id")
    private Long productId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Orders order;

    // 주문 가격
    @Column(name = "order_price")
    public BigDecimal getOrderPrice() {
        return super.getOrderPrice();
    }

    // 주문 수량
    @Column(name = "order_count")
    public Integer getOrderCount() {
        return super.getOrderCount();
    }


    @Builder
    public OrderProduct(Long productId, BigDecimal orderPrice, Integer orderCount) {
        this.productId = productId;
        super.setOrderPrice(orderPrice);
        super.setOrderCount(orderCount);
    }

    public static OrderProduct createOrderProduct(Long productId, BigDecimal orderPrice, Integer orderCount) {
        OrderProduct orderProduct = OrderProduct.builder()
                .productId(productId)
                .orderPrice(orderPrice)
                .orderCount(orderCount)
                .build();

//        product.removeStock(orderCount);
        return orderProduct;
    }
}
