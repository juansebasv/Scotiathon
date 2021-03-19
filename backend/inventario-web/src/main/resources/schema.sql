CREATE TABLE GRUPO_CATEGORIA(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(50) NOT NULL
);

CREATE TABLE CATEGORIA(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(100) NOT NULL,
	GRUPO_CATEGORIA_ID INT NOT NULL,
	FOREIGN KEY (GRUPO_CATEGORIA_ID) REFERENCES GRUPO_CATEGORIA(ID)
);

CREATE TABLE MARCA(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	MARCA VARCHAR(50) NOT NULL,
	MODELO VARCHAR(100) NOT NULL,
	CATEGORIA_ID INT NOT NULL,
	FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID)
);

CREATE TABLE OPERACION(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(100) NOT NULL
);

CREATE TABLE CENTRO_COSTO(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(100) NOT NULL,
	OPERACION_ID INT NOT NULL,
	CODIGO VARCHAR(50) NOT NULL,
	FOREIGN KEY (OPERACION_ID) REFERENCES OPERACION(ID)
);

CREATE TABLE ESTADO_PRODUCTO (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(50) NOT NULL
);

CREATE TABLE BODEGA (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NOMBRE VARCHAR(100) NOT NULL,
	EDIFICIO VARCHAR(20) NOT NULL,
	PISO VARCHAR(2) NOT NULL,
	ESTADO_BODEGA BOOL NOT NULL DEFAULT 1
);

CREATE TABLE ORDEN_COMPRA(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CODIGO VARCHAR(20) NOT NULL,
	FECHA_SOLIITUD DATE NOT NULL,
	FECHA_ORDEN DATE NOT NULL,
	PROVEEDOR VARCHAR(100) NOT NULL,
	SOLICITANTE VARCHAR(100) NOT NULL,
	DESCRIPCION TEXT NOT NULL,
	COSTO DECIMAL(15,3) NOT NULL,
	MONEDA VARCHAR(3) NOT NULL,
	FACTURA VARCHAR(20) NOT NULL
);

CREATE TABLE PRODUCTO (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ORDEN_COMPRA_ID INT NOT NULL,
	SERIAL_GBS VARCHAR(20) NOT NULL,
	SERIAL_FABRICANTE VARCHAR(50) NOT NULL,
	MARCA_ID INT NOT NULL,
	CATEGORIA_ID INT NOT NULL,
	CENTRO_COSTO_ID INT NOT NULL,
	BODEGA_ID INT NOT NULL,
	ESTADO_PRODUCTO_ID INT NOT NULL,
	FOREIGN KEY (ORDEN_COMPRA_ID) REFERENCES ORDEN_COMPRA(ID),
	FOREIGN KEY (MARCA_ID) REFERENCES MARCA(ID),
	FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID),
	FOREIGN KEY (CENTRO_COSTO_ID) REFERENCES CENTRO_COSTO(ID),
	FOREIGN KEY (BODEGA_ID) REFERENCES BODEGA(ID),
	FOREIGN KEY (ESTADO_PRODUCTO_ID) REFERENCES ESTADO_PRODUCTO(ID)
);

CREATE TABLE PERSONA(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DOCUMENTO VARCHAR(20) NOT NULL,
	NOMBRE VARCHAR(50) NOT NULL,
	APELLIDO VARCHAR(50) NOT NULL,
	CARGO VARCHAR(20) NOT NULL,
	CENTRO_COSTO_ID INT NOT NULL,
	EDIFICIO VARCHAR(20),
	PISO VARCHAR(1),
	PUESTO VARCHAR(5),
	DIRECCION_HOME_OFFICE VARCHAR(100),
	TELEFONO_HOME_OFFICE VARCHAR(10),
	FOREIGN KEY (CENTRO_COSTO_ID) REFERENCES CENTRO_COSTO(ID)
);

CREATE TABLE UBICACION(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CENTRO_COSTO_ID INT NOT NULL,
	EDIFICIO VARCHAR(20) NOT NULL,
	PISO VARCHAR(1) NOT NULL,
	DESCRIPCION VARCHAR(50) NOT NULL,
	FOREIGN KEY (CENTRO_COSTO_ID) REFERENCES CENTRO_COSTO(ID)
);

CREATE TABLE HISTORICO_ESTADO_PRODUCTO(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PRODUCTO_ID INT NOT NULL,
	FECHA DATE NOT NULL,
	DESCRIPCION TEXT NOT NULL,
	ESTADO_PRODUCTO_ID INT NOT NULL,
	ACTIVO BOOL NOT NULL DEFAULT 1,
	FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTO (ID),
	FOREIGN KEY (ESTADO_PRODUCTO_ID) REFERENCES ESTADO_PRODUCTO (ID)
);

CREATE TABLE ASIGNACION_PRODUCTO(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PRODUCTO_ID INT NOT NULL,
	PERSONA_ID INT,
	UBICACION_ID INT,
	FECHA DATE NOT NULL DEFAULT CURRENT_DATE,
	FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTO(ID),
	FOREIGN KEY (PERSONA_ID) REFERENCES  PERSONA(ID)
);
