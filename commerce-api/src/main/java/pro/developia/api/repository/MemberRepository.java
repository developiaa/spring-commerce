package pro.developia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.developia.api.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
