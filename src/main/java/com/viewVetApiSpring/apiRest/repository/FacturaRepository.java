package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Factura;

@Repository("facturaRepository")

public interface FacturaRepository extends JpaRepository<Factura, Serializable>{
	public Factura findByIdfactura(int id);
}
