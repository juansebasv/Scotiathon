package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.MarcaDto;
import com.scotiathon.invetario.inventarioweb.model.Categoria;
import com.scotiathon.invetario.inventarioweb.model.Marca;
import com.scotiathon.invetario.inventarioweb.repository.MarcaRepository;

@Service
public class MarcaService {

	private MarcaRepository marcaRepository;

	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	public List<MarcaDto> findAllMarca() throws Exception {
		Iterable<Marca> marcasDB = marcaRepository.findAll();
		List<MarcaDto> lista = new ArrayList<>();

		marcasDB.forEach(m -> {
			MarcaDto marca = MarcaDto.builder().id(m.getId()).marca(m.getMarca()).modelo(m.getModelo()).build();
			lista.add(marca);
		});

		return lista;
	}

	public List<String> findAllMarcaByCategoria(int categoriaid) throws Exception {
		Categoria aux = Categoria.builder().id(categoriaid).build();
		Iterable<String> marcasDB = marcaRepository.findByCategoria(aux);
		List<String> lista = new ArrayList<>();

		marcasDB.forEach(lista::add);

		return lista;
	}

	public List<MarcaDto> findAllMarcaByCategoriaAndMarca(int categoriaid, String marca) throws Exception {
		Categoria aux = Categoria.builder().id(categoriaid).build();
		Iterable<Marca> marcasDB = marcaRepository.findByCategoriaAndMarca(aux, marca);
		List<MarcaDto> lista = new ArrayList<>();

		marcasDB.forEach(m -> {
			MarcaDto marcaAux = MarcaDto.builder().id(m.getId()).marca(m.getMarca()).modelo(m.getModelo()).build();
			lista.add(marcaAux);
		});

		return lista;
	}

}
