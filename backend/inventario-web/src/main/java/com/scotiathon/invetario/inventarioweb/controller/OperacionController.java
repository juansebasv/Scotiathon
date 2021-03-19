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
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.dto.OperacionDto;
import com.scotiathon.invetario.inventarioweb.service.OperacionService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/operaciones")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class OperacionController {

	@Autowired
	private OperacionService service;

	@ApiOperation(value = "Find all operations")
	@GetMapping("/findAll")
	public ResponseEntity<List<OperacionDto>> findAll() {
		try {
			List<OperacionDto> operaciones = service.findAll();
			if (operaciones.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(operaciones, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
