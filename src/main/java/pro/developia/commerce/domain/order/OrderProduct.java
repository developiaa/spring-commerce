package pro.developia.commerce.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pro.developia.commerce.domain.product.Product;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "order_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Orders order;

    // 주문 가격
    private Integer orderPrice;

    // 주문 수량
    private Integer orderCount;

    @Builder
    public OrderProduct(Product product, Integer orderPrice, Integer orderCount) {
        this.product = product;
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
    }

    public static OrderProduct createOrderProduct(Product product, Integer orderPrice, Integer orderCount) {
        OrderProduct orderProduct = OrderProduct.builder()
                .product(product)
                .orderPrice(orderPrice)
                .orderCount(orderCount)
                .build();

        product.removeStock(orderCount);
        return orderProduct;
    }
}
