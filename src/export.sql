--------------------------------------------------------
-- Archivo creado  - viernes-junio-12-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ALMACEN
--------------------------------------------------------

  CREATE TABLE "LUIS"."ALMACEN" 
   (	"IDALMACEN" CHAR(4 BYTE), 
	"DESCRIPCIONALMACEN" VARCHAR2(80 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CABFACTURA
--------------------------------------------------------

  CREATE TABLE "LUIS"."CABFACTURA" 
   (	"IDCABFACTURA" CHAR(4 BYTE), 
	"IDCLIENTE" CHAR(4 BYTE), 
	"IDVENDEDOR" CHAR(4 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "LUIS"."CLIENTE" 
   (	"IDCLIENTE" CHAR(4 BYTE), 
	"NOMBRECLIENTE" VARCHAR2(45 BYTE), 
	"APPATERNO" VARCHAR2(15 BYTE), 
	"APMATERNO" VARCHAR2(15 BYTE), 
	"DIRECCIONCLIENTE" VARCHAR2(80 BYTE), 
	"CORREOCLIENTE" VARCHAR2(40 BYTE), 
	"TELEFONOCLIENTE" NUMBER(10,0) DEFAULT 0, 
	"SEXOCLIENTE" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DETALLEFACTURA
--------------------------------------------------------

  CREATE TABLE "LUIS"."DETALLEFACTURA" 
   (	"IDDETALLEFACT" CHAR(4 BYTE), 
	"IDCABFACTURA" CHAR(4 BYTE), 
	"IDPRODUCTO" CHAR(4 BYTE), 
	"CANTIDADPRODUCTO" NUMBER DEFAULT 0, 
	"FECHAVENTA" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GUARDA
--------------------------------------------------------

  CREATE TABLE "LUIS"."GUARDA" 
   (	"IDGUARDA" CHAR(4 BYTE), 
	"IDPRODUCTO" CHAR(4 BYTE), 
	"IDALMACEN" CHAR(4 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LOGS
--------------------------------------------------------

  CREATE TABLE "LUIS"."LOGS" 
   (	"USUARIO" VARCHAR2(40 BYTE), 
	"TABLA_MODIFICADA" VARCHAR2(40 BYTE), 
	"FECHA_MOD" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "LUIS"."PRODUCTO" 
   (	"IDPRODUCTO" CHAR(4 BYTE), 
	"NOMPRODUCTO" VARCHAR2(15 BYTE), 
	"PRECIOPRODUCTO" FLOAT(126), 
	"DESCRIPCIONPRODUCTO" VARCHAR2(80 BYTE), 
	"IMAGEN" VARCHAR2(80 BYTE), 
	"EXISTENCIA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table VENDEDOR
--------------------------------------------------------

  CREATE TABLE "LUIS"."VENDEDOR" 
   (	"IDVENDEDOR" CHAR(4 BYTE), 
	"NOMVENDEDOR" VARCHAR2(20 BYTE), 
	"APPATERNOVENDEDOR" VARCHAR2(15 BYTE), 
	"APMATERNOVENDEDOR" VARCHAR2(15 BYTE), 
	"FECHANACVENDEDOR" DATE, 
	"CORREOVENDEDOR" VARCHAR2(40 BYTE), 
	"DIRECCIONVENDEDOR" VARCHAR2(80 BYTE), 
	"SEXOVENDEDOR" VARCHAR2(1 BYTE), 
	"FECHAINGRESOVENDEDOR" DATE, 
	"SUELDOVENDEDOR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View CLIENTES_MAS_COMPRAS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "LUIS"."CLIENTES_MAS_COMPRAS" ("IDCLIENTE", "NUMERO_COMPRAS", "APPATERNO", "APMATERNO", "NOMBRECLIENTE") AS 
  select distinct cabfactura.IDCLIENTE, count(cabfactura.idcliente) as Numero_Compras, cliente.APPATERNO, 
cliente.APMATERNO, cliente.NOMBRECLIENTE
from cliente, cabfactura
where cabfactura.idcliente = cliente.idcliente
group by cabfactura.IDCLIENTE, cliente.idcliente, cliente.APPATERNO, 
cliente.APMATERNO, cliente.NOMBRECLIENTE
order by cabfactura.IDCLIENTE;
--------------------------------------------------------
--  DDL for View PRODUCTOMASVENDIDOS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "LUIS"."PRODUCTOMASVENDIDOS" ("IDPRODUCTO", "NOMPRODUCTO", "VENDIDOS") AS 
  SELECT Producto.idProducto, Producto.nomProducto, SUM(Detallefactura.cantidadProducto) vendidos

FROM Cabfactura, Detallefactura, Producto

WHERE Cabfactura.idCabfactura = Detallefactura.idCabfactura
	AND	Detallefactura.idProducto = Producto.idProducto

GROUP BY Producto.idProducto,Producto.nomProducto
ORDER BY vendidos DESC;
--------------------------------------------------------
--  DDL for View PRODUCTOSPORFECHA
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "LUIS"."PRODUCTOSPORFECHA" ("IDPRODUCTO", "NOMPRODUCTO", "PRECIOPRODUCTO", "FECHAVENTA", "VENDIDOS", "VENTAPORPRODUCTO") AS 
  SELECT Producto.idProducto, Producto.nomProducto,Producto.precioproducto,
        Detallefactura.FECHAVENTA,
SUM(Detallefactura.cantidadProducto) vendidos,
          SUM(Producto.precioproducto * Detallefactura.cantidadProducto) 
          ventaPorProducto 
          FROM Cabfactura, Detallefactura, Producto
          WHERE Cabfactura.idCabfactura = Detallefactura.idCabfactura AND Detallefactura.idProducto = Producto.idProducto 
                        AND Detallefactura.fechaVenta
                        BETWEEN  '03-03-2013' AND '03-08-2015' 
                        GROUP BY Producto.IDPRODUCTO,Producto.NOMPRODUCTO, Producto.PRECIOPRODUCTO,
                        Detallefactura.FECHAVENTA;
--------------------------------------------------------
--  DDL for View VENDEDORES_MAS_VENTAS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "LUIS"."VENDEDORES_MAS_VENTAS" ("IDVENDEDOR", "NUMERO_VENTAS", "APPATERNOVENDEDOR", "APMATERNOVENDEDOR", "NOMVENDEDOR") AS 
  select cabfactura.idvendedor, count(cabfactura.IDVENDEDOR) as Numero_ventas, 
vendedor.APPATERNOVENDEDOR, 
vendedor.APMATERNOVENDEDOR, VENDEDOR.NOMVENDEDOR
from vendedor, cabfactura
where cabfactura.idvendedor = vendedor.idvendedor
group by cabfactura.idvendedor, vendedor.APPATERNOVENDEDOR, 
vendedor.APMATERNOVENDEDOR, VENDEDOR.NOMVENDEDOR
order by cabfactura.idvendedor;
REM INSERTING into LUIS.ALMACEN
SET DEFINE OFF;
Insert into LUIS.ALMACEN (IDALMACEN,DESCRIPCIONALMACEN) values ('1   ','Almacen 1');
REM INSERTING into LUIS.CABFACTURA
SET DEFINE OFF;
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('10  ','4   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('1   ','1   ','1   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('2   ','2   ','2   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('3   ','3   ','3   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('4   ','1   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('5   ','2   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('6   ','3   ','3   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('7   ','3   ','1   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('8   ','3   ','1   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('9   ','2   ','1   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('11  ','7   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('13  ','9   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('12  ','2   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('14  ','8   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('15  ','3   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('16  ','3   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('17  ','3   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('18  ','3   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('19  ','3   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('20  ','8   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('21  ','8   ','4   ');
Insert into LUIS.CABFACTURA (IDCABFACTURA,IDCLIENTE,IDVENDEDOR) values ('22  ','2   ','4   ');
REM INSERTING into LUIS.CLIENTE
SET DEFINE OFF;
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('2   ','Rafael ','Marquez','Solano','Victoria 12','rafitamar@gmail.com',4192382,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('3   ','Francisco','Rodriguez','Madero','Juarez 20','pacorodriguez@yahoo.com',2947726,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('4   ','Hector','Moreno','Blanco','Heroes de Puebla 201','hectormorblan@gmail.com',9820123,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('1   ','Jesus','Corona','Modelo','Carlos Cruz 10','chuycorona@hotmail.com',1234656,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('5   ','Paul','Aguilar','Cruz','Hidalgo 291','paulaguilar@hotmail.com',3783461,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('6   ','Miguel','Layun','Fernandez','Mancilla 284','todoesculpadelayun@gmail.com',7894622,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('7   ','Jose','Vazquez','Vazquez','qwerty 78','gallovazquez@gmail.com',9187633,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('8   ','Hector','Herrera','Guzman','Arteaga 28','hectorherrera@hotmail.com',3126745,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('9   ','Andres','Guardado','Amione','Independencia 23','andresguarda@hotmail.com',2375423,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('10  ','Giovanni','dos Santos','Aveiro','5 de mayo 56','belindagolosa69@yahoo.com',4736241,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('11  ','Javier','Hernandez','Balcazar','España 89','chicharito14@hotmail.com',2734685,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('12  ','Gabriela','Rodriguez ','Medina','Procuraduria 82','gabyrodriguez@gmail.com',5637426,'F');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('17  ','jr','m','s','n/a','js@gmai',123132,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('18  ','Rey','Mw','To','rmt','rmt@gamil.com',1234567890,'M');
Insert into LUIS.CLIENTE (IDCLIENTE,NOMBRECLIENTE,APPATERNO,APMATERNO,DIRECCIONCLIENTE,CORREOCLIENTE,TELEFONOCLIENTE,SEXOCLIENTE) values ('19  ','Luis','Bernardo','Ballesteros','Calle Debian','debianLoamo@gmail.com',12345678,'M');
REM INSERTING into LUIS.DETALLEFACTURA
SET DEFINE OFF;
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('21  ','13  ','1   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('22  ','14  ','6   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('18  ','10  ','3   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('19  ','11  ','2   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('23  ','15  ','5   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('25  ','17  ','1   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('26  ','17  ','4   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('27  ','18  ','4   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('28  ','19  ','4   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('29  ','20  ','4   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('30  ','21  ','2   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('24  ','16  ','5   ',1,to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('31  ','22  ','9   ',1,to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('32  ','22  ','1   ',1,to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('1   ','1   ','1   ',2,to_date('01/01/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('2   ','1   ','2   ',1,to_date('01/01/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('3   ','1   ','3   ',1,to_date('01/01/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('4   ','2   ','6   ',2,to_date('02/02/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('5   ','2   ','7   ',1,to_date('02/02/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('6   ','3   ','4   ',2,to_date('03/03/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('7   ','3   ','8   ',2,to_date('03/03/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('8   ','3   ','2   ',1,to_date('03/03/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('9   ','4   ','1   ',2,to_date('05/05/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('10  ','5   ','7   ',1,to_date('06/06/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('11  ','6   ','3   ',2,to_date('08/08/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('12  ','6   ','2   ',1,to_date('08/08/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('13  ','6   ','8   ',2,to_date('08/08/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('14  ','7   ','5   ',2,to_date('10/10/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('15  ','7   ','6   ',2,to_date('10/10/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('16  ','8   ','9   ',1,to_date('12/12/13','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('17  ','9   ','9   ',1,to_date('01/01/14','DD/MM/RR'));
Insert into LUIS.DETALLEFACTURA (IDDETALLEFACT,IDCABFACTURA,IDPRODUCTO,CANTIDADPRODUCTO,FECHAVENTA) values ('20  ','12  ','9   ',2,to_date('10/06/15','DD/MM/RR'));
REM INSERTING into LUIS.GUARDA
SET DEFINE OFF;
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('1   ','1   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('2   ','2   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('3   ','3   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('4   ','4   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('5   ','5   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('6   ','6   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('7   ','7   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('8   ','8   ','1   ');
Insert into LUIS.GUARDA (IDGUARDA,IDPRODUCTO,IDALMACEN) values ('9   ','9   ','1   ');
REM INSERTING into LUIS.LOGS
SET DEFINE OFF;
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('08/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','almacen',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','guarda',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('09/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('10/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cabfactura',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','detallefactura',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','cliente',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','vendedor',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
Insert into LUIS.LOGS (USUARIO,TABLA_MODIFICADA,FECHA_MOD) values ('LUIS','producto',to_date('11/06/15','DD/MM/RR'));
REM INSERTING into LUIS.PRODUCTO
SET DEFINE OFF;
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('1   ','Playera
',400,'100 % Algodon , Colores: Azul,Blanca,Roja,Amarilla. Tallas G.M.CH.ECH','src/img/productos/camisetadeportiva1.jpg',0);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('2   ','Tenis
',600,'Tallas: 21-28  ','src/img/productos/tenis.jpg',0);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('3   ','Balon Basquet',250,'Como el que usan en la NBA','src/img/productos/pelotabasquet.jpg',1);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('4   ','Raqueta',150,'Mango metalico','src/img/productos/raqueta.jpg',0);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('5   ','Rodilleras',100,'Colores: Blanca , Negro','src/img/productos/rodilleras.jpg',1);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('6   ','Coderas',100,'Colores: Blaca, Negro','src/img/productos/coderas.jpg',1);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('7   ','Casco',350,'Colores, blanco, negro','src/img/productos/cascobici.jpg',11);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('8   ','BandasToallas',200,'90 % algodon 10% poliester Marca: Nike Colores: Azul Blanco Rosa Rojo','src/img/productos/bandatoalla.jpg',1);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('9   ','SmartBand',2000,'La SmartBand mas smart del mercado','src/img/productos/smartband.jpg',110);
Insert into LUIS.PRODUCTO (IDPRODUCTO,NOMPRODUCTO,PRECIOPRODUCTO,DESCRIPCIONPRODUCTO,IMAGEN,EXISTENCIA) values ('10  ','Nave Espacial',39999,'Increible nave espacial','src/img/productos/nave.jpg',12);
REM INSERTING into LUIS.VENDEDOR
SET DEFINE OFF;
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('1   ','Fernando','Bobadilla','Contreras',to_date('05/10/93','DD/MM/RR'),'mbobadilla@outlook.com','Carlos 123','M',to_date('26/02/13','DD/MM/RR'),30000);
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('2   ','Jose Ramon','Marquez','Solano',to_date('06/01/92','DD/MM/RR'),'jrms@gmail.com','cordoba 23','M',to_date('20/06/13','DD/MM/RR'),15000);
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('3   ','Ruben','Perez','Rodriguez',to_date('22/06/94','DD/MM/RR'),'crumac22@gmail.com','aeropuerts 6','M',to_date('14/02/14','DD/MM/RR'),5000);
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('4   ','Luis','Perez','Muñoz',to_date('26/07/94','DD/MM/RR'),'ingluisperez.m@outlook,com','Rio Esva 131-4 Lomas de Rio Medio 4','M',to_date('04/04/14','DD/MM/RR'),9000);
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('5   ','Karen','Garcia','Robles',to_date('02/02/90','DD/MM/RR'),'grkaren@gmail.com','Calle de la perdicion #89 Col.Margarita','F',to_date('02/02/14','DD/MM/RR'),5555);
Insert into LUIS.VENDEDOR (IDVENDEDOR,NOMVENDEDOR,APPATERNOVENDEDOR,APMATERNOVENDEDOR,FECHANACVENDEDOR,CORREOVENDEDOR,DIRECCIONVENDEDOR,SEXOVENDEDOR,FECHAINGRESOVENDEDOR,SUELDOVENDEDOR) values ('6   ','Luis','Vendedot','Vendedor',to_date('26/07/94','DD/MM/RR'),'dbf@hotmail.com','fbfubfuf','M',to_date('11/06/15','DD/MM/RR'),2000);
--------------------------------------------------------
--  DDL for Index PK_GUARDA
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_GUARDA" ON "LUIS"."GUARDA" ("IDGUARDA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_CABFACTURA
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_CABFACTURA" ON "LUIS"."CABFACTURA" ("IDCABFACTURA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_VENDEDOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_VENDEDOR" ON "LUIS"."VENDEDOR" ("IDVENDEDOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index U_CORREOVENDEDOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."U_CORREOVENDEDOR" ON "LUIS"."VENDEDOR" ("CORREOVENDEDOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_PRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_PRODUCTO" ON "LUIS"."PRODUCTO" ("IDPRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_IDDETALLEFACT
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_IDDETALLEFACT" ON "LUIS"."DETALLEFACTURA" ("IDDETALLEFACT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ALMACEN
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_ALMACEN" ON "LUIS"."ALMACEN" ("IDALMACEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index U_CORREOCLIENTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."U_CORREOCLIENTE" ON "LUIS"."CLIENTE" ("CORREOCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_CLIENTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."PK_CLIENTE" ON "LUIS"."CLIENTE" ("IDCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index U_TELEFONOCLIENTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "LUIS"."U_TELEFONOCLIENTE" ON "LUIS"."CLIENTE" ("TELEFONOCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table DETALLEFACTURA
--------------------------------------------------------

  ALTER TABLE "LUIS"."DETALLEFACTURA" ADD CONSTRAINT "PK_IDDETALLEFACT" PRIMARY KEY ("IDDETALLEFACT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LUIS"."DETALLEFACTURA" ADD CONSTRAINT "CK_CANTIDADPRODUCTO" CHECK (cantidadproducto >= 0) ENABLE;
  ALTER TABLE "LUIS"."DETALLEFACTURA" MODIFY ("IDDETALLEFACT" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."DETALLEFACTURA" MODIFY ("IDCABFACTURA" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."DETALLEFACTURA" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."DETALLEFACTURA" MODIFY ("CANTIDADPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."DETALLEFACTURA" MODIFY ("FECHAVENTA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GUARDA
--------------------------------------------------------

  ALTER TABLE "LUIS"."GUARDA" ADD CONSTRAINT "PK_GUARDA" PRIMARY KEY ("IDGUARDA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."GUARDA" MODIFY ("IDALMACEN" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."GUARDA" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."GUARDA" MODIFY ("IDGUARDA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CABFACTURA
--------------------------------------------------------

  ALTER TABLE "LUIS"."CABFACTURA" ADD CONSTRAINT "PK_CABFACTURA" PRIMARY KEY ("IDCABFACTURA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."CABFACTURA" MODIFY ("IDVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CABFACTURA" MODIFY ("IDCLIENTE" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CABFACTURA" MODIFY ("IDCABFACTURA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "LUIS"."PRODUCTO" ADD CONSTRAINT "PK_PRODUCTO" PRIMARY KEY ("IDPRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."PRODUCTO" MODIFY ("PRECIOPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."PRODUCTO" MODIFY ("NOMPRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."PRODUCTO" MODIFY ("IDPRODUCTO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "LUIS"."CLIENTE" ADD CONSTRAINT "U_TELEFONOCLIENTE" UNIQUE ("TELEFONOCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."CLIENTE" ADD CONSTRAINT "U_CORREOCLIENTE" UNIQUE ("CORREOCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."CLIENTE" ADD CONSTRAINT "CK_SEXO" CHECK (sexocliente = 'M' or sexocliente = 'F') ENABLE;
  ALTER TABLE "LUIS"."CLIENTE" ADD CONSTRAINT "PK_CLIENTE" PRIMARY KEY ("IDCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("SEXOCLIENTE" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("DIRECCIONCLIENTE" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("APMATERNO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("APPATERNO" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("NOMBRECLIENTE" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."CLIENTE" MODIFY ("IDCLIENTE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ALMACEN
--------------------------------------------------------

  ALTER TABLE "LUIS"."ALMACEN" ADD CONSTRAINT "PK_ALMACEN" PRIMARY KEY ("IDALMACEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."ALMACEN" MODIFY ("IDALMACEN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table VENDEDOR
--------------------------------------------------------

  ALTER TABLE "LUIS"."VENDEDOR" ADD CONSTRAINT "U_CORREOVENDEDOR" UNIQUE ("CORREOVENDEDOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."VENDEDOR" ADD CONSTRAINT "CK_SEXOVENDEDOR" CHECK (sexovendedor = 'M' or sexovendedor = 'F') ENABLE;
  ALTER TABLE "LUIS"."VENDEDOR" ADD CONSTRAINT "PK_VENDEDOR" PRIMARY KEY ("IDVENDEDOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("SUELDOVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("FECHAINGRESOVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("SEXOVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("FECHANACVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("APMATERNOVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("APPATERNOVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("NOMVENDEDOR" NOT NULL ENABLE);
  ALTER TABLE "LUIS"."VENDEDOR" MODIFY ("IDVENDEDOR" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CABFACTURA
--------------------------------------------------------

  ALTER TABLE "LUIS"."CABFACTURA" ADD CONSTRAINT "FK_CABFACTURA_CLIENTE" FOREIGN KEY ("IDCLIENTE")
	  REFERENCES "LUIS"."CLIENTE" ("IDCLIENTE") ENABLE;
  ALTER TABLE "LUIS"."CABFACTURA" ADD CONSTRAINT "FK_CABFACTURA_VENDEDOR" FOREIGN KEY ("IDVENDEDOR")
	  REFERENCES "LUIS"."VENDEDOR" ("IDVENDEDOR") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DETALLEFACTURA
--------------------------------------------------------

  ALTER TABLE "LUIS"."DETALLEFACTURA" ADD CONSTRAINT "FK_DETALLEFACTURA_CABFACTURA" FOREIGN KEY ("IDCABFACTURA")
	  REFERENCES "LUIS"."CABFACTURA" ("IDCABFACTURA") ENABLE;
  ALTER TABLE "LUIS"."DETALLEFACTURA" ADD CONSTRAINT "FK_DETALLEFACTURA_PRODUCTO" FOREIGN KEY ("IDPRODUCTO")
	  REFERENCES "LUIS"."PRODUCTO" ("IDPRODUCTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GUARDA
--------------------------------------------------------

  ALTER TABLE "LUIS"."GUARDA" ADD CONSTRAINT "FK_GUARDA_ALMACEN" FOREIGN KEY ("IDALMACEN")
	  REFERENCES "LUIS"."ALMACEN" ("IDALMACEN") ENABLE;
  ALTER TABLE "LUIS"."GUARDA" ADD CONSTRAINT "FK_GUARDA_PRODUCTO" FOREIGN KEY ("IDPRODUCTO")
	  REFERENCES "LUIS"."PRODUCTO" ("IDPRODUCTO") ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRALMACEN
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRALMACEN" 
after insert or delete or update on almacen

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'almacen', SYSDATE);
    dbms_output.put_line( 'Se modifico almacen' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRALMACEN" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRCABFACTURA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRCABFACTURA" 
after insert or delete or update on cabfactura

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'cabfactura', SYSDATE);
    dbms_output.put_line( 'Se modifico cabfactura' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRCABFACTURA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRCLIENTE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRCLIENTE" 
after insert or delete or update on cliente

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'cliente', SYSDATE);
    dbms_output.put_line( 'Se modifico cliente' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRCLIENTE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRDETALLEFACTURA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRDETALLEFACTURA" 
after insert or delete or update on detallefactura

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'detallefactura', SYSDATE);
    dbms_output.put_line( 'Se modifico detallefactura' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRDETALLEFACTURA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRGUARDA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRGUARDA" 
after insert or delete or update on guarda

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'guarda', SYSDATE);
    dbms_output.put_line( 'Se modifico guarda' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRGUARDA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRPRODUCTO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRPRODUCTO" 
after insert or delete or update on producto

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'producto', SYSDATE);
    dbms_output.put_line( 'Se modifico producto' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRPRODUCTO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRVENDEDOR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LUIS"."TRVENDEDOR" 
after insert or delete or update on vendedor

begin
  if inserting or deleting or updating then
    insert into logs (usuario, tabla_modificada, fecha_mod) values (user, 'vendedor', SYSDATE);
    dbms_output.put_line( 'Se modifico vendedor' );
  end if;
end ;
/
ALTER TRIGGER "LUIS"."TRVENDEDOR" ENABLE;
--------------------------------------------------------
--  DDL for Procedure ALMACEN_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."ALMACEN_INS" (a CHAR, b varchar2)
is

BEGIN
    insert into almacen (idalmacen, descripcionalmacen) values (a, b);
    dbms_output.put_line ('Se inserto correctamente en almacen');
    
END;

/
--------------------------------------------------------
--  DDL for Procedure CABFACTURA_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."CABFACTURA_INS" (a char, b char, c char,
d varchar2)
is 

BEGIN
  insert into cabfactura (idcabfactura, idcliente, idvendedor)
  values (a, b, c);
  
  dbms_output.put_line ('Se inserto correctamente en cabfactura');
END;

/
--------------------------------------------------------
--  DDL for Procedure CLIENTE_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."CLIENTE_INS" (a char, b varchar2, c varchar2,
d varchar2, e varchar2, f varchar2, g number, h char)

is

BEGIN
insert into cliente (idcliente, nombrecliente, appaterno, 
apmaterno, direccioncliente, correocliente, telefonocliente, sexocliente)
values
(a, b, c, d, e, f, g, h);
dbms_output.put_line ('Se inserto correctamente en cliente');

END;

/
--------------------------------------------------------
--  DDL for Procedure DETALLEFACTURA_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."DETALLEFACTURA_INS" (a char, b char, c char, d number)

is
e date := SYSDATE;

BEGIN

insert into detallefactura (iddetallefact, idcabfactura, idproducto, cantidadproducto,
fechaventa) values (a, b, c, d, e);
dbms_output.put_line ('Se inserto correctamente en detallefactura');

END;

/
--------------------------------------------------------
--  DDL for Procedure GUARDA_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."GUARDA_INS" (a char, b char, c char)

is
BEGIN

insert into guarda (idguarda, idproducto, idalmacen) values (a, b, c);
dbms_output.put_line ('Se inserto correctamente en guarda');
end;

/
--------------------------------------------------------
--  DDL for Procedure PCLIENTESCOMPRAS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PCLIENTESCOMPRAS" 
is
  cursor c_compras is select * from clientes_mas_compras;
  dat clientes_mas_compras%rowtype;
begin 
  open c_compras;
  loop
    fetch c_compras into dat;
    exit when c_compras%notfound;
    dbms_output.put_line(dat.idcliente || ' - ' ||
    dat.numero_compras || ' - '|| dat.appaterno || ' - '
    || dat.apmaterno || ' - ' || dat.nombrecliente);
  end loop;
  close c_compras;
end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARAMVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARAMVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set apmaternovendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARAPMATERNO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARAPMATERNO" (idc char, val varchar2)
  is
  Begin
  update cliente
  set apmaterno = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARAPPATERNO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARAPPATERNO" (idc char, val varchar2)
  is
  Begin
  update cliente
  set appaterno = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARAPVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARAPVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set APPATERNOVENDEDOR = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARCANTIDADPROD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARCANTIDADPROD" (idc char, val char)
  is
  Begin
  update detallefactura
  set CANTIDADPRODUCTO = val
  where iddetallefact = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARCORREOCLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARCORREOCLIENTE" (idc char, val varchar2)
  is
  Begin
  update cliente
  set correocliente = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARCORREOVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARCORREOVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set correovendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARDESCALMACEN
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARDESCALMACEN" (idc char, val varchar2)
  is
  Begin
  update almacen
  set descripcionalmacen = val
  where idalmacen = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARDESCRIPPRODUCTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARDESCRIPPRODUCTO" (idc char, val varchar2)
  is
  Begin
  update producto
  set descripcionproducto = val
  where idproducto = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARDIRECCIONCLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARDIRECCIONCLIENTE" (idc char, val varchar2)
  is
  Begin
  update cliente
  set direccioncliente = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARDIRVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARDIRVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set direccionvendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARFECHAFACTURA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARFECHAFACTURA" (idc char, val varchar2)
  is
  Begin
  update detallefactura
  set fechaventa = TO_DATE (val || ' 00:00:00', 'dd/mm/yyyy hh24:mi:ss' )
  where iddetallefact = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARFIVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARFIVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set fechaingresovendedor = TO_DATE (val || ' 00:00:00', 'dd/mm/yyyy hh24:mi:ss' )
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARFNVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARFNVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set fechanacvendedor = TO_DATE (val || ' 00:00:00', 'dd/mm/yyyy hh24:mi:ss' )
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARIDALMACENG
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARIDALMACENG" (idc char, val char)
  is
  Begin
  update guarda
  set idalmacen = val
  where idguarda = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARIDCABFACTDETFACT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARIDCABFACTDETFACT" (idc char, val char)
  is
  Begin
  update detallefactura
  set idcabfactura = val
  where iddetallefact = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARIDCLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARIDCLIENTE" (idc char, val char)
  is
  Begin
  update cabfactura
  set cabfactura.IDCLIENTE = val
  where idcabfactura = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARIDPRODUCTOG
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARIDPRODUCTOG" (idc char, val char)
  is
  Begin
  update guarda
  set idproducto = val
  where idguarda = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARIDVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARIDVENDEDOR" (idc char, val char)
  is
  Begin
  update cabfactura
  set idvendedor = val 
  where idcabfactura = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARNOMBRECLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARNOMBRECLIENTE" (idc char, val varchar2)
  is
  Begin
  update cliente
  set nombrecliente = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARNOMPRODUCTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARNOMPRODUCTO" (idc char, val varchar2)
  is
  Begin
  update producto
  set nomproducto = val
  where idproducto = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARNOMVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARNOMVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set nomvendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARPRECIOPRODUCTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARPRECIOPRODUCTO" (idc char, val float)
  is
  Begin
  update producto
  set precioproducto = val
  where idproducto = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARPRODUCTODF
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARPRODUCTODF" (idc char, val char)
  is
  Begin
  update detallefactura
  set idproducto = val
  where iddetallefact = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARSEXOCLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARSEXOCLIENTE" (idc char, val char)
  is
  Begin
  update cliente
  set sexocliente = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARSEXOVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARSEXOVENDEDOR" (idc char, val varchar2)
  is
  Begin
  update vendedor
  set sexovendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARSUELDOVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARSUELDOVENDEDOR" (idc char, val number)
  is
  Begin
  update vendedor
  set sueldovendedor = val
  where idvendedor = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRACTUALIZARTELEFONOCLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRACTUALIZARTELEFONOCLIENTE" (idc char, val number)
  is
  Begin
  update cliente
  set telefonocliente = val
  where idcliente = idc;
  dbms_output.put_line ('Se actualizo correctamente el registro');
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARALMACEN
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARALMACEN" (idc char)
  is
  Begin
  delete from almacen where idalmacen = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARCABFACT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARCABFACT" (idc char)
  is
  Begin
  delete from cabfactura where idcabfactura = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARDETFACT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARDETFACT" (idc char)
  is
  Begin
  delete from detallefactura where iddetallefact = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARGUARDA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARGUARDA" (idc char)
  is
  Begin
  delete from guarda where idguarda = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARPRODUCTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARPRODUCTO" (idc char)
  is
  Begin
  delete from producto where idproducto = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRELIMINARVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRELIMINARVENDEDOR" (idc char)
  is
  Begin
  delete from vendedor where idvendedor = idc;
  dbms_output.put_line ('Se elimino correctamente el registro');
  
  end;

/
--------------------------------------------------------
--  DDL for Procedure PRMODIFICACION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRMODIFICACION" (s char )
is

BEGIN
    dbms_output.put_line('Se agrego modificaciones a la tabla log, modificado en: '||s );
END;

/
--------------------------------------------------------
--  DDL for Procedure PRODUCTO_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRODUCTO_INS" (a char, b varchar2, c float, d varchar2, e varchar2, f number)

is
BEGIN

insert into producto (idproducto, nomproducto, precioproducto, descripcionproducto, imagen, existencia)
values (a, b, c, d, e, f);
dbms_output.put_line ('Se inserto correctamente en producto');

end;

/
--------------------------------------------------------
--  DDL for Procedure PRPRODUCTOMASVENDIDO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PRPRODUCTOMASVENDIDO" 
is
  cursor c_ventas is select * from ProductoMasVendidos;
  dat ProductoMasVendidos%rowtype;
begin 
  open c_ventas;
  loop
    fetch c_ventas into dat;
    exit when c_ventas%notfound;
    dbms_output.put_line(dat.idproducto || ' - ' ||
    dat.nomproducto || ' - '|| dat.vendidos);
  end loop;
  close c_ventas;
end;

/
--------------------------------------------------------
--  DDL for Procedure PVENDEDORESVENTAS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."PVENDEDORESVENTAS" 
is
  cursor c_ventas is select * from VENDEDORES_MAS_VENTAS;
  dat VENDEDORES_MAS_VENTAS%rowtype;
begin 
  open c_ventas;
  loop
    fetch c_ventas into dat;
    exit when c_ventas%notfound;
    dbms_output.put_line(dat.idvendedor || ' - ' ||
    dat.numero_ventas || ' - '|| dat.appaternovendedor || ' - '
    || dat.apmaternovendedor || ' - ' || dat.nomvendedor);
  end loop;
  close c_ventas;
end;

/
--------------------------------------------------------
--  DDL for Procedure VENDEDOR_INS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "LUIS"."VENDEDOR_INS" (a char,  b varchar2, c varchar2, d varchar2 , e varchar2,
f varchar2, g varchar2, h varchar2, j number)

is

e1 date := TO_DATE (e || ' 00:00:00', 'dd/mm/yyyy hh24:mi:ss' );
i date := SYSDATE;

BEGIN

insert into vendedor (idvendedor, nomvendedor, appaternovendedor, apmaternovendedor,
fechanacvendedor, correovendedor, direccionvendedor, sexovendedor,
fechaingresovendedor, sueldovendedor) values
(a, b, c, d, e1, f, g, h, i, j);

dbms_output.put_line ('Se inserto correctamente en vendedor');

end;

/
