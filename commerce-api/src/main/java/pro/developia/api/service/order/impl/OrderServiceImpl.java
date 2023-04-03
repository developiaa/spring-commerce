package pro.developia.api.service.order.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.developia.api.core.ApiException;
import pro.developia.api.core.Code;
import pro.developia.api.domain.member.Member;
import pro.developia.api.domain.product.Product;
import pro.developia.api.dto.request.order.OrderCreateRequest;
import pro.developia.api.repository.MemberRepository;
import pro.developia.api.repository.ProductRepository;
import pro.developia.api.service.order.OrderService;
import pro.developia.orderdomain.domain.OrderProduct;
import pro.developia.orderdomain.domain.Orders;
import pro.developia.orderdomain.repository.OrderRepository;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    @Override
    public Orders createOrder(OrderCreateRequest orderCreateRequest) {
        // 엔티티 조회
        Member member = memberRepository.findById(orderCreateRequest.getMemberId())
                .orElseThrow(() -> new ApiException(Code.BAD_REQUEST));
        Product product = productRepository.findById(orderCreateRequest.getItemId())
                .orElseThrow(() -> new ApiException(Code.BAD_REQUEST));

        // 주문상품 생성
        OrderProduct orderProduct = OrderProduct.createOrderProduct(
                product.getId(), orderCreateRequest.getTotalPrice(), orderCreateRequest.getCount());

        // 주문 생성
        Orders order = Orders.createOrder(member, orderProduct);

        // 주문 저장
        orderRepository.save(order);

        return order;
    }

}
