use punto_venta;

create user 'poslogin'@'localhost' identified by 'poslogin';
grant select on punto_venta.Vendedor to 'poslogin'@'localhost' identified by 'poslogin';
flush privileges;