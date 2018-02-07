package com.viewVetApiSpring.apiRest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewVetApiSpring.apiRest.entity.Persona;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Serializable> {
	
	public Persona findByIdusuario(int id);
	
	public List<Persona> findByEstado(boolean estado);
	
	
}
