package pro.developia.core.domain.member;

import lombok.*;

@Getter
@Setter
public class Address {
    private Long id;
    private String address;
    private String detailAddress;
    private String zipCode;
}
