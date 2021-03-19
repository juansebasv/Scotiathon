package com.scotiathon.invetario.inventarioweb.model;

import java.io.Serializable;
import java.util.Date;

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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HISTORICO_ESTADO_PRODUCTO")
public class HistoricoEstadoProducto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "PRODUCTO_ID")
	private Producto producto;

	private Date fecha;

	private String descripcion;

	@OneToOne
	@JoinColumn(name = "ESTADO_PRODUCTO_ID")
	private EstadoProducto estadoProducto;

	private boolean activo;

}
