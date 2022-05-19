package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.order.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
