package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.BodegaDto;
import com.scotiathon.invetario.inventarioweb.dto.CategoriaDto;
import com.scotiathon.invetario.inventarioweb.dto.CentroCostoDto;
import com.scotiathon.invetario.inventarioweb.dto.EstadoProductoDto;
import com.scotiathon.invetario.inventarioweb.dto.MarcaDto;
import com.scotiathon.invetario.inventarioweb.dto.ProductoDto;
import com.scotiathon.invetario.inventarioweb.model.Bodega;
import com.scotiathon.invetario.inventarioweb.model.Categoria;
import com.scotiathon.invetario.inventarioweb.model.CentroCosto;
import com.scotiathon.invetario.inventarioweb.model.EstadoProducto;
import com.scotiathon.invetario.inventarioweb.model.Marca;
import com.scotiathon.invetario.inventarioweb.model.OrdenCompra;
import com.scotiathon.invetario.inventarioweb.model.Producto;
import com.scotiathon.invetario.inventarioweb.repository.OrdenCompraRepository;
import com.scotiathon.invetario.inventarioweb.repository.ProductoRepository;

@Service
public class ProductoService {

	private ProductoRepository productoRepository;
	private OrdenCompraRepository ordenCompraRepository;

	public ProductoService(ProductoRepository productoRepository, OrdenCompraRepository ordenCompraRepository) {
		this.productoRepository = productoRepository;
		this.ordenCompraRepository = ordenCompraRepository;
	}

	public void saveProducto(ProductoDto producto, String codigoOrdenCompra) {

		OrdenCompra orden = ordenCompraRepository.findByCodigo(codigoOrdenCompra);

		Producto p = Producto.builder().bodega(generateBodega(producto.getBodega()))
				.categoria(generarCategoria(producto.getCategoria()))
				.centroCosto(generarCentroCosto(producto.getCentroCosto()))
				.estadoProducto(generarEstadoProducto(producto.getEstadoProducto()))
				.marca(generarMarca(producto.getMarca())).ordenCompra(orden).serial(producto.getSerial())
				.serialGbs(producto.getSerialGbs()).build();

		productoRepository.save(p);
	}

	private Bodega generateBodega(BodegaDto dto) {
		return Bodega.builder().id(dto.getId()).build();
	}

	private Categoria generarCategoria(CategoriaDto dto) {
		return Categoria.builder().id(dto.getId()).build();
	}

	public CentroCosto generarCentroCosto(CentroCostoDto dto) {
		return CentroCosto.builder().id(dto.getId()).build();
	}

	public EstadoProducto generarEstadoProducto(EstadoProductoDto estado) {
		return EstadoProducto.builder().id(estado.getId()).build();
	}

	public Marca generarMarca(MarcaDto dto) {
		return Marca.builder().id(dto.getId()).build();
	}

	public List<ProductoDto> findAll() {
		Iterable<Producto> productosDB = productoRepository.findAll();
		List<ProductoDto> productos = new ArrayList<>();
		productosDB.forEach(p -> {

			OrdenCompra orden = ordenCompraRepository.findByCodigo(p.getOrdenCompra().getCodigo());

			ProductoDto producto = ProductoDto.builder().bodega(generateBodegaDto(p.getBodega()))
					.categoria(generarCategoriaDto(p.getCategoria()))
					.centroCosto(generarCentroCostoDto(p.getCentroCosto()))
					.estadoProducto(generarEstadoProductoDto(p.getEstadoProducto()))
					.marca(generarMarcaDto(p.getMarca())).serial(p.getSerial()).serialGbs(p.getSerialGbs()).build();
			productos.add(producto);
		});
		return productos;
	}

	private BodegaDto generateBodegaDto(Bodega dto) {
		return BodegaDto.builder().id(dto.getId()).build();
	}

	private CategoriaDto generarCategoriaDto(Categoria dto) {
		return CategoriaDto.builder().id(dto.getId()).build();
	}

	public CentroCostoDto generarCentroCostoDto(CentroCosto dto) {
		return CentroCostoDto.builder().id(dto.getId()).build();
	}

	public EstadoProductoDto generarEstadoProductoDto(EstadoProducto estado) {
		return EstadoProductoDto.builder().id(estado.getId()).build();
	}

	public MarcaDto generarMarcaDto(Marca dto) {
		return MarcaDto.builder().id(dto.getId()).build();
	}
}
