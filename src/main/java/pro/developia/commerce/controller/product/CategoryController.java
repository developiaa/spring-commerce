package pro.developia.commerce.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.developia.commerce.core.ApiResult;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.dto.request.product.CategoryCreateRequest;
import pro.developia.commerce.service.product.CategoryService;
import pro.developia.commerce.service.product.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/api/categories")
@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @PostMapping
    public ApiResult<Void> createCategory(@RequestBody @Validated CategoryCreateRequest categoryCreateRequest) {
        categoryService.createCategory(categoryCreateRequest);
        return ApiResult.ok();
    }

    @GetMapping("/{id}")
    public ApiResult<List<Product>> getProducts(@PathVariable Long id) {
        return ApiResult.ok(productService.getProductsByCategoryId(id));
    }
}
