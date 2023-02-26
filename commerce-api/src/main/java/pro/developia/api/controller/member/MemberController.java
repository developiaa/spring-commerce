package pro.developia.api.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.api.core.ApiException;
import pro.developia.api.core.ApiResult;
import pro.developia.api.core.Code;
import pro.developia.api.dto.request.member.MemberCreateRequest;
import pro.developia.api.service.member.MemberService;

@RequiredArgsConstructor
@RequestMapping("/v1/api/members")
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ApiResult<Void> createMember(@RequestBody @Validated MemberCreateRequest memberCreateRequest) {
        if (memberCreateRequest.getName().equals("admin")) {
//            throw new ApiException(Code.BAD_REQUEST);
//            throw new ApiException(Code.BAD_REQUEST, Code.BAD_REQUEST.getHttpStatus());
//            throw new ApiException(Code.BAD_REQUEST, HttpStatus.FORBIDDEN, "Custom Message");
            throw new ApiException(Code.BAD_REQUEST, "Custom Message");
        }
        memberService.createMember(memberCreateRequest);
        return ApiResult.ok();
    }

}
