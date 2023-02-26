package pro.developia.api.service.product;

import pro.developia.api.dto.request.product.CategoryCreateRequest;

public interface CategoryService {
    void createCategory(CategoryCreateRequest categoryCreateRequest);
}
