package pro.developia.commerce.service.product;

import pro.developia.commerce.dto.request.product.CategoryCreateRequest;

public interface CategoryService {
    void createCategory(CategoryCreateRequest categoryCreateRequest);
}
