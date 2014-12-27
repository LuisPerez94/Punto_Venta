use punto_venta;

create user 'administrador'@'%' identified by '123pass';
grant all on punto_venta.* to 'administrador'@'%' identified by '123pass';

