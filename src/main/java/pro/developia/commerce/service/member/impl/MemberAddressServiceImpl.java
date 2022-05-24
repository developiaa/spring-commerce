package pro.developia.commerce.service.member.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.core.ApiException;
import pro.developia.commerce.core.Code;
import pro.developia.commerce.domain.member.Address;
import pro.developia.commerce.domain.member.Member;
import pro.developia.commerce.dto.request.member.AddressCreateRequest;
import pro.developia.commerce.repository.AddressRepository;
import pro.developia.commerce.repository.MemberRepository;
import pro.developia.commerce.service.member.MemberAddressService;

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
