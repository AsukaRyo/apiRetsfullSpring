package com.viewVetApiSpring.apiRest.service;

import java.util.List;

import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;

public interface PersonaService {
	
	
	public abstract Persona addUsuario(Persona usuario);
	
	public abstract List<PersonaModel> findClientes(boolean estado);
	
	public abstract List<PersonaModel> findVeterinarios(boolean estado);
	
	public abstract List<PersonaModel> findProveedores(boolean estado);
	
	public abstract List<PersonaModel> findAll(boolean estado);

}
