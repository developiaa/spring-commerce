use commerce;
CREATE TABLE orders
(
    id           BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    member_id    BIGINT(20)  NOT NULL comment 'member.id',
    order_status VARCHAR(30) NOT NULL comment '주문 상태',
    created_at   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일',
    constraint fk_orders_member_id foreign key (member_id) references member (id)
)
