package pro.developia.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.commerce.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
