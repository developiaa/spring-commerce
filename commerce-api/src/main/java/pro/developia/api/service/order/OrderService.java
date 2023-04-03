package pro.developia.api.service.order;


import pro.developia.api.dto.request.order.OrderCreateRequest;
import pro.developia.orderdomain.domain.Orders;

public interface OrderService {
    Orders createOrder(OrderCreateRequest orderCreateRequest);
}
