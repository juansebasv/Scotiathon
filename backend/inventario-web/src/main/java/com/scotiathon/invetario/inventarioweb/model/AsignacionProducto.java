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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASIGNACION_PRODUCTO")
public class AsignacionProducto implements Serializable {

	private static final long serialVersionUID = 9071909048735693515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "PRODUCTO_ID")
	private Producto producto;

	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;

	@OneToOne
	@JoinColumn(name = "UBICACION_ID")
	private Ubicacion ubicacion;

	private Date fecha;

}
