SELECT * FROM cooperativa.cajero;
INSERT INTO `cooperativa`.`cajero` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1102', 'Carchi', 'Fernando', '2');
INSERT INTO `cooperativa`.`cajero` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1103', 'Perez', 'Juan', '3');
INSERT INTO `cooperativa`.`cajero` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1104', 'Lucas', 'Manuel', '4');
INSERT INTO `cooperativa`.`cajero` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1105', 'Juminez', 'Carlos', '5');

INSERT INTO `cooperativa`.`cliente` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1102', 'Carchi', 'Fernando', '2');
INSERT INTO `cooperativa`.`cliente` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1103', 'Perez', 'Juan', '3');
INSERT INTO `cooperativa`.`cliente` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1104', 'Lucas', 'Manuel', '4');
INSERT INTO `cooperativa`.`clienteoficial` (`Cedula`, `Apellidos`, `Nombres`, `Caja`) VALUES ('1105', 'Juminez', 'Carlos', '5');

INSERT INTO `cooperativa`.`oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1102', 'Carchi', 'Fernando', 'S2');
INSERT INTO `cooperativa`.`oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1103', 'Perez', 'Juan', 'S3');
INSERT INTO `cooperativa`.`oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1104', 'Lucas', 'Manuel', 'S4');
INSERT INTO `cooperativa`.`oficial` (`Cedula`, `Apellidos`, `Nombres`, `Sucursal`) VALUES ('1105', 'Juminez', 'Carlos', 'S5');

INSERT INTO `cooperativa`.`cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2101', '1', '45', '1');
INSERT INTO `cooperativa`.`cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2102', '1', '100', '2');
INSERT INTO `cooperativa`.`cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2103', '1', '100', '3');
INSERT INTO `cooperativa`.`cuenta` (`Numero`, `Tipo`, `Saldo`, `idOfic`) VALUES ('2104', '0', '200', '1');


INSERT INTO `cooperativa`.`clientecuentas` (`idClie`, `idCuen`, `Autorizado`) VALUES ('4', '4', '1');
#Insertar CuentaAutor
INSERT INTO `cooperativa`.`cuenauto` (`idClie`, `idCuen`, `FechaAutori`) VALUES ('2', '2', '2018-11-11');
#Insertar TRANSACCION
INSERT INTO `cooperativa`.`transaccion` (`Numero`, `Fecha`, `Valor`, `Tipo`, `idCaje`, `idCuenta`) VALUES ('1', '2018-05-12', '1', 'corriente', '1', '1');
#Insertar transferencias
INSERT INTO `cooperativa`.`transferencias` (`Numero`, `idCuen`, `idCuenAuto`, `Fecha`, `Valor`, `Observacion`) VALUES ('1', '1', '1', '2018-06-10', '1', 'hola');
INSERT INTO `cooperativa`.`transferencias` (`Numero`, `idCuen`, `idCuenAuto`, `Fecha`, `Valor`, `Observacion`) VALUES ('2', '1', '2', '2018-06-11', '2', 'que tal');


