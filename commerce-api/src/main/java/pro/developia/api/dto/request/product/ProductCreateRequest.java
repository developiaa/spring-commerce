package pro.developia.api.dto.request.product;

import lombok.Builder;
import lombok.Getter;
import pro.developia.api.domain.product.ProductStatus;

import java.math.BigDecimal;

@Getter
public class ProductCreateRequest {
    private String name;
    private Integer stock;
    private BigDecimal price;
    private ProductStatus status;
    private Long categoryId;

    @Builder
    public ProductCreateRequest(String name, Integer stock, BigDecimal price,
                                ProductStatus status, Long categoryId) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.categoryId = categoryId;
    }
}
