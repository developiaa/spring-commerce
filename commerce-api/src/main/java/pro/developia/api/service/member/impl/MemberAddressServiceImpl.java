package pro.developia.api.service.member.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.api.core.ApiException;
import pro.developia.api.core.Code;
import pro.developia.api.domain.member.Address;
import pro.developia.api.domain.member.Member;
import pro.developia.api.dto.request.member.AddressCreateRequest;
import pro.developia.api.repository.AddressRepository;
import pro.developia.api.repository.MemberRepository;
import pro.developia.api.service.member.MemberAddressService;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberAddressServiceImpl implements MemberAddressService {
    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(AddressCreateRequest addressCreateRequest) {
        // 해당 고객이 있는지 확인
        Member member = memberRepository.findById(addressCreateRequest.getMemberId())
                .orElseThrow(() -> new ApiException(Code.NOT_FOUND_USER_INFO));

        // 주소 생성
        Address address = Address.createAddress(addressCreateRequest, member);
        return addressRepository.save(address);
    }
}
