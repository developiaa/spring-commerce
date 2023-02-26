package pro.developia.api.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.api.core.ApiResult;
import pro.developia.api.domain.member.Address;
import pro.developia.api.dto.request.member.AddressCreateRequest;
import pro.developia.api.service.member.MemberAddressService;

@RequiredArgsConstructor
@RequestMapping("/v1/api/members")
@RestController
public class MemberAddressController {
    private final MemberAddressService memberAddressService;

    @PostMapping("/{memberId}/address")
    public ApiResult<Address> createAddress(@RequestBody @Validated AddressCreateRequest addressCreateRequest) {
        return ApiResult.ok(memberAddressService.createAddress(addressCreateRequest));
    }

}
