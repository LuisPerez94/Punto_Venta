use punto_venta;

create user 'vendedor'@'localhost' identified by '123pass';
grant select on punto_venta.producto to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.cliente to 'vendedor'@'%' identified by '123pass';
grant delete on punto_venta.detalle_fact to 'vendedor'@'%' identified by '123pass';
grant delete on punto_venta.cab_fact to 'vendedor'@'%' identified by '123pass';
grant insert on punto_venta.detalle_fact to 'vendedor'@'%' identified by '123pass';
grant insert on punto_venta.cab_fact to 'vendedor'@'%' identified by '123pass';
grant update on punto_venta.detalle_fact to 'vendedor'@'%' identified by '123pass';
grant update on punto_venta.cab_fact to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.guarda to 'vendedor'@'%' identified by '123pass';
grant select on punto_venta.almacen to 'vendedor'@'%' identified by '123pass';