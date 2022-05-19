package pro.developia.commerce.service.order.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.developia.commerce.core.ApiException;
import pro.developia.commerce.core.Code;
import pro.developia.commerce.domain.member.Member;
import pro.developia.commerce.domain.order.OrderProduct;
import pro.developia.commerce.domain.order.Orders;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.dto.request.order.OrderCreateRequest;
import pro.developia.commerce.repository.MemberRepository;
import pro.developia.commerce.repository.OrderRepository;
import pro.developia.commerce.repository.ProductRepository;
import pro.developia.commerce.service.order.OrderService;

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
                product, orderCreateRequest.getTotalPrice(), orderCreateRequest.getCount());

        // 주문 생성
        Orders order = Orders.createOrder(member, orderProduct);

        // 주문 저장
        orderRepository.save(order);

        return order;
    }

}
