package com.scotiathon.invetario.inventarioweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scotiathon.invetario.inventarioweb.model.Categoria;
import com.scotiathon.invetario.inventarioweb.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {

	@Query("select distinct(marca) from Marca where categoria = ?1")
	public List<String> findByCategoria(Categoria categoria);

	public List<Marca> findByCategoriaAndMarca(Categoria categoria, String marca);

}
