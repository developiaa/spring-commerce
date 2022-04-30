package pro.developia.commerce.dto.request.member;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import pro.developia.commerce.domain.common.Platform;

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
