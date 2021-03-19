package com.scotiathon.invetario.inventarioweb.service;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.repository.PersonaRepository;

@Service
public class PersonaService {

	private PersonaRepository personaRepository;

	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

}
