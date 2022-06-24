use commerce;
CREATE TABLE category
(
    id         BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(50) NOT NULL comment '카테고리 이름',
    created_at DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일'
)
