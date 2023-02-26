package pro.developia.api.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pro.developia.api.core.ApiException;
import pro.developia.api.core.Code;
import pro.developia.api.domain.common.BaseTime;
import pro.developia.api.dto.request.product.ProductCreateRequest;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductStatus status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<ProductCategory> productCategoryList = new ArrayList<>();

    @Builder
    public Product(String name, Integer stock, Integer price, ProductStatus status,
                   Category category) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    @Builder
    public static Product createProduct(ProductCreateRequest productCreateRequest, Category category) {
        return Product.builder()
                .name(productCreateRequest.getName())
                .stock(productCreateRequest.getStock())
                .price(productCreateRequest.getPrice())
                .status(productCreateRequest.getStatus())
                .category(category)
                .build();
    }

    public void removeStock(Integer orderCount) {
        Integer stock = this.stock - orderCount;
        if (stock < 0) {
            throw new ApiException(Code.PRODUCT_OUT_OF_STOCK);
        }
        this.stock = stock;
    }
}
