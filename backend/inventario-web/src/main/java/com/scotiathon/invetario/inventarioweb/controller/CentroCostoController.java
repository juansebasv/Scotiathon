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

import com.scotiathon.invetario.inventarioweb.dto.CentroCostoDto;
import com.scotiathon.invetario.inventarioweb.service.CentroCostoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/centroCosto")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class CentroCostoController {

	@Autowired
	private CentroCostoService service;

	@GetMapping("/findCentroCosto")
	@ApiOperation(value = "Find cost centers by operation")
	public ResponseEntity<List<CentroCostoDto>> findCentrosByOperacion(
			@RequestParam(name = "operacionId") int operacionId) {
		try {
			List<CentroCostoDto> centros = service.findAllByOperacion(operacionId);
			if (centros.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(centros, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "Get all cost centers")
	public ResponseEntity<List<CentroCostoDto>> findAll() {
		try {
			List<CentroCostoDto> centros = service.findAll();
			if (centros.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(centros, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
