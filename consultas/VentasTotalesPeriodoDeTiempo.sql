USE punto_venta;

/* Venta total de cada producto en ese periodo de tiempo*/

SELECT Producto.idProducto, Producto.nombreProducto, SUM(Detalle_fact.cantidadProducto) vendidos, 
	SUM(Producto.precio * Detalle_fact.cantidadProducto) ventaPorProducto

FROM Cab_fact, Detalle_fact, Producto

WHERE Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact
	AND	Detalle_fact.Producto_idProducto = Producto.idProducto
    AND Detalle_fact.fechaVenta BETWEEN '2013-1-1' AND '2014-7-7'

GROUP BY Producto.idProducto

/* Venta $$ total en ese periodo de tiempo */

/*
SELECT * 

		FROM(SELECT SUM(Producto.precio * Detalle_fact.cantidadProducto)

			FROM Cab_fact, Detalle_fact, Producto

			WHERE Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact
				AND	Detalle_fact.Producto_idProducto = Producto.idProducto
				AND Detalle_fact.fechaVenta BETWEEN '2013-1-1' AND '2013-3-3') suma
                
*/