use commerce;
CREATE TABLE order_product
(
    id          BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    product_id  BIGINT(20)  NOT NULL comment 'product.id',
    orders_id   BIGINT(20) NOT NULL comment 'orders.id',
    order_price INT         NOT NULL comment '주문 가격',
    order_count INT         NOT NULL comment '주문 수량',
    constraint fk_order_product_product_id foreign key (product_id) references product (id),
    constraint fk_order_product_orders_id foreign key (orders_id) references orders (id)
)
