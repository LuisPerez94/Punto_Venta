USE punto_venta;

SELECT Vendedor.idVendedor, Vendedor.nombreVendedor, Producto.idProducto, Producto.nombreProducto, SUM(Detalle_fact.cantidadProducto) ProductosVendidos, 
	SUM(Producto.precio * Detalle_fact.cantidadProducto) VentaPorVendedor

FROM Cab_fact, Detalle_fact, Producto, Vendedor

WHERE Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact
	AND	Detalle_fact.Producto_idProducto = Producto.idProducto
    AND Cab_fact.Vendedor_idVendedor = Vendedor.idVendedor
    AND Detalle_fact.fechaVenta BETWEEN '2013-1-1' AND '2014-7-7'

				/* En el between se deben poner las fechas del rango */

GROUP BY Vendedor.idVendedor, Producto.idProducto