use commerce;
CREATE TABLE member
(
    id         BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30)  NOT NULL comment '이름',
    nickName   VARCHAR(30)  NOT NULL comment '별명',
    email      VARCHAR(100) NOT NULL comment '이메일',
    phone      VARCHAR(20)  NOT NULL comment '연락처',
    gender     VARCHAR(10)   NULL comment '성별',
    platform   VARCHAR(20)  NOT NULL comment '가입 경로',
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일'
);
