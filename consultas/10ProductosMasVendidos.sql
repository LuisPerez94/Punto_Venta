USE punto_venta;

SELECT Producto.idProducto Codigo, Producto.nombreProducto Nombre, Producto.descripcionProducto Descripcion, 
			Producto.precio Precio, SUM(Detalle_fact.cantidadProducto) CantVendidos,
				SUM(Producto.precio*Detalle_fact.cantidadProducto) IngresosPorProducto

FROM Cab_fact, Detalle_fact, Producto

WHERE Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact
	AND	Detalle_fact.Producto_idProducto = Producto.idProducto
	AND Detalle_fact.fechaVenta = (SELECT CURDATE())

GROUP BY Producto.idProducto

ORDER BY CantVendidos DESC

LIMIT 10;