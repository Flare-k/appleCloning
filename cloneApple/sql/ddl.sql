CREATE TABLE `member` (
 `member_id` bigint NOT NULL AUTO_INCREMENT,
 `username` varchar(20) NULL,
 `password` varchar(300) NULL,
 `email` varchar(30) NULL,
 `phone` char(11) NULL,
 `gender` char(1) NULL,
 `age` int NULL,
 `enroll_date` date NULL,
 `del_flag` char(1) NULL,
 `delete_date` date NULL,
 `reg_flag` char(1) NULL,
 primary key(`member_id`)
);

CREATE TABLE `product` (
 `p_id` varchar(30) NOT NULL,
 `p_name` varchar(30) NULL,
 `p_price` bigint NULL,
 `p_category` varchar(30) NULL,
 `description` varchar(50) NULL,
 `p_company` varchar(30) NULL,
 `p_stock` INT NULL,
 `p_color` varchar(30) NULL,
 `p_size` INT NULL
);

CREATE TABLE `product_io` (
 `io_id` INT NOT NULL,
 `p_id` varchar(30) NOT NULL,
 `order_no` INT NOT NULL,
 `amount` INT NULL,
 `status` varchar(10) NULL,
 `io_date` date NULL,
 `member_id` bigint NOT NULL
);

CREATE TABLE `order` (
 `order_no` INT NOT NULL AUTO_INCREMENT,
 `res_name` varchar(20) NULL,
 `res_address` varchar(100) NULL,
 `res_phone` char(11) NULL,
 `member_id` bigint NOT NULL,
 `res_requirement` varchar(100) NULL,
 `total_price` INT NULL,
 `order_date` date NULL,
 primary key(order_no)
);

CREATE TABLE `favorite` (
 `p_id` varchar(30) NOT NULL,
 `p_name` varchar(30) NULL,
 `amount` INT NULL,
 `p_price` INT(10) NULL,
 `member_id` bigint NULL
);

CREATE TABLE `dest_list` (
 `member_id` bigint NOT NULL,
 `address` varchar(100) NULL
);


ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (`p_id`);

ALTER TABLE `product_io` ADD CONSTRAINT `PK_PRODUCT_IO` PRIMARY KEY (`io_id`, `p_id`, `order_no`);

ALTER TABLE `favorite` ADD CONSTRAINT `PK_FAVORITE` PRIMARY KEY (`p_id`);

ALTER TABLE `product_io` ADD CONSTRAINT `FK_product_TO_product_io_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`);

ALTER TABLE `product_io` ADD CONSTRAINT `FK_order_TO_product_io_1` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`);

ALTER TABLE `favorite` ADD CONSTRAINT `FK_product_TO_favorite_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`);

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