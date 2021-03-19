package com.scotiathon.invetario.inventarioweb.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private String buyOrder;
	private String billNumber;
	private String serial;
	private String gbsSerial;
	private String brand;
	private MarcaDto model;
	private OperacionDto operation;
	private CentroCostoDto costCenter;
	private BodegaDto warehouse;
	private EstadoProductoDto state;
	private CategoriaDto category;

}
