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
@Table(name = "CENTRO_COSTO")
public class CentroCosto implements Serializable {

	private static final long serialVersionUID = -1356913123461131667L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	private String codigo;

	@OneToOne
	@JoinColumn(name = "OPERACION_ID")
	private Operacion operacion;

}
