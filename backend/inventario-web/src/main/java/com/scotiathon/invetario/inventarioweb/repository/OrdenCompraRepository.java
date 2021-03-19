package com.scotiathon.invetario.inventarioweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.OrdenCompra;

@Repository
public interface OrdenCompraRepository extends CrudRepository<OrdenCompra, Integer> {

	OrdenCompra findByCodigo(String codigo);
}
