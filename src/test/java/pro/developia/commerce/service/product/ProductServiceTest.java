package pro.developia.commerce.service.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.domain.product.ProductStatus;
import pro.developia.commerce.dto.request.product.ProductCreateRequest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

class ProductServiceTest extends ProductServiceMock{

    @Test
    void createProduct() {
        //카테고리
        Long mockCategoryId = 123L;
        Category mockCategory = Category.builder()
                .name("의류")
                .build();

        //상품
        String mockProductName = "초특가 할인상품";
        Product mockProduct = Product.builder()
                .name(mockProductName)
                .stock(100)
                .price(9900)
                .status(ProductStatus.APPROVE)
                .category(mockCategory)
                .build();

        ProductCreateRequest productCreateRequest = ProductCreateRequest.builder()
                .name(mockProductName)
                .build();

        given(categoryRepository.findById(any()))
                .willReturn(Optional.ofNullable(mockCategory));

        given(productRepository.save(any()))
                .willReturn(mockProduct);
        Product product = productService.createProduct(productCreateRequest);

        assertThat(product.getName()).isEqualTo(mockProductName);
    }

}