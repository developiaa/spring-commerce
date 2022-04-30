package pro.developia.commerce.dto.request.member;

import lombok.Getter;
import lombok.Setter;
import pro.developia.commerce.domain.common.Platform;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class MemberCreateRequest {
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private Platform platform;
}
