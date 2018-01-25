select * from member;

drop table member;

CREATE TABLE member
(
    user_id                 VARCHAR2(20)    NOT NULL, 
    user_pw                 VARCHAR2(20)    NULL, 
    user_email              VARCHAR2(20)    NULL, 
    user_name               VARCHAR2(20)    NULL, 
    user_zipcode            VARCHAR2(5)     NULL, 
    user_addr               VARCHAR2(90)    NULL, 
    user_addr_detail        VARCHAR2(20)    NULL, 
    user_tel                VARCHAR2(20)    NULL, 
    user_sigdate            DATE            NULL, 
    user_log_type           VARCHAR2(20)    NULL, 
    user_last_login_time    DATE            NULL, 
    user_image              VARCHAR2(20)    NULL, 
    point_total             NUMBER          NULL, 
    user_type               VARCHAR2(20)    NULL, 
    CONSTRAINT MEMBER_PK PRIMARY KEY (user_id)
);

ALTER TABLE member MODIFY(USER_TYPE VARCHAR2(20));
ALTER TABLE member MODIFY(USER_ADDR VARCHAR2(200));
ALTER TABLE member MODIFY(USER_EMAIL VARCHAR2(200));

ALTER TABLE blame MODIFY(ATTACHED_FILE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_TYPE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_TITLE VARCHAR2(100));
ALTER TABLE blame MODIFY(BLAME_CONTENT VARCHAR2(1000));

ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product RENAME COLUMN PRODUCT_COUNT TO PRODUCT_GRADE;
ALTER TABLE product MODIFY(PRODUCT_GRADE VARCHAR2(20));
ALTER TABLE product MODIFY(trade_type VARCHAR2(20));
ALTER TABLE product MODIFY(PRODUCT_STATE number);
ALTER TABLE product_image MODIFY(IMAGE_SRC VARCHAR2(50));
ALTER TABLE product add(category_detail_no number);
insert into category values(category_seq.nextval,'유아용품');
insert into category values(category_seq.nextval,'핸드폰');

insert into category_detail values(category_detail_seq.nextval,'기저귀',1);
insert into category_detail values(category_detail_seq.nextval,'유모차',1);
insert into category_detail values(category_detail_seq.nextval,'유아용옷',1);
insert into category_detail values(category_detail_seq.nextval,'장난감',1);
insert into category_detail values(category_detail_seq.nextval,'갤럭시S6',2);
insert into category_detail values(category_detail_seq.nextval,'갤럭시S7',2);
insert into category_detail values(category_detail_seq.nextval,'갤럭시S8',2);
insert into category_detail values(category_detail_seq.nextval,'IPhone5',2);
insert into category_detail values(category_detail_seq.nextval,'IPhoneX',2);
insert into category_detail values(category_detail_seq.nextval,'IPhoneSE',2);
insert into category_detail values(category_detail_seq.nextval,'IPhone8Plus',2);


select * from BLAME;
select * from ATTENDANCE;



CREATE TABLE block
(
    user_id         VARCHAR2(20)    NOT NULL, 
    block_reason    VARCHAR2(20)    NULL, 
    block_date      DATE            NULL   
);