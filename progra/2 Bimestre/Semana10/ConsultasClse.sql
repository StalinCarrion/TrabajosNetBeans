Select * from cliente;
#select * from cliente order by apellidos desc;
select idClie, cedula, nombres, apellidos,
concat('Loja: ', direccion) as Direccion
from cliente order by 3 desc;

Select idCuen, Numero, Saldo, IdOfic,
if(Tipo=1,'ahorro','corriente') as Tipo 
from cuenta;

Select * from cuenta;

Select * from oficial;

Select * from cuenta, oficial
where cuenta.idOfic = oficial.idOfic;

Select cuenta.*, Apellidos, Nombres from cuenta, oficial
where cuenta.idOfic = oficial.idOfic;

Select cuenta.*, Apellidos, Nombres, oficial.idOfic 
from cuenta, oficial
where cuenta.idOfic = oficial.idOfic;

select cuenta.*, cedula, apellidos, nombres
from cuenta, clientecuentas, cliente
where cuenta.idCuen = clientecuentas.idCuen
and cliente.idClie = clientecuentas.idClie;

select cuenta.*, cedula, apellidos, nombres
from cuenta, clientecuentas, cliente
where cuenta.idCuen = clientecuentas.idCuen
and cliente.idClie = clientecuentas.idClie
and numero = '2104';
#CRUD DE UNA BASE DE DATOS
Insert into cuenta (Numero, Tipo, Saldo, idOfic) values ('2105',1,50,3);
#para saber el id de cuentas
select max(Idcuen) from cuenta;
#eliminar transaccion, solo se puede eliminar cuando son tablas padre no hijas.
Delete from transaccion;
delete from cuenta where numero = '2104';
# actualizar
update cuenta set tipo = 2, saldo = 100 where tipo = 0;