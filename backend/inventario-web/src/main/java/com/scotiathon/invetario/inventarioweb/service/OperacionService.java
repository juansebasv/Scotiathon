package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.OperacionDto;
import com.scotiathon.invetario.inventarioweb.model.Operacion;
import com.scotiathon.invetario.inventarioweb.repository.OperacionRepository;

@Service
public class OperacionService {

	private OperacionRepository operacionRepository;

	public OperacionService(OperacionRepository operacionRepository) {
		this.operacionRepository = operacionRepository;
	}

	public List<OperacionDto> findAll() {
		Iterable<Operacion> operacionesModel = operacionRepository.findAll();
		List<OperacionDto> operaciones = new ArrayList<>();
		operacionesModel.forEach(op -> {
			OperacionDto operacion = OperacionDto.builder().id(op.getId()).descripcion(op.getDescripcion()).build();
			operaciones.add(operacion);
		});

		return operaciones;
	}
}
