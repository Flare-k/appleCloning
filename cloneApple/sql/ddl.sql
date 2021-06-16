CREATE TABLE member (
 mem_pk bigint NOT NULL AUTO_INCREMENT,
 mem_id varchar(20) NULL,
 mem_password varchar(300) NULL,
 mem_name varchar(20) NULL,
 mem_gender char(1) NULL,
 mem_age int NULL,
 mem_email varchar(30) NULL,
 mem_phone varchar(11) NULL,
 mem_addr varchar(30) NULL,
 enroll_date date NULL,
 del_flag boolean NULL,
 del_date date NULL,
 reg_flag boolean NULL,
 primary key(mem_pk)
);

CREATE TABLE product (
 product_id varchar(30) NOT NULL,
 product_name varchar(30) NULL,
 product_price bigint NULL,
 product_category varchar(30) NULL,
 description varchar(50) NULL,
 company varchar(30) NULL,
 product_stock INT NULL,
 product_color varchar(30) NULL,
 product_size INT NULL
);

CREATE TABLE product_io (
 io_pk varchar(30) NOT NULL,
 order_pk bigint NOT NULL,
 mem_pk bigint NOT NULL,
 io_status varchar(10) NULL,
 io_date date NULL
);

CREATE TABLE orderList (
 order_pk bigint NOT NULL AUTO_INCREMENT,
 mem_pk bigint NOT NULL,
 order_no varchar(30),
 product_id varchar(30) NOT NULL,
 res_name varchar(30) NOT NULL,
 res_addr varchar(30) NOT NULL,
 res_phone varchar(30) NOT NULL,
 res_memo varchar(30) NOT NULL,
 total_price INT NOT NULL,
 order_date date NULL,
 primary key(order_pk)
);

CREATE TABLE favorite (
favorite_pk bigint NOT NULL AUTO_INCREMENT,
product_id varchar(30) NOT NULL,
amount INT NULL,
mem_id varchar(20) NULL,
primary key(favorite_pk)
);

CREATE TABLE AUTHORITY (
 authority_name varchar(100),
 primary key(authority_name)
);

CREATE TABLE USER_AUTHORITY (
 mem_pk bigint,
 authority_name varchar(100)
);


INSERT INTO MEMBER (MEM_PK, MEM_ID, MEM_PASSWORD, MEM_NAME, MEM_GENDER, MEM_AGE, MEM_EMAIL, MEM_PHONE, MEM_ADDR, DEL_FLAG, REG_FLAG) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'M', '20', 'admin@example.com', '01000000000', 'Korea', 0, 1);
INSERT INTO MEMBER (MEM_PK, MEM_ID, MEM_PASSWORD, MEM_NAME, MEM_GENDER, MEM_AGE, MEM_EMAIL, MEM_PHONE, MEM_ADDR, DEL_FLAG, REG_FLAG) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'F', '10', 'user@example.com', '01011111111', 'Korea', 0, 1);

INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_USER');
INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (MEM_PK, AUTHORITY_NAME) values (1, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (MEM_PK, AUTHORITY_NAME) values (1, 'ROLE_ADMIN');
INSERT INTO USER_AUTHORITY (MEM_PK, AUTHORITY_NAME) values (2, 'ROLE_USER');


ALTER TABLE product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (product_id);

// 확인 필요 order_pk말고 product_id 필요하진 않은지
ALTER TABLE product_io ADD CONSTRAINT PK_PRODUCT_IO PRIMARY KEY (io_pk, mem_pk, order_pk);

// 수정 필요
ALTER TABLE product_io ADD CONSTRAINT FK_product_TO_product_io_1 FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE product_io ADD CONSTRAINT FK_orderList_TO_product_io_1 FOREIGN KEY (order_pk) REFERENCES orderList (order_pk);

ALTER TABLE favorite ADD CONSTRAINT FK_product_TO_favorite_1 FOREIGN KEY (product_id) REFERENCES product (product_id);
