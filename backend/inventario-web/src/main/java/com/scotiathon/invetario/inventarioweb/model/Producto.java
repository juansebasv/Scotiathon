package com.scotiathon.invetario.inventarioweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = -5549282641801429339L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "ORDEN_COMPRA_ID")
	private OrdenCompra ordenCompra;

	@Column(name = "SERIAL_GBS")
	private String serialGbs;

	@Column(name = "SERIAL_FABRICANTE")
	private String serial;

	@OneToOne
	@JoinColumn(name = "MARCA_ID")
	private Marca marca;

	@OneToOne
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "CENTRO_COSTO_ID")
	private CentroCosto centroCosto;

	@OneToOne
	@JoinColumn(name = "BODEGA_ID")
	private Bodega bodega;

	@OneToOne
	@JoinColumn(name = "ESTADO_PRODUCTO_ID")
	private EstadoProducto estadoProducto;

}
