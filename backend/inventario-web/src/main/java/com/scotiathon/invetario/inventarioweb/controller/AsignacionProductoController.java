package com.scotiathon.invetario.inventarioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.service.AsignacionProductoService;

@RestController
@RequestMapping("/api/asignacionProducto")
public class AsignacionProductoController {

	@Autowired
	private AsignacionProductoService service;
}
