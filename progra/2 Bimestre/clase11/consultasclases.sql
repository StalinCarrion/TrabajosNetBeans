Select * from cliente;

select idClie, cedula, aPellidos, nombres, 
concat('Loja: ',direccion) as Direccion
 from cliente order by 3 desc;
 
Select idCuen, Numero,  Saldo, IdOfic, Tipo,
	if(Tipo=1,'Ahorro','Corriente') as Tipo
from cuenta;

Select * from cuenta;

select * from oficial;

select * from cuenta, oficial
where cuenta.idOfic = oficial.idOfic;

select cuenta.*, Apellidos, Nombres, oficial.idOfic 
from cuenta, oficial
where cuenta.idOfic = oficial.idOfic;

select cuenta.*, cedula, apellidos, nombres
 from cuenta, clientecuentas, cliente
where cuenta.idcuen = clientecuentas.idcuen
and cliente.idclie = clientecuentas.idclie
and Numero = '2103';

Insert into cuenta (idCuen,numero,tipo,saldo,idOfic) 
	values (10,'2106',1,50,4);

Select max(Idcuen)+1 from cuenta;

delete from transaccion;

delete from cuenta where numero = '2106';

update cuenta set tipo = 2, saldo = 100 where tipo = 0;


