package pro.developia.commerce.dto.request.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressCreateRequest {
    @NotNull
    private Long memberId;
    @NotNull
    private String address;
    @NotNull
    private String detailAddress;
    @NotNull
    private String zipCode;
}
