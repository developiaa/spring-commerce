package pro.developia.api.service.product.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.api.core.ApiException;
import pro.developia.api.core.Code;
import pro.developia.api.domain.product.Category;
import pro.developia.api.domain.product.Product;
import pro.developia.api.dto.request.product.ProductCreateRequest;
import pro.developia.api.repository.CategoryRepository;
import pro.developia.api.repository.ProductRepository;
import pro.developia.api.service.product.ProductService;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductCreateRequest productCreateRequest) {
        // 카테고리 정보 조회
        Category category = categoryRepository.findById(productCreateRequest.getCategoryId())
                .orElseThrow(() -> new ApiException(Code.BAD_REQUEST));
        // 상품 생성
        Product product = Product.createProduct(productCreateRequest, category);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        return productRepository.findProductByCategory(category);
    }

}
