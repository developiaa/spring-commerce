package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.product.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
