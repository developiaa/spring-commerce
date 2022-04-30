package pro.developia.commerce.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pro.developia.commerce.domain.common.BaseTime;
import pro.developia.commerce.domain.common.Platform;
import pro.developia.commerce.dto.request.member.MemberCreateRequest;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "platform")
    @Enumerated(EnumType.STRING)
    private Platform platform;  // 가입한 플랫폼

    @Builder
    public Member(String name, String phone, Platform platform) {
        this.name = name;
        this.phone = phone;
        this.platform = platform;
    }

    public static Member createMember(MemberCreateRequest memberCreateRequest) {
        return Member.builder()
                .name(memberCreateRequest.getName())
                .phone(memberCreateRequest.getPhone())
                .platform(memberCreateRequest.getPlatform())
                .build();
    }
}
