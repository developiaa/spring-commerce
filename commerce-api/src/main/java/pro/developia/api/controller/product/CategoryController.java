package pro.developia.api.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.developia.api.core.ApiResult;
import pro.developia.api.domain.product.Product;
import pro.developia.api.dto.request.product.CategoryCreateRequest;
import pro.developia.api.service.product.CategoryService;
import pro.developia.api.service.product.ProductService;

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
