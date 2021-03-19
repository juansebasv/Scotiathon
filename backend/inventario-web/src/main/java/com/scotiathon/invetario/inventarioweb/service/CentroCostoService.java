package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.CentroCostoDto;
import com.scotiathon.invetario.inventarioweb.model.CentroCosto;
import com.scotiathon.invetario.inventarioweb.model.Operacion;
import com.scotiathon.invetario.inventarioweb.repository.CentroCostoRepository;

@Service
public class CentroCostoService {

	private CentroCostoRepository centroCostoRepository;

	public CentroCostoService(CentroCostoRepository centroCostoRepository) {
		this.centroCostoRepository = centroCostoRepository;
	}

	public List<CentroCostoDto> findAllByOperacion(int operacionId) {
		Operacion operacion = Operacion.builder().id(operacionId).build();
		Iterable<CentroCosto> centrosCosto = centroCostoRepository.findByOperacion(operacion);
		List<CentroCostoDto> centros = new ArrayList<>();
		centrosCosto.forEach(c -> {
			CentroCostoDto centro = CentroCostoDto.builder().id(c.getId()).descripcion(c.getDescripcion())
					.codigo(c.getCodigo()).build();
			centros.add(centro);
		});
		return centros;
	}

	public List<CentroCostoDto> findAll() {
		Iterable<CentroCosto> centrosCosto = centroCostoRepository.findAll();
		List<CentroCostoDto> centros = new ArrayList<>();
		centrosCosto.forEach(c -> {
			CentroCostoDto centro = CentroCostoDto.builder().id(c.getId()).descripcion(c.getDescripcion()).build();
			centros.add(centro);
		});
		return centros;
	}

	public CentroCostoDto findCentroCostoByCodigo(String codigo) {
		CentroCosto centroCosto = centroCostoRepository.findByCodigo(codigo);
		return CentroCostoDto.builder().id(centroCosto.getId()).descripcion(centroCosto.getDescripcion())
				.codigo(centroCosto.getCodigo()).build();
	}
}
