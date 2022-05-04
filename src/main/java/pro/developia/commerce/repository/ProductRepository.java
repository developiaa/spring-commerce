package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.product.Category;
import pro.developia.commerce.domain.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);
}
