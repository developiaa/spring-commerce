package pro.developia.commerce.service.member;

import pro.developia.commerce.domain.member.Address;
import pro.developia.commerce.dto.request.member.AddressCreateRequest;

public interface MemberAddressService {

    /**
     * 고객의 주소정보를 생성한다.
     * @return Address
     */
    Address createAddress(AddressCreateRequest addressCreateRequest);
}
