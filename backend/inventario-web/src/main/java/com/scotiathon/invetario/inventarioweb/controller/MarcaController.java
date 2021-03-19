package com.scotiathon.invetario.inventarioweb.controller;

import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.dto.MarcaDto;
import com.scotiathon.invetario.inventarioweb.service.MarcaService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class MarcaController {

	@Autowired
	private MarcaService service;

	@ApiOperation(value = "Find All Marcas.")
	@GetMapping("/findAll")
	public ResponseEntity<List<MarcaDto>> findAllMarca() {
		try {
			List<MarcaDto> lista = service.findAllMarca();

			if (lista.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Find Marcas by categoria id.")
	@GetMapping("/findByCategoria")
	public ResponseEntity<List<String>> findAllMarcaByCategoria(@RequestParam("categoriaid") int categoriaid) {
		try {
			List<String> lista = service.findAllMarcaByCategoria(categoriaid);

			if (lista.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Find Marcas by categoria id and marca.")
	@GetMapping("/find")
	public ResponseEntity<List<MarcaDto>> findAllMarcaByCategoriaAndMarca(@RequestParam("categoriaid") int categoriaid,
			@RequestParam("marca") String marca) {
		try {
			List<MarcaDto> lista = service.findAllMarcaByCategoriaAndMarca(categoriaid, marca);

			if (lista.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
