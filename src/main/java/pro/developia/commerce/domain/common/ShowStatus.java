package pro.developia.commerce.domain.common;

import lombok.Getter;

public enum ShowStatus {
    UNPUBLISHED("unpublished"),
    PUBLISHED("published");

    @Getter
    private final String value;

    ShowStatus(String value) {
        this.value = value;
    }
}
