package pro.developia.commerce.service.member;

import pro.developia.commerce.dto.request.member.MemberCreateRequest;

public interface MemberService {
    /**
     * 멤버를 생성한다.
     * @param memberCreateRequest
     */
    void createMember(MemberCreateRequest memberCreateRequest);
}
