use punto_venta;

create user 'administrador'@'localhost' identified by '123pass';
grant all on punto_venta.* to 'administrador'@'localhost' identified by '123pass';
flush privileges;