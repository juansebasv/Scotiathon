INSERT INTO GRUPO_CATEGORIA( DESCRIPCION) VALUES ( 'Computadores'); 
INSERT INTO GRUPO_CATEGORIA( DESCRIPCION) VALUES ( 'Periféricos'); 
INSERT INTO GRUPO_CATEGORIA( DESCRIPCION) VALUES ( 'Telefonía'); 
INSERT INTO GRUPO_CATEGORIA( DESCRIPCION) VALUES ( 'Infraestructura'); 

INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Laptop', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Computadores'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Desktop', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Computadores'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Monitor', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Impresora', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Scanner', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Video Beam', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Docking Station', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('WebCam', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Speakers', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Periféricos'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('IP Phone', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Telefonía'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Headset', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Telefonía'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Gateway', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Telefonía'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Switch', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Infraestructura'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Router', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Infraestructura'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Servidor', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Infraestructura'));
INSERT INTO CATEGORIA(DESCRIPCION, GRUPO_CATEGORIA_ID) VALUES ('Firewall', (SELECT ID FROM GRUPO_CATEGORIA WHERE DESCRIPCION = 'Infraestructura'));

INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Lenovo', 'ThinkPad T490s', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Lenovo', 'ThinkPad T390s', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Desktop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Lenovo', 'ThinkVision T22i-10', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Monitor'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Dell', 'Inspiron 1440', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Dell', 'Latitude 1450', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Desktop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Acer', 'Aspire Nitro 7', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Acer', 'Swift 3', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Logitech', 'Surround 7.1 Speakers', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Speakers'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('HP', 'Omen 650', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('HP', 'InkTank Wireless 4450', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Impresora'));
INSERT INTO MARCA (MARCA, MODELO, CATEGORIA_ID) VALUES ('Cisco', 'Cisco RV 4000 Series', (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Switch'));

INSERT INTO OPERACION(DESCRIPCION) VALUES ('Taxes Scotia');
INSERT INTO OPERACION(DESCRIPCION) VALUES ('Innovation Centre');
INSERT INTO OPERACION(DESCRIPCION) VALUES ('ScotiaTech GBS');

INSERT INTO CENTRO_COSTO (DESCRIPCION, CODIGO, OPERACION_ID) VALUES ('General Finance ', '1002-011', (SELECT ID FROM OPERACION WHERE DESCRIPCION = 'Taxes Scotia'));
INSERT INTO CENTRO_COSTO (DESCRIPCION, CODIGO, OPERACION_ID) VALUES ('Taxes', '1002-041', (SELECT ID FROM OPERACION WHERE DESCRIPCION = 'Taxes Scotia'));
INSERT INTO CENTRO_COSTO (DESCRIPCION, CODIGO, OPERACION_ID) VALUES ('Innovation Centre', '1004-081', (SELECT ID FROM OPERACION WHERE DESCRIPCION = 'Innovation Centre'));

INSERT INTO ESTADO_PRODUCTO (DESCRIPCION) VALUES ('Activo');
INSERT INTO ESTADO_PRODUCTO (DESCRIPCION) VALUES ('Dañado');
INSERT INTO ESTADO_PRODUCTO (DESCRIPCION) VALUES ('En Reparación');
INSERT INTO ESTADO_PRODUCTO (DESCRIPCION) VALUES ('Dado de Baja');

INSERT INTO BODEGA (NOMBRE, EDIFICIO, PISO, ESTADO_BODEGA) VALUES ('Amazonas - B7', 'Amazonas', '-2', 1);
INSERT INTO BODEGA (NOMBRE, EDIFICIO, PISO, ESTADO_BODEGA) VALUES ('Caribe - B1', 'Caribe', '-1', 0);

INSERT INTO ORDEN_COMPRA (CODIGO, FECHA_SOLIITUD, FECHA_ORDEN, PROVEEDOR, SOLICITANTE, DESCRIPCION, COSTO, MONEDA, FACTURA) VALUES ('OC-001', '2020-05-27', '2020-06-27', 'CLA Direct', 'ScotiaGBS Colombia', 'Compra Switch Core Cisco',
 90000, 'USD', '12345');
INSERT INTO ORDEN_COMPRA (CODIGO, FECHA_SOLIITUD, FECHA_ORDEN, PROVEEDOR, SOLICITANTE, DESCRIPCION, COSTO, MONEDA, FACTURA) VALUES ('OC-002', '2020-05-27', '2020-06-27', 'Lenovo', 'ScotiaGBS Colombia', 'Aprovisionamiento Laptops', 23000000,
 'COP', '6789');

INSERT INTO PRODUCTO (ORDEN_COMPRA_ID, SERIAL_GBS, SERIAL_FABRICANTE, MARCA_ID, CATEGORIA_ID, CENTRO_COSTO_ID, BODEGA_ID, ESTADO_PRODUCTO_ID) VALUES ( (SELECT ID FROM ORDEN_COMPRA WHERE CODIGO = 'OC-001'), 'GBS-001', 'RV4-123455678',
 (SELECT ID FROM MARCA WHERE MODELO = 'Cisco RV 4000 Series'), (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Switch'), (SELECT ID FROM CENTRO_COSTO WHERE CODIGO = '1002-011'), (SELECT ID FROM BODEGA WHERE NOMBRE = 'Amazonas - B7'), (SELECT ID FROM ESTADO_PRODUCTO
 WHERE DESCRIPCION = 'Activo'));
INSERT INTO PRODUCTO (ORDEN_COMPRA_ID, SERIAL_GBS, SERIAL_FABRICANTE, MARCA_ID, CATEGORIA_ID, CENTRO_COSTO_ID, BODEGA_ID, ESTADO_PRODUCTO_ID) VALUES ( (SELECT ID FROM ORDEN_COMPRA WHERE CODIGO = 'OC-002'), 'GBS-002', '19JEPK', (SELECT ID FROM
 MARCA WHERE MODELO = 'ThinkPad T490s'), (SELECT ID FROM CATEGORIA WHERE DESCRIPCION = 'Laptop'), (SELECT ID FROM CENTRO_COSTO WHERE CODIGO = '1002-011'), (SELECT ID FROM BODEGA WHERE NOMBRE = 'Amazonas - B7'), (SELECT ID FROM ESTADO_PRODUCTO WHERE DESCRIPCION
 = 'Activo'));
 
