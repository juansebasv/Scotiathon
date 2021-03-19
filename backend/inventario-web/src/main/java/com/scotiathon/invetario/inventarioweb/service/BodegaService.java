package com.scotiathon.invetario.inventarioweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scotiathon.invetario.inventarioweb.dto.BodegaDto;
import com.scotiathon.invetario.inventarioweb.model.Bodega;
import com.scotiathon.invetario.inventarioweb.repository.BodegaRepository;

@Service
public class BodegaService {

	private BodegaRepository bodegaRepository;

	public BodegaService(BodegaRepository bodegaRepository) {
		this.bodegaRepository = bodegaRepository;
	}

	public List<BodegaDto> findAllBodega() throws Exception {
		Iterable<Bodega> bodegaDB = bodegaRepository.findAll();
		List<BodegaDto> lista = new ArrayList<>();

		bodegaDB.forEach(m -> {
			BodegaDto bodega = BodegaDto.builder().id(m.getId()).nombre(m.getNombre()).edificio(m.getEdificio())
					.piso(m.getPiso()).build();
			lista.add(bodega);
		});

		return lista;
	}
}
