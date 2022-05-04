package pro.developia.commerce.service.product.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.dto.request.product.ProductCreateRequest;
import pro.developia.commerce.repository.CategoryRepository;
import pro.developia.commerce.repository.ProductRepository;
import pro.developia.commerce.service.product.ProductService;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        // 카테고리 정보 조회
        Category category = categoryRepository.findById(productCreateRequest.getCategoryId())
                .orElse(null);
        // 상품 생성
        Product product = Product.createProduct(productCreateRequest, category);
        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts(Long id) {
        Category category = categoryRepository.findById(id).get();
        return productRepository.findAllByCategory(category);
    }

}
