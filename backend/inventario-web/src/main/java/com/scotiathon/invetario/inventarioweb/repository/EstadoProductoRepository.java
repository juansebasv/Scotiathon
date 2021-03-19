package com.scotiathon.invetario.inventarioweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.EstadoProducto;

@Repository
public interface EstadoProductoRepository extends CrudRepository<EstadoProducto, Integer> {

}
