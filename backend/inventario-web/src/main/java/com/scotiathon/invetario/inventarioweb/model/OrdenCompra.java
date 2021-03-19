package com.scotiathon.invetario.inventarioweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDEN_COMPRA")
public class OrdenCompra implements Serializable {

	private static final long serialVersionUID = 5105132784806667243L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String codigo;

	@Column(name = "FECHA_SOLIITUD")
	private Date fechaSolicitud;

	@Column(name = "FECHA_ORDEN")
	private Date fechaOrden;

	private String proveedor;

	private String solicitante;

	private String descripcion;

	private BigDecimal costo;

	private String moneda;

	private String factura;

}
