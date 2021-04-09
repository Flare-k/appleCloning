CREATE TABLE member (
 member_id bigint NOT NULL AUTO_INCREMENT,
 member_name varchar(20) NULL,
 username varchar(20) NULL,
 password varchar(300) NULL,
 email varchar(30) NULL,
 phone char(11) NULL,
 gender char(1) NULL,
 age int NULL,
 enroll_date date NULL,
 del_flag char(1) NULL,
 delete_date date NULL,
 enabled boolean NULL,
 primary key(member_id)
);

CREATE TABLE product (
 productId varchar(30) NOT NULL,
 productName varchar(30) NULL,
 productPrice bigint NULL,
 productCategory varchar(30) NULL,
 productDescription varchar(50) NULL,
 productCompany varchar(30) NULL,
 productStock INT NULL,
 productColor varchar(30) NULL,
 productSize INT NULL
);

CREATE TABLE product_io (
 ioId varchar(30) NOT NULL,
 productId varchar(30) NOT NULL,
 orderNo INT NOT NULL,
 amount INT NULL,
 status varchar(10) NULL,
 ioDate date NULL,
 member_id bigint NOT NULL
);

CREATE TABLE orderTable (
 orderNo bigint NOT NULL AUTO_INCREMENT,
 resName varchar(20),
 resAddress varchar(80),
 resPhone varchar(11),
 member_id bigint NOT NULL,
 resRequirement varchar(100) NULL,
 totalPrice bigint NULL,
 orderDate date NULL,
 primary key(orderNo)
);

CREATE TABLE favorite (
productId varchar(30) NOT NULL,
productName varchar(30) NULL,
amount INT NULL,
productPrice INT(10) NULL,
username bigint NOT NULL
);

CREATE TABLE dest_list (
member_id bigint NOT NULL,
address varchar(100) NULL
);


ALTER TABLE product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (productId);

ALTER TABLE product_io ADD CONSTRAINT PK_PRODUCT_IO PRIMARY KEY (ioId, productId, orderNo);

ALTER TABLE favorite ADD CONSTRAINT PK_FAVORITE PRIMARY KEY (productId);

ALTER TABLE product_io ADD CONSTRAINT FK_product_TO_product_io_1 FOREIGN KEY (productId) REFERENCES product (productId);

ALTER TABLE product_io ADD CONSTRAINT FK_orderTable_TO_product_io_1 FOREIGN KEY (orderNo) REFERENCES orderTable (orderNo);

ALTER TABLE favorite ADD CONSTRAINT FK_product_TO_favorite_1 FOREIGN KEY (productId) REFERENCES product (productId);

// user_role// ROLE TABLE
CREATE TABLE ROLE(
 MEMBER_ID BIGINT NOT NULL AUTO_INCREMENT,
 username VARCHAR(20),
 PRIMARY KEY (MEMBER_ID)
);

// USER x ROLE MAPPING TABLE - USER_ROLE MANY-TO-MANY
CREATE TABLE USER_ROLE(
 MEMBER_ID BIGINT NOT NULL AUTO_INCREMENT,
 ROLE_ID BIGINT NOT NULL,
 PRIMARY KEY (member_id, role_id),
 FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID),
 FOREIGN KEY (ROLE_ID) REFERENCES ROLE(MEMBER_ID)
);