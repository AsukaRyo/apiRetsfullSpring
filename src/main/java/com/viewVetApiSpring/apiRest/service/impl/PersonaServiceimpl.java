package com.viewVetApiSpring.apiRest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.viewVetApiSpring.apiRest.converter.PersonaConverter;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;
import com.viewVetApiSpring.apiRest.repository.PersonaRepository;
import com.viewVetApiSpring.apiRest.service.PersonaService;

@Service("personaService")
public class PersonaServiceimpl implements PersonaService {

	@Autowired
	@Qualifier("personaRepository")
	PersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter converter;
	
	private static final Log LOG = LogFactory.getLog(PersonaServiceimpl.class);

	@Override
	public Persona addUsuario(Persona usuario) {
		return personaRepository.save(usuario);
	}

	@Override
	public List<PersonaModel> findClientes(boolean estado) {
		List<PersonaModel> listaClientes = new ArrayList<PersonaModel>();
		List<Persona> listaUsuario = personaRepository.findAll();
		if (!listaUsuario.isEmpty()) {
			for (Persona p : listaUsuario) {
				if (p.getEspecialidad().equalsIgnoreCase("")&&p.isEstado()==estado&&!p.isProveedor()) {
					
					listaClientes.add(converter.convertePersonaEntitytoModel(p));
				}
			}
		}
		return listaClientes;
	}

	@Override
	public List<PersonaModel> findVeterinarios(boolean estado) {
		List<PersonaModel> listaVeterinario = new ArrayList<PersonaModel>();
		List<Persona> listaUsuario = personaRepository.findAll();
		if (!listaUsuario.isEmpty()) {
			for (Persona p : listaUsuario) {
				if (!p.getEspecialidad().equalsIgnoreCase("")&&p.isEstado()==estado&&!p.isProveedor()) {
					listaVeterinario.add(converter.convertePersonaEntitytoModel(p));
				}
			}
		}
		return listaVeterinario;
	}

	@Override
	public List<PersonaModel> findProveedores(boolean estado) {
		List<PersonaModel> listaProveedores = new ArrayList<PersonaModel>();
		List<Persona> listaUsuario = personaRepository.findAll();
		if (!listaUsuario.isEmpty()) {
			for (Persona p : listaUsuario) {
				if (p.isProveedor()&&p.isEstado()==estado) {
					listaProveedores.add(converter.convertePersonaEntitytoModel(p));
				}
			}
		}
		return listaProveedores;
	}
	
	@Override
	public List<PersonaModel> findAll(boolean estado) {
		List<PersonaModel> listaUsuariosFinal = new ArrayList<PersonaModel>();
		List<Persona> listaUsuario = personaRepository.findAll();
		if (!listaUsuario.isEmpty()) {
			for (Persona p : listaUsuario) {
				if (p.isEstado()==estado) {
					listaUsuariosFinal.add(converter.convertePersonaEntitytoModel(p));
				}
			}
		}
		return listaUsuariosFinal;
	}

}
