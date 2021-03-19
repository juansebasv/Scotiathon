package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.CategoriaDto;
import com.scotiathon.invetario.inventarioweb.model.Categoria;
import com.scotiathon.invetario.inventarioweb.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<CategoriaDto> findAllCategoria() throws Exception {
		Iterable<Categoria> categoriaDB = categoriaRepository.findAll();
		List<CategoriaDto> lista = new ArrayList<>();

		categoriaDB.forEach(m -> {
			CategoriaDto categoria = CategoriaDto.builder().id(m.getId()).descripcion(m.getDescripcion()).build();
			lista.add(categoria);
		});

		return lista;
	}
}
