package pro.developia.api.domain.product;

import lombok.Getter;

@Getter
public enum ProductStatus {
    WAITING("waiting"),
    APPROVE("approve"),
    REJECT("reject");

    private final String value;

    ProductStatus(String value) {
        this.value = value;
    }
}
