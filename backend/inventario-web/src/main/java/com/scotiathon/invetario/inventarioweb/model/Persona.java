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
@Table(name = "PERSONA")
public class Persona implements Serializable {

	private static final long serialVersionUID = 8682624457074441629L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String documento;

	private String nombre;

	private String apellido;

	private String cargo;

	@OneToOne
	@JoinColumn(name = "CENTRO_COSTO_ID")
	private CentroCosto centroCosto;

	private String edificio;

	private String piso;

	private String puesto;

	@Column(name = "DIRECCION_HOME_OFFICE")
	private String direccionHomeOffice;

	@Column(name = "TELEFONO_HOME_OFFICE")
	private String telefonoHomeOffice;

}
