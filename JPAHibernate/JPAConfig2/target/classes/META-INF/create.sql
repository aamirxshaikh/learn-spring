CREATE TABLE `jpa_hibernate_2`.`Seq` (`gen_name` VARCHAR(16), `gen_val` INT NOT NULL);
INSERT INTO `jpa_hibernate_2`.`Seq` VALUES ("car_id", 1);
INSERT INTO `jpa_hibernate_2`.`Seq` VALUES ("owner_id", 50);
CREATE TABLE `jpa_hibernate_2`.`Car` (`id` int, `model` varchar(255), `name` varchar(255), `owner` VARCHAR(64));
CREATE TABLE `jpa_hibernate_2`.`Owner` (`id` INT, `name` VARCHAR(255), `dob` DATETIME);