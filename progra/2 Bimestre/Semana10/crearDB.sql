
CREATE SCHEMA `factura` ;

CREATE TABLE `factura`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `Codigo` VARCHAR(5) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `Cantidad` INT NULL DEFAULT 0,
  `PrecioU` DOUBLE NULL,
  `PVP` DOUBLE NULL,
  `FechaIngreso` VARCHAR(10) NULL,
  `FechaM` VARCHAR(10) NULL,
  PRIMARY KEY (`idProducto`));

