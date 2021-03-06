use punto_venta;

create user 'vendedor'@'localhost' identified by '123pass';
grant select on punto_venta.Producto to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.Cliente to 'vendedor'@'%' identified by '123pass';
grant delete on punto_venta.Detalle_fact to 'vendedor'@'%' identified by '123pass';
grant delete on punto_venta.Cab_fact to 'vendedor'@'%' identified by '123pass';
grant insert on punto_venta.Detalle_fact to 'vendedor'@'%' identified by '123pass';
grant insert on punto_venta.Cab_fact to 'vendedor'@'%' identified by '123pass';
grant update on punto_venta.Detalle_fact to 'vendedor'@'%' identified by '123pass';
grant update on punto_venta.Cab_fact to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.Guarda to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.Almacen to 'vendedor'@'%' identified by '123pass';
FLUSH PRIVILEGES;