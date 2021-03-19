package com.scotiathon.invetario.inventarioweb.model;

import java.io.Serializable;

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
@Table(name = "UBICACION")
public class Ubicacion implements Serializable {

	private static final long serialVersionUID = -1419674896238436101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "CENTRO_COSTO_ID")
	private CentroCosto centroCosto;

	private String edificio;

	private String piso;

	private String descripcion;

}
