package com.scotiathon.invetario.inventarioweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiathon.invetario.inventarioweb.dto.OrdenCompraDto;
import com.scotiathon.invetario.inventarioweb.dto.Product;
import com.scotiathon.invetario.inventarioweb.dto.ProductoDto;
import com.scotiathon.invetario.inventarioweb.service.OrdenCompraService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/ordenCompras")
public class OrdenCompraController {

	@Autowired
	private OrdenCompraService service;

	@ApiOperation(value = "Service to find all buy orders")
	@GetMapping("/findAllOrders")
	public ResponseEntity<List<OrdenCompraDto>> findAllOrder() {
		try {
			List<OrdenCompraDto> orders = service.findAllBuyOrder();

			if (orders.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Service to find buy order by filters")
	@GetMapping("/findByFilters")
	public ResponseEntity<List<Product>> findBuyOrderByFilters(@RequestBody Product[] products) {
		try {
			List<Product> orders = new ArrayList<>();

			for (Product product : products) {
				ProductoDto producto = ProductoDto.builder().marca(product.getModel())
						.centroCosto(product.getCostCenter()).bodega(product.getWarehouse())
						.categoria(product.getCategory()).estadoProducto(product.getState()).serial(product.getSerial())
						.serialGbs(product.getGbsSerial()).build();
				orders.add(service.findBuyOrderByFilters(producto, product.getBuyOrder()));
			}

			if (orders.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
