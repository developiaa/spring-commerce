package pro.developia.commerce.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pro.developia.commerce.dto.request.member.AddressCreateRequest;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Address(String address, String detailAddress, String zipCode, Member member) {
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipCode = zipCode;
        this.member = member;
    }

    public static Address createAddress(AddressCreateRequest addressCreateRequest, Member member) {
        return Address.builder()
                .address(addressCreateRequest.getAddress())
                .detailAddress(addressCreateRequest.getDetailAddress())
                .zipCode(addressCreateRequest.getZipCode())
                .member(member)
                .build();
    }
}
