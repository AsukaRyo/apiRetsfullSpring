package com.viewVetApiSpring.apiRest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.viewVetApiSpring.apiRest.converter.ArticuloConverter;
import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.ArticuloModel;
import com.viewVetApiSpring.apiRest.modelo.PersonaModel;
import com.viewVetApiSpring.apiRest.modelo.Response;
import com.viewVetApiSpring.apiRest.repository.ArticuloRepository;
import com.viewVetApiSpring.apiRest.service.ArticuloService;


@RestController
@RequestMapping("/apiViewVet")
@CrossOrigin("*")
public class ArticuloController {
	
	@Autowired
	@Qualifier("articuloRepository")
	private ArticuloRepository articuloRepository;
	
	@Autowired
	@Qualifier("articuloService")
	private ArticuloService articuloService;
	
	@Autowired
	@Qualifier("articuloConverter")
	private ArticuloConverter converter;
	
	@GetMapping(value = "/articulos/{estado}")
	public List<ArticuloModel> getAllArticulos(@PathVariable("estado") boolean estado) throws JSONException, IOException {
		List<ArticuloModel> articulos= new ArrayList<ArticuloModel>();
		for(Articulo a:articuloRepository.findByTipoAndEstado("a", estado)) {
			articulos.add(converter.convertEntitytoModel(a));
		}
		return articulos;
	}
	
	@GetMapping(value = "/servicios/{estado}")
	public List<ArticuloModel> getAllServicios(@PathVariable("estado") boolean estado) throws JSONException, IOException {
		List<ArticuloModel> articulos= new ArrayList<ArticuloModel>();
		for(Articulo a:articuloRepository.findByTipoAndEstado("s", estado)) {
			articulos.add(converter.convertEntitytoModel(a));
		}
		return articulos;
	}
	
	@PostMapping(value = "/articulo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response addArticulo(@Valid @RequestBody ArticuloModel p) throws JSONException, IOException {
		Articulo articulo = articuloRepository.save(converter.convertModeltoEntity(p));
		HttpServletResponse response = null;
		if (articulo == null) {
			return new Response("fallo", "400") ;
		} else {
			
			return new Response("ok", "200") ;

		}
	}
	
	@PostMapping(value = "/darBajaArticulo/{id}")
	public void darBaja(@PathVariable("id") int id) throws JSONException, IOException {
		Articulo a= articuloRepository.findByIdarticulo(id);
		a.setEstado(false);
		articuloRepository.save(a);
		
		
	}
	
	@PostMapping(value = "/modificarArticulo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response modificarPersona(@Valid @RequestBody ArticuloModel p) throws JSONException, IOException {
		Articulo articulo = articuloRepository.save(converter.convertModeltoEntity(p));
		HttpServletResponse response = null;
		if (articulo == null) {
			return new Response("fallo", "400") ;
		} else {
			
			return new Response("ok", "200") ;

		}
	}

}
