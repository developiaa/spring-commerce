package pro.developia.commerce.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.commerce.core.ApiResult;
import pro.developia.commerce.dto.request.product.ProductCreateRequest;
import pro.developia.commerce.service.product.ProductService;

@RequiredArgsConstructor
@RequestMapping("/v1/api/products")
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ApiResult<Void> createProduct(@RequestBody @Validated ProductCreateRequest productCreateRequest) {
        productService.createProduct(productCreateRequest);
        return ApiResult.ok();
    }

}
