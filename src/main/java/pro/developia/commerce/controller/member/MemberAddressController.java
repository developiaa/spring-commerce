package pro.developia.commerce.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.commerce.core.ApiResult;
import pro.developia.commerce.domain.member.Address;
import pro.developia.commerce.dto.request.member.AddressCreateRequest;
import pro.developia.commerce.service.member.MemberAddressService;

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
