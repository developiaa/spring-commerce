package pro.developia.api.domain.order;

import lombok.*;
import pro.developia.api.domain.common.BaseTime;
import pro.developia.api.domain.member.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Builder
    public Orders(Member member, List<OrderProduct> orderProductList, OrderStatus status) {
        this.member = member;
        this.orderProductList = orderProductList;
        this.status = status;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProductList.add(orderProduct);
        orderProduct.setOrder(this);
    }

    public static Orders createOrder(Member member, OrderProduct... orderProducts) {
        Orders order = new Orders();
        order.setMember(member);
        for (OrderProduct orderProduct : orderProducts) {
            order.addOrderProduct(orderProduct);
        }
        order.setStatus(OrderStatus.ORDER);
        return order;
    }

}
