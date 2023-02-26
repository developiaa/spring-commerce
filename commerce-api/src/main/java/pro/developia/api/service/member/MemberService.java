package pro.developia.api.service.member;

import pro.developia.api.dto.request.member.MemberCreateRequest;

public interface MemberService {
    /**
     * 멤버를 생성한다.
     * @param memberCreateRequest
     */
    void createMember(MemberCreateRequest memberCreateRequest);
}
