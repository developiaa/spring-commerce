package pro.developia.api.service.order;

import pro.developia.api.domain.order.Orders;
import pro.developia.api.dto.request.order.OrderCreateRequest;

public interface OrderService {
    Orders createOrder(OrderCreateRequest orderCreateRequest);
}
