package com.viewVetApiSpring.apiRest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewVetApiSpring.apiRest.entity.Permiso;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.entity.Rol;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;
import com.viewVetApiSpring.apiRest.modelo.Response;
import com.viewVetApiSpring.apiRest.modelo.RolModel;
import com.viewVetApiSpring.apiRest.repository.RolRepository;

@RestController
@RequestMapping("/apiViewVet")
@CrossOrigin("*")
public class RolController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	@Qualifier("rolRepository")
	private RolRepository rolRepository;

	@GetMapping(value = "/lastRol")
	public RolModel getUltimoRol() {
		List<Rol> roles = rolRepository.findAll();
		int pos = (roles.size() - 1);
		Rol rol = roles.get(pos);
		RolModel rolM = new RolModel(rol.idrol, rol.name);
		return rolM;
	}

	@GetMapping(value = "/getrol/{id}")
	public RolModel getRol(@PathVariable("id") int id) throws JSONException, IOException {
		Rol rol = rolRepository.findByIdrol(id);
		RolModel rolM = new RolModel(rol.idrol, rol.name);
		return rolM;
	}

	@GetMapping(value = "/roles")
	public List<RolModel> getRoles() throws JSONException, IOException {
		List<RolModel> rolesModel = new ArrayList<>();
		for (Rol r : rolRepository.findAll()) {
			RolModel rm = new RolModel(r.idrol, r.name);
			rolesModel.add(rm);
		}
		return rolesModel;
	}

	@GetMapping(value = "/permisosByRol/{id}")
	public Set<Permiso> getPermisosByRol(@PathVariable("id") int id) throws JSONException, IOException {
		Rol rol = rolRepository.findByIdrol(id);
		return rol.getPermisos();
	}

	@PostMapping(value = "/rol", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response addRol(@Valid @RequestBody Rol r) throws JSONException, IOException {
		Rol rol = rolRepository.save(r);
		if (rol == null) {
			return null;
		} else {

			return new Response("ok", "200");

		}

	}

	@PostMapping(value = "/rol_permiso2/{id}")
	public Response asociarPermisos(@PathVariable("id") int id) throws JSONException, IOException {
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("asociarPermisos");
		query.setParameter("idPermiso", id);
		query.execute();
		return new Response("ok", "200");

	}

}
