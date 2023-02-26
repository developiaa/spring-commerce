package pro.developia.api.service.product.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.developia.api.domain.product.Category;
import pro.developia.api.dto.request.product.CategoryCreateRequest;
import pro.developia.api.repository.CategoryRepository;
import pro.developia.api.service.product.CategoryService;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryCreateRequest categoryCreateRequest) {
        Category category = Category.createCategory(categoryCreateRequest);
        categoryRepository.save(category);
    }
}
