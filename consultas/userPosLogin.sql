use punto_venta;

create user 'poslogin'@'localhost' identified by 'poslogin';
grant select on punto_venta.Vendedor to 'poslogin'@'localhost' identified by 'poslogin';

grant update on punto_venta.Producto to 'poslogin'@'localhost' identified by 'poslogin';

flush privileges;