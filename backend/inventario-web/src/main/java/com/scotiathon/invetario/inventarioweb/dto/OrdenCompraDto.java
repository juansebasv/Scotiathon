package com.scotiathon.invetario.inventarioweb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraDto implements Serializable {

	private int id;
	private String codigo;
	private Date fechaSolicitud;
	private Date fechaOrden;
	private String proveedor;
	private String solicitante;
	private String descripcion;
	private BigDecimal costo;
	private String moneda;
	private String factura;
}
