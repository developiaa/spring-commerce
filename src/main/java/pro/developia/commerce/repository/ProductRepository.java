package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.domain.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select product from Product product join fetch product.category" +
            " where product.category =:category")
    List<Product> findProductByCategory(Category category);
}
