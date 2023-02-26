package pro.developia.api.service.member;

import pro.developia.api.domain.member.Address;
import pro.developia.api.dto.request.member.AddressCreateRequest;

public interface MemberAddressService {

    /**
     * 고객의 주소정보를 생성한다.
     * @return Address
     */
    Address createAddress(AddressCreateRequest addressCreateRequest);
}
