package pro.developia.core.domain.member;

import lombok.*;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String phone;
    private Integer gender;
}
