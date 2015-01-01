USE punto_venta;

SELECT Producto.idProducto, Producto.nombreProducto, SUM(Detalle_fact.cantidadProducto) vendidos

FROM Cab_fact, Detalle_fact, Producto

WHERE Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact
	AND	Detalle_fact.Producto_idProducto = Producto.idProducto

GROUP BY Producto.idProducto

ORDER BY vendidos DESC

LIMIT 10