package com.scotiathon.invetario.inventarioweb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionProducto implements Serializable {

	private int id;
	private ProductoDto producto;
	private PersonaDto persona;
	private UbicacionDto ubicacion;
	private Date fecha;

}
