package pro.developia.commerce.service.product;

import pro.developia.commerce.dto.request.product.ProductCreateRequest;

public interface ProductService {
    void createProduct(ProductCreateRequest productCreateRequest);
}
