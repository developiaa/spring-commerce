package pro.developia.commerce.service.product.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.dto.request.product.CategoryCreateRequest;
import pro.developia.commerce.repository.CategoryRepository;
import pro.developia.commerce.service.product.CategoryService;

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
