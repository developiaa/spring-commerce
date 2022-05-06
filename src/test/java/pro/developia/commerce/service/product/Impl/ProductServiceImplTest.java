package pro.developia.commerce.service.product.Impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.domain.product.ProductStatus;
import pro.developia.commerce.repository.CategoryRepository;
import pro.developia.commerce.repository.ProductRepository;
import pro.developia.commerce.service.product.CategoryService;
import pro.developia.commerce.service.product.ProductService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(properties = "spring.profiles.active:test")
class ProductServiceImplTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("카테고리 id로 모든 상품 가져오기")
    public void fetchJoinTest() {
        Category category1 = Category.builder()
                .name("category1")
                .build();
        Category category2 = Category.builder()
                .name("category2")
                .build();

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        Product product1 = Product.builder()
                .name("product1")
                .price(100)
                .stock(100)
                .status(ProductStatus.APPROVE)
                .category(category1)
                .build();

        Product product2 = Product.builder()
                .name("product2")
                .price(200)
                .stock(200)
                .status(ProductStatus.APPROVE)
                .category(category1)
                .build();

        Product product3 = Product.builder()
                .name("product3")
                .price(300)
                .stock(300)
                .status(ProductStatus.APPROVE)
                .category(category2)
                .build();
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        entityManager.flush();
        entityManager.clear();


        List<Product> products = productRepository.findProductByCategory(category1);
        List<Product> products2 = productRepository.findProductByCategory(category2);

        assertThat(products.size()).isEqualTo(2);
        assertThat(products2.size()).isEqualTo(1);

    }

}