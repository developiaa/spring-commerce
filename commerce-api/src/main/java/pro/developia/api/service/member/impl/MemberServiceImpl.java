package pro.developia.api.service.member.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.api.domain.member.Member;
import pro.developia.api.dto.request.member.MemberCreateRequest;
import pro.developia.api.repository.MemberRepository;
import pro.developia.api.service.member.MemberService;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void createMember(MemberCreateRequest memberCreateRequest) {
        log.info("멤버 생성 = {}", memberCreateRequest);
        Member member = Member.createMember(memberCreateRequest);
        memberRepository.save(member);
    }
}
