package pro.developia.orderdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.orderdomain.domain.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
