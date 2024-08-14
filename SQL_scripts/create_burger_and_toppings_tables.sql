USE `burger_api`;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `burger`;
DROP TABLE IF EXISTS `topping`;
DROP TABLE IF EXISTS `burgers_toppings`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `burger`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    `description` VARCHAR(80) DEFAULT NULL,
    `price` DECIMAL(5,2) DEFAULT NULL,
    PRIMARY KEY(`id`)
)ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE `topping`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE `burgers_toppings`(
	`burger_id` int(11) NOT NULL,
    `topping_id` int(11) NOT NULL,
    
    PRIMARY KEY(`burger_id`,`topping_id`),
    
    CONSTRAINT `fk_burger` FOREIGN KEY(`burger_id`) REFERENCES `burger`(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
	CONSTRAINT `fk_topping` FOREIGN KEY(`topping_id`) REFERENCES `topping`(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    
)ENGINE = InnoDB;

INSERT INTO `burger`(name, description, price) VALUES 
('Hamburger', 'Tasty hamburger', 19.99),
('Cheeseburger', 'Cheesy cheeseburger', 24.99),
('Jalapeno Burger', 'Spicy jalapeno burger', 26.50);

INSERT INTO `topping`(name) VALUES
('pork chop'), ('cheese'), ('pickles'), 
('tomato'), ('lettuce'), ('Jalapeno');

INSERT INTO `burgers_toppings` VALUES
(1, 1), (1,3), (1,5),
(2,1), (2,2), (2,3), (2,5),
(3,1),  (3,2),  (3,4),  (3,6);
