CREATE SCHEMA IF NOT EXISTS `Productos` ;

CREATE TABLE IF NOT EXISTS `Productos`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `precio` DECIMAL(5,2) NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`id`));