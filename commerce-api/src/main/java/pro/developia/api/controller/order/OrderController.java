package pro.developia.api.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.api.core.ApiResult;
import pro.developia.api.domain.order.Orders;
import pro.developia.api.dto.request.order.OrderCreateRequest;
import pro.developia.api.service.order.OrderService;

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
