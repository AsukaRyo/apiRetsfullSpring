package com.viewVetApiSpring.apiRest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.viewVetApiSpring.apiRest.converter.PersonaConverter;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;
import com.viewVetApiSpring.apiRest.modelo.Response;
import com.viewVetApiSpring.apiRest.repository.PersonaRepository;
import com.viewVetApiSpring.apiRest.repository.RolRepository;
import com.viewVetApiSpring.apiRest.service.PersonaService;

@RestController
@RequestMapping("/apiViewVet")
@CrossOrigin("*")
public class PersonaController {

	/** The persona service. */
	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;

	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository personaRepository;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter converter;

	@Autowired
	@Qualifier("rolRepository")
	private RolRepository rolRepository;

	@GetMapping(value = "/clientes/{estado}")
	public List<PersonaModel> getAllClientes(@PathVariable("estado") boolean estado) {
		return personaService.findClientes(estado);
	}

	@GetMapping(value = "/usuario/{id}")
	public Persona getUsuario(@PathVariable("id") int id) {
		return personaRepository.findByIdusuario(id);
	}

	@GetMapping(value = "/veterinarios/{estado}")
	public List<PersonaModel> getAllVeterinarios(@PathVariable("estado") boolean estado) {
		return personaService.findVeterinarios(estado);
	}

	@GetMapping(value = "/proveedores/{estado}")
	public List<PersonaModel> getAllProveedores(@PathVariable("estado") boolean estado) {
		return personaService.findProveedores(estado);
	}

	@GetMapping(value = "/getTodosUsuarios")
	public List<PersonaModel> getAll() {

		return personaService.findAll(true);
	}
	
	@GetMapping(value = "/prueba")
	public Response prueba() {

		return new Response("ok", "200");
	}

	@PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response addPersona(@Valid @RequestBody PersonaModel p) throws JSONException, IOException {
		Persona persona = personaRepository.save(converter.convertePersonaModeltoEntity(p));
		HttpServletResponse response = null;
		if (persona == null) {
			return null;
		} else {

			return new Response("ok", "200");

		}
	}

	@PostMapping(value = "/darBaja/{id}")
	public Response darBaja(@PathVariable("id") int id) throws JSONException, IOException {
		Persona p = personaRepository.findByIdusuario(id);
		p.setEstado(false);
		Persona persona=personaRepository.save(p);
		if (persona == null) {
			return null;
		} else {

			return new Response("ok", "200");

		}

	}

	@PostMapping(value = "/modificarPersona", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response modificarPersona(@Valid @RequestBody PersonaModel p)
			throws JSONException, IOException {
		Persona persona = personaRepository.save(converter.convertePersonaModeltoEntity(p));
		HttpServletResponse response = null;
		if (persona == null) {
			return null;
		} else {

			return new Response("ok", "200");

		}
	}
}
