use commerce;
CREATE TABLE product
(
    id             BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    category_id    BIGINT(20)  NOT NULL comment 'category.id',
    product_status VARCHAR(30) NOT NULL comment '상품 상태',
    name           VARCHAR(50) NOT NULL comment '상품 이름',
    stock          INT         NOT NULL comment '상품 재고',
    price          INT         NOT NULL comment '상품 가격',
    created_at     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일',
    constraint fk_product_category_id foreign key (category_id) references category (id)
)
