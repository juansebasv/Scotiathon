package com.scotiathon.invetario.inventarioweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.AsignacionProducto;

@Repository
public interface AsignacionProductoRepository extends CrudRepository<AsignacionProducto, Integer> {

}
