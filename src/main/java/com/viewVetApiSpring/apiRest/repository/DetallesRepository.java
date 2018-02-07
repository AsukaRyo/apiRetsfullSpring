package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Detalles_Compra;

@Repository("detallesRepository")
public interface DetallesRepository extends JpaRepository<Detalles_Compra, Serializable> {
	
	

}
