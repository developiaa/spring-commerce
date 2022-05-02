package pro.developia.commerce.service.product.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.dto.request.product.ProductCreateRequest;
import pro.developia.commerce.repository.ProductRepository;
import pro.developia.commerce.service.product.ProductService;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        Product product = Product.createProduct(productCreateRequest);
        productRepository.save(product);
    }
}
