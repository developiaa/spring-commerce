package pro.developia.commerce.dto.request.product;

import lombok.Getter;
import pro.developia.commerce.domain.product.ProductStatus;

@Getter
public class ProductCreateRequest {
    private String name;
    private Integer stock;
    private Integer price;
    private ProductStatus status;
}
