package pro.developia.commerce.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.commerce.dto.request.product.CategoryCreateRequest;
import pro.developia.commerce.service.product.CategoryService;

@RequiredArgsConstructor
@RequestMapping("/v1/api/categories")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public String createCategory(@RequestBody @Validated CategoryCreateRequest categoryCreateRequest) {
        categoryService.createCategory(categoryCreateRequest);
        return "success";
    }
}
