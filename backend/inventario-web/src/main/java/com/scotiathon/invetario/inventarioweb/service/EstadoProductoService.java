package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.EstadoProductoDto;
import com.scotiathon.invetario.inventarioweb.model.EstadoProducto;
import com.scotiathon.invetario.inventarioweb.repository.EstadoProductoRepository;

@Service
public class EstadoProductoService {

	private EstadoProductoRepository estadoRepository;

	public EstadoProductoService(EstadoProductoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public List<EstadoProductoDto> findAllEstadoProducto() throws Exception {
		Iterable<EstadoProducto> estadoDB = estadoRepository.findAll();
		List<EstadoProductoDto> lista = new ArrayList<>();

		estadoDB.forEach(m -> {
			EstadoProductoDto estado = EstadoProductoDto.builder().id(m.getId()).descripcion(m.getDescripcion())
					.build();
			lista.add(estado);
		});

		return lista;
	}
}
