package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
