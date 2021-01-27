CREATE TABLE `aukcija`.`korisnici` (
`id` INT NOT NULL AUTO_INCREMENT ,
`ime` VARCHAR(255) NOT NULL ,
`prezime` VARCHAR(255) NOT NULL ,
`godine` INT NOT NULL ,
PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `aukcija`.`artikli` (
`id` INT NOT NULL AUTO_INCREMENT ,
`naziv_artikla` VARCHAR(255) NOT NULL ,
`vlasnik` VARCHAR(255) NOT NULL ,
PRIMARY KEY (`id`))
ENGINE = InnoDB;

ALTER TABLE `artikli` ADD `opis_artikla` TEXT NOT NULL AFTER `naziv_artikla`;