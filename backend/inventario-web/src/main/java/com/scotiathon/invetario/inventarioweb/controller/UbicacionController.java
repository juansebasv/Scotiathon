package com.scotiathon.invetario.inventarioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

	@Autowired
	private UbicacionService service;
}
