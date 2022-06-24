use commerce;
CREATE TABLE address
(
    id            BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    member_id     BIGINT(20)  NOT NULL comment 'member.id',
    address       VARCHAR(100) NOT NULL comment '주소',
    detailAddress VARCHAR(100) NOT NULL comment '상세주소',
    zipCode       VARCHAR(20) NOT NULL comment '우편번호',
    constraint fk_address_member_id foreign key (member_id) references member (id)
);
