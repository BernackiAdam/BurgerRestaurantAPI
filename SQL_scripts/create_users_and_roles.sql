DROP SCHEMA IF EXISTS `burger_api`;
CREATE SCHEMA `burger_api`;
USE `burger_api`;

CREATE TABLE IF NOT EXISTS `burger_api`.`user`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(70) NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `burger_api`.`role`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

INSERT INTO `user`(`username`, `password`) VALUES
('Adam', 'passwd');

INSERT INTO `role`(`name`) VALUES
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS `burger_api`.`users_roles`(
	`user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    
    PRIMARY KEY(`user_id`,`role_id`),
    
    CONSTRAINT `fk_user` FOREIGN KEY(`user_id`) REFERENCES `user`(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `fk_role` FOREIGN KEY(`role_id`) REFERENCES `role`(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO `users_roles` VALUES
(1,1),
(1,2),
(1,3);