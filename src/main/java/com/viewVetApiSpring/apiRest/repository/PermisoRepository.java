package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewVetApiSpring.apiRest.entity.Permiso;


@Repository("permisoRepository")
public interface PermisoRepository extends JpaRepository<Permiso, Serializable> {
	
	
	public Permiso findByIdPermiso(int idPermiso);

}
