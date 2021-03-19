package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.BodegaDto;
import com.scotiathon.invetario.inventarioweb.dto.CategoriaDto;
import com.scotiathon.invetario.inventarioweb.dto.CentroCostoDto;
import com.scotiathon.invetario.inventarioweb.dto.EstadoProductoDto;
import com.scotiathon.invetario.inventarioweb.dto.MarcaDto;
import com.scotiathon.invetario.inventarioweb.dto.OrdenCompraDto;
import com.scotiathon.invetario.inventarioweb.dto.Product;
import com.scotiathon.invetario.inventarioweb.dto.ProductoDto;
import com.scotiathon.invetario.inventarioweb.model.OrdenCompra;
import com.scotiathon.invetario.inventarioweb.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {

	private OrdenCompraRepository ordenCompraRepository;

	@PersistenceContext
	private EntityManager entity;

	public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
		this.ordenCompraRepository = ordenCompraRepository;
	}

	public OrdenCompraDto findByCodigo(String codigo) {
		OrdenCompra orden = ordenCompraRepository.findByCodigo(codigo);
		return OrdenCompraDto.builder().id(orden.getId()).build();
	}

	public List<OrdenCompraDto> findAllBuyOrder() throws Exception {
		Iterable<OrdenCompra> ordenCompraDB = ordenCompraRepository.findAll();
		List<OrdenCompraDto> lista = new ArrayList<>();

		ordenCompraDB.forEach(m -> {
			OrdenCompraDto ordenCompra = OrdenCompraDto.builder().id(m.getId()).codigo(m.getCodigo())
					.costo(m.getCosto()).descripcion(m.getDescripcion()).factura(m.getFactura())
					.fechaOrden(m.getFechaOrden()).fechaSolicitud(m.getFechaSolicitud()).moneda(m.getMoneda())
					.proveedor(m.getProveedor()).solicitante(m.getSolicitante()).build();
			lista.add(ordenCompra);
		});

		return lista;
	}

	public Product findBuyOrderByFilters(ProductoDto producto, String codigoOrdenCompra) throws Exception {
		StringBuilder query = new StringBuilder();
		query.append(
				"SELECT op.CODIGO, op.FACTURA, p.SERIAL_GBS, p.SERIAL_FABRICANTE, m.ID AS ID_MODELO, m.MARCA, m.MODELO, p.CATEGORIA_ID, cc.ID AS ID_CENCOSTO, cc.CODIGO AS COS_CENTER, ")
				.append("b.ID AS ID_BODEGA, b.NOMBRE, e.ID AS ID_ESTADO, e.DESCRIPCION, ca.ID AS ID_CATEGORIA, ca.DESCRIPCION AS DESCRIP ")
				.append("FROM PRODUCTO p INNER JOIN ORDEN_COMPRA op ON (p.ORDEN_COMPRA_ID = op.ID) INNER JOIN MARCA m ON (p.MARCA_ID = m.ID) INNER JOIN CENTRO_COSTO cc ON (p.CENTRO_COSTO_ID = cc.ID) ")
				.append("INNER JOIN BODEGA b ON (p.BODEGA_ID = b.ID) INNER JOIN ESTADO_PRODUCTO e ON (p.ESTADO_PRODUCTO_ID = e.ID) INNER JOIN CATEGORIA ca ON (p.CATEGORIA_ID = ca.ID) WHERE ");

		boolean ban = false;

		if (!producto.getSerial().isEmpty()) {
			query.append("p.SERIAL_FABRICANTE = '").append(producto.getSerial()).append("' ");
			ban = true;
		}

		if (!producto.getSerialGbs().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("p.SERIAL_GBS = '").append(producto.getSerialGbs()).append("' ");
			ban = true;
		}

		if (producto.getBodega() != null && !producto.getBodega().getNombre().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("b.NOMBRE = '").append(producto.getBodega().getNombre()).append("' ");
			ban = true;
		}

		if (producto.getCentroCosto() != null && producto.getCentroCosto().getCodigo() != null
				&& !producto.getCentroCosto().getCodigo().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("cc.CODIGO = '").append(producto.getCentroCosto().getCodigo()).append("' ");
			ban = true;
		}

		if (producto.getCategoria() != null && producto.getCategoria().getDescripcion() != null
				&& !producto.getCategoria().getDescripcion().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("ca.DESCRIPCION = '").append(producto.getCategoria().getDescripcion()).append("' ");
			ban = true;
		}

		if (producto.getMarca() != null && producto.getMarca().getMarca() != null
				&& !producto.getMarca().getMarca().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("m.MARCA = '").append(producto.getMarca().getMarca()).append("' ");
			ban = true;
		}

		if (producto.getMarca() != null && producto.getMarca().getModelo() != null
				&& !producto.getMarca().getModelo().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("m.MODELO = '").append(producto.getMarca().getModelo()).append("' ");
			ban = true;
		}

		if (producto.getOrdenCompra() != null && !producto.getOrdenCompra().getCodigo().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("op.CODIGO = '").append(producto.getOrdenCompra().getCodigo()).append("' ");
			ban = true;
		}

		if (producto.getOrdenCompra() != null && !producto.getOrdenCompra().getFactura().isEmpty()) {
			query.append((ban) ? " AND " : "");
			query.append("op.FACTURA = '").append(producto.getOrdenCompra().getFactura()).append("' ");
			ban = true;
		}

		List<Object[]> lista = entity.createNativeQuery(query.toString()).getResultList();
		Product answer = new Product();

		for (Object[] var : lista) {
			answer = Product.builder().buyOrder(String.valueOf(var[0])).billNumber(String.valueOf(var[1]))
					.serial(String.valueOf(var[2])).gbsSerial(String.valueOf(var[3])).brand(String.valueOf(var[5]))
					.model(generarMarcaDto(String.valueOf(var[4]), String.valueOf(var[5]), String.valueOf(var[6])))
					.costCenter(generarCentroCostoDto(String.valueOf(var[8]), String.valueOf(var[9])))
					.warehouse(generateBodegaDto(String.valueOf(var[10]), String.valueOf(var[11])))
					.state(generarEstadoProductoDto(String.valueOf(var[12]), String.valueOf(var[13])))
					.category(generarCategoriaDto(String.valueOf(var[14]), String.valueOf(var[15]))).build();
		}

		return answer;
	}

	public MarcaDto generarMarcaDto(String id, String marca, String modelo) {
		return MarcaDto.builder().id(Integer.parseInt(id)).marca(marca).modelo(modelo).build();
	}

	public CentroCostoDto generarCentroCostoDto(String id, String codigo) {
		return CentroCostoDto.builder().id(Integer.parseInt(id)).codigo(codigo).build();
	}

	private BodegaDto generateBodegaDto(String id, String nombre) {
		return BodegaDto.builder().id(Integer.parseInt(id)).nombre(nombre).build();
	}

	public EstadoProductoDto generarEstadoProductoDto(String id, String descripcion) {
		return EstadoProductoDto.builder().id(Integer.parseInt(id)).descripcion(descripcion).build();
	}

	private CategoriaDto generarCategoriaDto(String id, String descripcion) {
		return CategoriaDto.builder().id(Integer.parseInt(id)).descripcion(descripcion).build();
	}
}
