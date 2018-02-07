package com.viewVetApiSpring.apiRest.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;
import com.viewVetApiSpring.apiRest.repository.RolRepository;

@Component("personaConverter")
public class PersonaConverter {

	@Autowired
	@Qualifier("rolRepository")
	private RolRepository rolRepository;

	public Persona convertePersonaModeltoEntity(PersonaModel model) {
		Persona p = new Persona();
		p.setid_usuario(model.getId_usuario());
		p.setNif(model.getNif());
		p.setNombre(model.getNombre());
		p.setDireccion(model.getDireccion());
		p.setTelefono(model.getTelefono());
		p.setEmail(model.getEmail());
		if (model.getEspecialidad() == null) {
			p.setEspecialidad("");
		} else {
			p.setEspecialidad(model.getEspecialidad());
		}
		if (model.getCuenta_bancaria() == null) {
			p.setCuenta_bancaria("");
		} else {
			p.setCuenta_bancaria(model.getCuenta_bancaria());

		}
		p.setPassword(model.getPassword());
		p.setEstado(model.isEstado());
		if (model.getImagen() == null) {
			p.setImagen("");
		} else {
			p.setImagen(model.getImagen());
		}
		p.setProveedor(model.isProveedor());
		p.setId_rol(rolRepository.findByIdrol(model.getId_rol()));
		return p;

	}
	
	public PersonaModel convertePersonaEntitytoModel(Persona entity) {
		PersonaModel p = new PersonaModel();
		p.setId_usuario(entity.getid_usuario());
		p.setNif(entity.getNif());
		p.setNombre(entity.getNombre());
		p.setDireccion(entity.getDireccion());
		p.setTelefono(entity.getTelefono());
		p.setEmail(entity.getEmail());
		if (entity.getEspecialidad() == null) {
			p.setEspecialidad("");
		} else {
			p.setEspecialidad(entity.getEspecialidad());
		}
		if (entity.getCuenta_bancaria() == null) {
			p.setCuenta_bancaria("");
		} else {
			p.setCuenta_bancaria(entity.getCuenta_bancaria());

		}
		p.setPassword(entity.getPassword());
		p.setEstado(entity.isEstado());
		if (entity.getImagen() == null) {
			p.setImagen("");
		} else {
			p.setImagen(entity.getImagen());
		}
		p.setProveedor(entity.isProveedor());
		p.setId_rol(entity.getId_rol());
		return p;

	}

	
}
