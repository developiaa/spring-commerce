package pro.developia.commerce.dto.request.product;

import lombok.Builder;
import lombok.Getter;
import pro.developia.commerce.domain.product.ProductStatus;

@Getter
public class ProductCreateRequest {
    private String name;
    private Integer stock;
    private Integer price;
    private ProductStatus status;
    private Long categoryId;

    @Builder
    public ProductCreateRequest(String name, Integer stock, Integer price,
                                ProductStatus status, Long categoryId) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.categoryId = categoryId;
    }
}
