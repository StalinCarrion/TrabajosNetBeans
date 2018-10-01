

DROP TABLE IF EXISTS   `transaccion`;
DROP TABLE IF EXISTS   `transferencias`;
DROP TABLE IF EXISTS   `clientecuentas`;
DROP TABLE IF EXISTS   `cuenauto`;
DROP TABLE IF EXISTS   `cliente`;
DROP TABLE IF EXISTS   `cuenta`;
DROP TABLE IF EXISTS   `cajero`;
DROP TABLE IF EXISTS   `oficial`;


/*EJECUTAR SI EL ESQUEMA ESTA VACIO*/
CREATE TABLE  IF NOT EXISTS `cajero` (
  `idCaje` int(11) NOT NULL AUTO_INCREMENT,
  `Cedula` varchar(10) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Caja` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCaje`),
  UNIQUE KEY `Cedula_UNIQUE` (`Cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cliente` (
  `idClie` int(11) NOT NULL AUTO_INCREMENT,
  `Cedula` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClie`),
  UNIQUE KEY `Cedula_UNIQUE` (`Cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `oficial` (
  `idOfic` int(11) NOT NULL AUTO_INCREMENT,
  `Cedula` varchar(10) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Sucursal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idOfic`),
  UNIQUE KEY `Cedula_UNIQUE` (`Cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `cuenta` (
  `idCuen` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` varchar(15) NOT NULL,
  `Tipo` int(11) NOT NULL,
  `Saldo` decimal(8,2) DEFAULT '0.00',
  `idOfic` int(11) NOT NULL,
  PRIMARY KEY (`idCuen`),
  KEY `fk_Cuenta_Oficial1_idx` (`idOfic`),
  CONSTRAINT `fk_Cuenta_Oficial1` FOREIGN KEY (`idOfic`) REFERENCES `oficial` (`idOfic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `clientecuentas` (
  `idClieCuen` int(11) NOT NULL AUTO_INCREMENT,
  `idClie` int(11) NOT NULL,
  `idCuen` int(11) NOT NULL,
  `Autorizado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idClieCuen`),
  KEY `fk_ClienteCuentas_Cliente1_idx` (`idClie`),
  KEY `fk_ClienteCuentas_Cuenta1_idx` (`idCuen`),
  CONSTRAINT `fk_ClienteCuentas_Cliente1` FOREIGN KEY (`idClie`) REFERENCES `cliente` (`idClie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClienteCuentas_Cuenta1` FOREIGN KEY (`idCuen`) REFERENCES `cuenta` (`idCuen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cuenauto` (
  `idCuenAuto` int(11) NOT NULL AUTO_INCREMENT,
  `idClie` int(11) NOT NULL,
  `idCuen` int(11) NOT NULL,
  `FechaAutori` date NOT NULL,
  PRIMARY KEY (`idCuenAuto`),
  KEY `fk_CuenAuto_Cliente1_idx` (`idClie`),
  KEY `fk_CuenAuto_Cuenta1_idx` (`idCuen`),
  CONSTRAINT `fk_CuenAuto_Cliente1` FOREIGN KEY (`idClie`) REFERENCES `cliente` (`idClie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CuenAuto_Cuenta1` FOREIGN KEY (`idCuen`) REFERENCES `cuenta` (`idCuen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `transaccion` (
  `idTran` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` varchar(8) NOT NULL,
  `Fecha` date NOT NULL,
  `Valor` decimal(8,2) NOT NULL,
  `Tipo` int(11) NOT NULL,
  `idCaje` int(11) NOT NULL,
  `idCuen` int(11) NOT NULL,
  PRIMARY KEY (`idTran`),
  UNIQUE KEY `Numero_UNIQUE` (`Numero`),
  KEY `fk_Transaccion_Cajero_idx` (`idCaje`),
  KEY `fk_Transaccion_Cuenta1_idx` (`idCuen`),
  CONSTRAINT `fk_Transaccion_Cajero` FOREIGN KEY (`idCaje`) REFERENCES `cajero` (`idCaje`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaccion_Cuenta1` FOREIGN KEY (`idCuen`) REFERENCES `cuenta` (`idCuen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `transferencias` (
  `idTran` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` varchar(10) NOT NULL,
  `idCuen` int(11) NOT NULL,
  `idCuenAuto` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Valor` decimal(8,2) NOT NULL,
  `Observacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTran`),
  KEY `fk_Transferencias_CuenAuto1_idx` (`idCuenAuto`),
  KEY `fk_Transferencias_Cuenta1_idx` (`idCuen`),
  CONSTRAINT `fk_Transferencias_CuenAuto1` FOREIGN KEY (`idCuenAuto`) REFERENCES `cuenauto` (`idCuenAuto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transferencias_Cuenta1` FOREIGN KEY (`idCuen`) REFERENCES `cuenta` (`idCuen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DELETE FROM   `transaccion`;
DELETE FROM   `transferencias`;
DELETE FROM   `clientecuentas`;
DELETE FROM   `cuenauto`;
DELETE FROM   `cuenta`;
DELETE FROM   `cajero`;
DELETE FROM   `cliente`;
DELETE FROM   `oficial`;


ALTER TABLE   `cliente` AUTO_INCREMENT = 1 ;
ALTER TABLE   `cajero` AUTO_INCREMENT = 1 ;
ALTER TABLE   `oficial` AUTO_INCREMENT = 1 ;
ALTER TABLE   `cuenta` AUTO_INCREMENT = 1 ;
ALTER TABLE   `clientecuentas` AUTO_INCREMENT = 1 ;
ALTER TABLE   `cuenauto` AUTO_INCREMENT = 1 ;
ALTER TABLE   `cuenauto` AUTO_INCREMENT = 1;
ALTER TABLE   `transaccion` AUTO_INCREMENT = 1;
ALTER TABLE   `transferencias` AUTO_INCREMENT = 1;


INSERT INTO   `cajero` (`Cedula`, `Apellidos`, `Nombres`, `caja`) VALUES ('1101', 'CAJA01', 'caja01', '1');
INSERT INTO   `cajero` (`Cedula`, `Apellidos`, `Nombres`, `caja`) VALUES ('1102', 'CAJA02', 'caja02', '2');
INSERT INTO   `cajero` (`Cedula`, `Apellidos`, `Nombres`, `caja`) VALUES ('1103', 'CAJA03', 'caja03', '3');
INSERT INTO   `cajero` (`Cedula`, `Apellidos`, `Nombres`, `caja`) VALUES ('1104', 'CAJA04', 'caja04', '4');


INSERT INTO   `cliente` (`Cedula`, `Apellidos`, `Nombres`, `Direccion`) VALUES ('1201', 'CLIENTE1', 'cliente1', 'dir1');
INSERT INTO   `cliente` (`Cedula`, `Apellidos`, `Nombres`, `Direccion`) VALUES ('1202', 'CLIENTE2', 'cliente2', 'dir2');
INSERT INTO   `cliente` (`Cedula`, `Apellidos`, `Nombres`, `Direccion`) VALUES ('1203', 'CLIENTE3', 'cliente3', 'dir3');
INSERT INTO   `cliente` (`Cedula`, `Apellidos`, `Nombres`, `Direccion`) VALUES ('1204', 'CLIENTE4', 'cliente4', 'dir4');


INSERT INTO   `oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1301', 'OFICIAL1', 'oficial1', '1');
INSERT INTO   `oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1302', 'OFICIAL2', 'oficial2', '2');
INSERT INTO   `oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1303', 'OFICIAL3', 'oficial3', '3');
INSERT INTO   `oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1304', 'OFICIAL4', 'oficial4', '4');


INSERT INTO   `cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2101', '1', '45', '1');
INSERT INTO   `cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2102', '1', '100', '1');
INSERT INTO   `cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2103', '1', '100', '2');
INSERT INTO   `cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2104', '0', '200', '2');
INSERT INTO   `cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2105', '0', '1000', '3');


INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('1', '1', '1');
INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('2', '2', '1');
INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('2', '3', '1');
INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('3', '3', '0');
INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('4', '4', '1');
INSERT INTO   `clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('4', '5', '1');

INSERT INTO   `cuenauto` (`idClie`, `idCuen`) VALUES ('1', '2');
INSERT INTO   `cuenauto` (`idClie`, `idCuen`) VALUES ('1', '3');
INSERT INTO   `cuenauto` (`idClie`, `idCuen`) VALUES ('3', '1');
INSERT INTO   `cuenauto` (`idClie`, `idCuen`) VALUES ('2', '4');
INSERT INTO   `cuenauto` (`idClie`, `idCuen`) VALUES ('4', '1');

INSERT INTO   `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('001', '2018-1-1', '50', '1', '1', '1');
INSERT INTO   `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('002', '2018-1-1', '100', '1', '1', '1');
INSERT INTO   `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('003', '2018-1-1', '40', '1', '1', '2');
INSERT INTO `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('004', '2018-1-1', '50', '2', '1', '3');
INSERT INTO `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('005', '2018-1-1', '80', '2', '1', '4');
INSERT INTO `transaccion` (`Numero`, `Fecha`, `valor`, `tipo`, `idCaje`, `idCuen`) VALUES ('006', '2018-1-1', '200', '2', '1', '2');


INSERT INTO `transferencias` (`Numero`, `idCuen`, `idCuenAuto`,`fecha`, `valor`) VALUES ('001', '1', '3','2018-6-1', '40');
INSERT INTO `transferencias` (`Numero`, `idCuen`, `idCuenAuto`, `fecha`,`valor`) VALUES ('002', '4', '1','2018-6-1', '80');

