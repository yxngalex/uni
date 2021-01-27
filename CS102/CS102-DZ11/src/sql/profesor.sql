--tabela profesor
CREATE TABLE `cs102dz11`.`profesor` ( 
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT , 
`ime` VARCHAR(50) NOT NULL , 
`prezime` VARCHAR(50) NOT NULL , 
`godina_izbora_u_zvanje` INT(4) NOT NULL , 
`naslov_doktorata` VARCHAR(255) NOT NULL , 
PRIMARY KEY (`id`)) 
ENGINE = InnoDB;

--tabela predmet
CREATE TABLE `cs102dz11`.`predmet` ( 
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT , 
`sifra_predmeta` VARCHAR(255) NOT NULL , 
`naziv_predmeta` VARCHAR(255) NOT NULL , 
`id_profesora` INT NOT NULL , 
PRIMARY KEY (`id`))
 ENGINE = InnoDB;