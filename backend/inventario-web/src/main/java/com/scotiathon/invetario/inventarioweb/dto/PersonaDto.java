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
public class PersonaDto implements Serializable {

	private int id;
	private String documento;
	private String nombre;
	private String apellido;
	private String cargo;
	private CentroCostoDto centroCosto;
	private String edificio;
	private String piso;
	private String puesto;
	private String direccionHomeOffice;
	private String telefonoHomeOffice;
}
