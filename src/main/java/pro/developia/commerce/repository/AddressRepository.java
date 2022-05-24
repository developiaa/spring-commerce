package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.member.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
