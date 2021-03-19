package com.scotiathon.invetario.inventarioweb.service;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.repository.AsignacionProductoRepository;

@Service
public class AsignacionProductoService {

	private AsignacionProductoRepository asignacionProductoRepository;

	public AsignacionProductoService(AsignacionProductoRepository asignacionProductoRepository) {
		this.asignacionProductoRepository = asignacionProductoRepository;
	}

}
