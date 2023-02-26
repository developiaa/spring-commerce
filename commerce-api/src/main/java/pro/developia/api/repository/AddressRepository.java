package pro.developia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.api.domain.member.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
