package pro.developia.core.domain.member;

import lombok.*;
import pro.developia.core.domain.common.BaseTime;

@Getter
@Setter
public class Member extends BaseTime {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String phone;
    private Integer gender;
}
