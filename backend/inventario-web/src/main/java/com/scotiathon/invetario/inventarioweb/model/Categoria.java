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
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 8677047208306378979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@OneToOne
	@JoinColumn(name = "GRUPO_CATEGORIA_ID")
	private GrupoCategoria grupoCategoria;
}
