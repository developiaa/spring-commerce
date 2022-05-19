package pro.developia.commerce.service.order;

import pro.developia.commerce.domain.order.Orders;
import pro.developia.commerce.dto.request.order.OrderCreateRequest;

public interface OrderService {
    Orders createOrder(OrderCreateRequest orderCreateRequest);
}
