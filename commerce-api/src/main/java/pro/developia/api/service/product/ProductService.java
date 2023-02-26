package pro.developia.api.service.product;

import pro.developia.api.domain.product.Product;
import pro.developia.api.dto.request.product.ProductCreateRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductCreateRequest productCreateRequest);

    List<Product> getProductsByCategoryId(Long categoryId);
}
