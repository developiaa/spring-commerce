package pro.developia.core.domain.member;

import lombok.*;
import pro.developia.core.domain.common.BaseTime;

@Getter
@Setter
public class Address extends BaseTime {
    private Long id;
    private String address;
    private String detailAddress;
    private String zipCode;
}
