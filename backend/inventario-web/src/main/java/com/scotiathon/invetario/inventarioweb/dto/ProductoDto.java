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
public class ProductoDto implements Serializable {

	private int id;
	private OrdenCompraDto ordenCompra;
	private String serialGbs;
	private String serial;
	private MarcaDto marca;
	private CategoriaDto categoria;
	private CentroCostoDto centroCosto;
	private BodegaDto bodega;
	private EstadoProductoDto estadoProducto;

}
