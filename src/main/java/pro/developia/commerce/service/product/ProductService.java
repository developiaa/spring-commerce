package pro.developia.commerce.service.product;

import pro.developia.commerce.domain.product.Product;
import pro.developia.commerce.dto.request.product.ProductCreateRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductCreateRequest productCreateRequest);

    List<Product> getProductsByCategoryId(Long categoryId);
}
