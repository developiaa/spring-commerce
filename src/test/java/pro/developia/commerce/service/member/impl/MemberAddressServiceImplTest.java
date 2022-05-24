package pro.developia.commerce.service.member.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pro.developia.commerce.core.ApiException;
import pro.developia.commerce.core.Code;
import pro.developia.commerce.domain.common.Platform;
import pro.developia.commerce.domain.member.Address;
import pro.developia.commerce.domain.member.Member;
import pro.developia.commerce.dto.request.member.AddressCreateRequest;
import pro.developia.commerce.dto.request.member.MemberCreateRequest;
import pro.developia.commerce.repository.AddressRepository;
import pro.developia.commerce.repository.MemberRepository;
import pro.developia.commerce.service.member.MemberAddressService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest(properties = "spring.profiles.active:test")
class MemberAddressServiceImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAddressService memberAddressService;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    @DisplayName("특정 고객의 주소를 생성한다.")
    void createAddress() {
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest();
        memberCreateRequest.setName("김민수");
        memberCreateRequest.setPhone("01012345678");
        memberCreateRequest.setPlatform(Platform.KAKAO);
        Member member = Member.createMember(memberCreateRequest);
        Member savedMember = memberRepository.save(member);

        AddressCreateRequest addressCreateRequest = new AddressCreateRequest();
        addressCreateRequest.setMemberId(savedMember.getId());
        addressCreateRequest.setAddress("서울시 광진구 자양2동");
        addressCreateRequest.setDetailAddress("102동 201호");
        addressCreateRequest.setZipCode("05107");

        Address address = memberAddressService.createAddress(addressCreateRequest);

        Address savedAddress = addressRepository.findById(address.getId())
                .orElseThrow(() -> new ApiException(Code.BAD_REQUEST));

        assertAll(
                () -> assertThat(addressCreateRequest.getMemberId()).isEqualTo(savedAddress.getMember().getId()),
                () -> assertThat(addressCreateRequest.getAddress()).isEqualTo(savedAddress.getAddress()),
                () -> assertThat(addressCreateRequest.getDetailAddress()).isEqualTo(savedAddress.getDetailAddress()),
                () -> assertThat(addressCreateRequest.getZipCode()).isEqualTo(savedAddress.getZipCode())

        );

    }
}