package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viewVetApiSpring.apiRest.entity.Rol;

@Repository("rolRepository")

public interface RolRepository extends JpaRepository<Rol, Serializable> {
	
	public abstract Rol findByIdrol(int id);

}
