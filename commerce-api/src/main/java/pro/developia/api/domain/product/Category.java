package pro.developia.api.domain.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pro.developia.api.domain.common.BaseTime;
import pro.developia.api.dto.request.product.CategoryCreateRequest;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public static Category createCategory(CategoryCreateRequest categoryCreateRequest) {
        return Category.builder()
                .name(categoryCreateRequest.getName())
                .build();
    }
}
