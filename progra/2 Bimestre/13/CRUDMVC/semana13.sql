CREATE SCHEMA `esquema` ;
CREATE TABLE `esquema`.`provincia` (
  `idProvincia` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProvincia`));
CREATE TABLE `esquema`.`canton` (
  `idCanton` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCanton`));
  
  -- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema esquema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema esquema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `esquema` DEFAULT CHARACTER SET latin1 ;
USE `esquema` ;

-- -----------------------------------------------------
-- Table `esquema`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esquema`.`Provincia` (
  `idProvincia` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idProvincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `esquema`.`Canton`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esquema`.`Canton` (
  `idCanton` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Provincia_idProvincia` INT NOT NULL,
  PRIMARY KEY (`idCanton`),
  INDEX `fk_Canton_Provincia_idx` (`Provincia_idProvincia` ASC),
  CONSTRAINT `fk_Canton_Provincia`
    FOREIGN KEY (`Provincia_idProvincia`)
    REFERENCES `esquema`.`Provincia` (`idProvincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `esquema`.`provincia` (`Nombre`) VALUES ('Loja');
INSERT INTO `esquema`.`provincia` (`Nombre`) VALUES ('Azuay');
INSERT INTO `esquema`.`provincia` (`Nombre`) VALUES ('Pichincha');

INSERT INTO `esquema`.`canton` (`Nombre`, `Provincia_idProvincia`) VALUES ('Loja', '1');
ALTER TABLE `esquema`.`provincia` 
CHANGE COLUMN `Nombre` `Nombre` VARCHAR(45) NOT NULL ;
ALTER TABLE `esquema`.`canton` 
CHANGE COLUMN `idCanton` `idCanton` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO `esquema`.`canton` (`Nombre`, `Provincia_idProvincia`) VALUES ('Saraguro', '1');
INSERT INTO `esquema`.`canton` (`Nombre`, `Provincia_idProvincia`) VALUES ('Cuenca', '2');
INSERT INTO `esquema`.`canton` (`Nombre`, `Provincia_idProvincia`) VALUES ('Quito', '3');
INSERT INTO `esquema`.`canton` (`Nombre`, `Provincia_idProvincia`) VALUES ('San Golqui', '3');

ALTER TABLE `esquema`.`canton` 
DROP FOREIGN KEY `fk_Canton_Provincia`;
ALTER TABLE `esquema`.`canton` 
CHANGE COLUMN `Provincia_idProvincia` `idProvincia` INT(11) NOT NULL ;
ALTER TABLE `esquema`.`canton` 
ADD CONSTRAINT `fk_Canton_Provincia`
  FOREIGN KEY (`idProvincia`)
  REFERENCES `esquema`.`provincia` (`idProvincia`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


##SELECT * FROM esquema.provincia;
#Select * from provincia order by nombre;
select * from canton where idProvincia = 2 order by 2#este order by 2 es el numero de la columna;
