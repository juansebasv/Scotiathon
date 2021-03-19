package com.scotiathon.invetario.inventarioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.service.GrupoCategoriaService;

@RestController
@RequestMapping("/api/grupoCategoria")
public class GrupoCategoriaController {

	@Autowired
	private GrupoCategoriaService service;
}
