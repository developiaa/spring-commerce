package pro.developia.api.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import pro.developia.api.domain.common.Platform;
import pro.developia.api.dto.request.member.MemberCreateRequest;
import pro.developia.orderdomain.domain.Orders;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends pro.developia.core.domain.member.Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Column(name = "name")
    public String getName() {
        return super.getName();
    }

    @Column(name = "nickName")
    public String getNickName() {
        return super.getNickName();
    }

    @Column(name = "email")
    public String getEmail() {
        return super.getEmail();
    }

    @Column(name = "phone")
    public String getPhone() {
        return super.getPhone();
    }

    @Column(name="gender")
    public Integer getGender() {
        return super.getGender();
    }

    @Column(name = "platform")
    @Enumerated(EnumType.STRING)
    private Platform platform;  // 가입한 플랫폼

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

    private List<Orders> orders;

    private List<Address> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Builder
    public Member(String name, String phone, Platform platform) {
        super.setName(name);
        super.setPhone(phone);
        this.platform = platform;
    }

    public static Member createMember(MemberCreateRequest memberCreateRequest) {
        return Member.builder()
                .name(memberCreateRequest.getName())
                .phone(memberCreateRequest.getPhone())
                .platform(memberCreateRequest.getPlatform())
                .build();
    }
}
