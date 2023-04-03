package pro.developia.orderdomain.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Orders extends pro.developia.core.domain.order.Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Column(name = "member_id")
    private Long memberId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Builder
    public Orders(Long memberId, List<OrderProduct> orderProductList, OrderStatus status) {
        this.memberId = memberId;
        this.orderProductList = orderProductList;
        this.status = status;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProductList.add(orderProduct);
        orderProduct.setOrder(this);
    }

    public static Orders createOrder(Long memberId, OrderProduct... orderProducts) {
        Orders order = new Orders();
        order.setMemberId(memberId);
        for (OrderProduct orderProduct : orderProducts) {
            order.addOrderProduct(orderProduct);
        }
        order.setStatus(OrderStatus.ORDER);
        return order;
    }

}
