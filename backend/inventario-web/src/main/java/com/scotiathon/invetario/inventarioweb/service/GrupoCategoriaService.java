package com.scotiathon.invetario.inventarioweb.service;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.repository.GrupoCategoriaRepository;

@Service
public class GrupoCategoriaService {

	private GrupoCategoriaRepository grupoCategoriaRepository;

	public GrupoCategoriaService(GrupoCategoriaRepository grupoCategoriaRepository) {
		this.grupoCategoriaRepository = grupoCategoriaRepository;
	}
}
