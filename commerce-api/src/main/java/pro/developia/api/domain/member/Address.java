package pro.developia.api.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pro.developia.api.dto.request.member.AddressCreateRequest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address extends pro.developia.core.domain.member.Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Column(name = "address")
    public String getAddress() {
        return super.getAddress();
    }

    @Column(name = "detail_address")
    public String getDetailAddress() {
        return super.getDetailAddress();
    }

    @Column(name = "zip_code")
    public String getZipCode() {
        return super.getZipCode();
    }

    @Column(name = "created_at")
    @CreatedDate
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Column(name = "updated_at")
    @LastModifiedDate
    public LocalDateTime getUpdatedAt() {
        return super.getUpdatedAt();
    }

    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Builder
    public Address(String address, String detailAddress, String zipCode, Member member) {
        super.setAddress(address);
        super.setDetailAddress(detailAddress);
        super.setZipCode(zipCode);
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
