SELECT * FROM factura.producto;

SELECT codigo, descripcion FROM factura.producto;

SELECT codigo CodigoProducto, descripcion DescripcionProducto FROM factura.producto;

SELECT codigo, descripcion FROM factura.producto WHERE codigo = 002;

SELECT codigo, descripcion FROM factura.producto order by 2;

SELECT codigo, pvp FROM factura.producto WHERE pvp > 5;

SELECT codigo, descripcion  FROM factura.producto WHERE codigo = 002;

SELECT codigo, descripcion 
FROM factura.producto
ORDER BY descripcion ASC;