package pro.developia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.api.domain.product.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
