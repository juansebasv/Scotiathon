package com.scotiathon.invetario.inventarioweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.Ubicacion;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Integer> {

}
