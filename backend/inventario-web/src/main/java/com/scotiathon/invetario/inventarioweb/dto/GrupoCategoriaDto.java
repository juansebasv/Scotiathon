package com.scotiathon.invetario.inventarioweb.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoCategoriaDto implements Serializable {

	private int id;
	private String descripcion;
}
