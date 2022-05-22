package pro.developia.commerce.service.product.Impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.dto.request.product.CategoryCreateRequest;
import pro.developia.commerce.repository.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(properties = "spring.profiles.active:test")
class CategoryServiceImplTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("카테고리를 생성한다")
    void createCategory() {
        String name1 = "가방";
        String name2 = "책상";
        CategoryCreateRequest categoryCreateRequest1 = new CategoryCreateRequest();
        CategoryCreateRequest categoryCreateRequest2 = new CategoryCreateRequest();
        categoryCreateRequest1.setName(name1);
        categoryCreateRequest2.setName(name2);

        Category category1 = Category.createCategory(categoryCreateRequest1);
        Category category2 = Category.createCategory(categoryCreateRequest2);
        Category save1 = categoryRepository.save(category1);
        Category save2 = categoryRepository.save(category2);

        Category saveCategory1 = categoryRepository.findById(save1.getId())
                .orElseThrow(RuntimeException::new);
        Category saveCategory2 = categoryRepository.findById(save2.getId())
                .orElseThrow(RuntimeException::new);

        assertThat(saveCategory1.getName()).isEqualTo(name1);
        assertThat(saveCategory2.getName()).isEqualTo(name2);
    }
}