package com.scotiathon.invetario.inventarioweb.service;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.repository.UbicacionRepository;

@Service
public class UbicacionService {

	private UbicacionRepository ubicacionRepository;

	public UbicacionService(UbicacionRepository ubicacionRepository) {
		this.ubicacionRepository = ubicacionRepository;
	}

}
