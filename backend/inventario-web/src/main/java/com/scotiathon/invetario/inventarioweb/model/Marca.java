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
@Table(name = "MARCA")
public class Marca implements Serializable {

	private static final long serialVersionUID = -3195222151897819655L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String marca;

	private String modelo;

	@OneToOne
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;

}
