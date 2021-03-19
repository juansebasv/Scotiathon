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
public class HistoricoEstadoProductoDto implements Serializable {

	private ProductoDto producto;
	private Date fecha;
	private String descripcion;
	private EstadoProductoDto estadoProducto;
	private boolean activo;
}
