-- auto Generated on 2017-09-14 09:36:22 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
    `card_id` VARCHAR (32) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'cardId',
    `name` VARCHAR (50) COMMENT 'name',
    `age` VARCHAR (50) COMMENT 'age',
    `address` VARCHAR (50) COMMENT 'address',
    PRIMARY KEY (`card_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';
