package pro.developia.commerce.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.commerce.core.ApiResult;
import pro.developia.commerce.domain.order.Orders;
import pro.developia.commerce.dto.request.order.OrderCreateRequest;
import pro.developia.commerce.service.order.OrderService;

@RequiredArgsConstructor
@RequestMapping("/v1/api/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ApiResult<Orders> createOrder(@RequestBody @Validated OrderCreateRequest orderCreateRequest) {
        return ApiResult.ok(orderService.createOrder(orderCreateRequest));
    }

}
