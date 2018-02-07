package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewVetApiSpring.apiRest.entity.Articulo;

@Repository("articuloRepository")
public interface ArticuloRepository extends JpaRepository<Articulo, Serializable> {
	
	public Articulo findByIdarticulo(int id);
	
	public List<Articulo> findByTipoAndEstado(String tipo,boolean estado);

}
