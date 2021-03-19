package com.scotiathon.invetario.inventarioweb.controller;

import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.dto.Product;
import com.scotiathon.invetario.inventarioweb.dto.ProductoDto;
import com.scotiathon.invetario.inventarioweb.service.ProductoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ProductoController {

	@Autowired
	private ProductoService service;

	@ApiOperation(value = "Service to persist a product")
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product[] products) {
		try {
			for (Product product : products) {
				ProductoDto producto = ProductoDto.builder().marca(product.getModel())
						.centroCosto(product.getCostCenter()).bodega(product.getWarehouse())
						.categoria(product.getCategory()).estadoProducto(product.getState()).serial(product.getSerial())
						.serialGbs(product.getGbsSerial()).build();
				service.saveProducto(producto, product.getBuyOrder());
			}
			return new ResponseEntity<>("OK", HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Service to persist a product")
	@GetMapping("/findAllProducts")
	public ResponseEntity<List<ProductoDto>> findAllProducts() {
		try {
			List<ProductoDto> productos = service.findAll();

			if (productos.isEmpty())
				return new ResponseEntity<List<ProductoDto>>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
