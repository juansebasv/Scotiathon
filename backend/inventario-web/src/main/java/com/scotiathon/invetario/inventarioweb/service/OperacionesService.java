package com.scotiathon.invetario.inventarioweb.service;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.repository.OperacionRepository;

@Service
public class OperacionesService {

	private OperacionRepository operacionesRepository;

	public OperacionesService(OperacionRepository operacionesRepository) {
		this.operacionesRepository = operacionesRepository;
	}

}
