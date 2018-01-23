select * from member;

ALTER TABLE member RENAME COLUMN USER_CHK_BLACK TO USER_TYPE;
ALTER TABLE member MODIFY(USER_TYPE VARCHAR2(20));
ALTER TABLE member MODIFY(USER_ADDR VARCHAR2(200));
ALTER TABLE member MODIFY(USER_EMAIL VARCHAR2(200));

ALTER TABLE blame MODIFY(ATTACHED_FILE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_TYPE VARCHAR2(100));

select * from BLAME;


ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product RENAME COLUMN PRODUCT_COUNT TO PRODUCT_GRADE;
ALTER TABLE product MODIFY(PRODUCT_GRADE VARCHAR2(20));
ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product MODIFY(PRODUCT_STATE number);
ALTER TABLE product_image MODIFY(IMAGE_SRC VARCHAR2(50));





insert into category values(category_seq.nextval,'유아용품');
insert into category values(category_seq.nextval,'핸드폰');

insert into category_detail values(category_detail_seq.nextval,'기저귀',2);
insert into category_detail values(category_detail_seq.nextval,'유모차',2);
insert into category_detail values(category_detail_seq.nextval,'유아용옷',2);
insert into category_detail values(category_detail_seq.nextval,'장난감',2);

select * from BLAME;
select * from ATTENDANCE;



CREATE TABLE block
(
    user_id         VARCHAR2(20)    NOT NULL, 
    block_reason    VARCHAR2(20)    NULL, 
    block_date      DATE            NULL   
);