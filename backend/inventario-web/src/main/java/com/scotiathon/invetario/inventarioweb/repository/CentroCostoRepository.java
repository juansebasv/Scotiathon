package com.scotiathon.invetario.inventarioweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.CentroCosto;
import com.scotiathon.invetario.inventarioweb.model.Operacion;

@Repository
public interface CentroCostoRepository extends CrudRepository<CentroCosto, Integer> {

	List<CentroCosto> findByOperacion(Operacion operacion);

	CentroCosto findByCodigo(String codigo);

}
