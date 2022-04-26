package pro.developia.commerce.domain.common;

import lombok.Getter;

@Getter
public enum Platform {
    NONE("none"),
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google"),
    APPLE("apple"),
    FACEBOOK("facebook"),
    ;

    private String value;

    Platform(String value) {
        this.value = value;
    }
}
