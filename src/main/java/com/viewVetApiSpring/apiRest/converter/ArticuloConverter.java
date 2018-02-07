package com.viewVetApiSpring.apiRest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.modelo.ArticuloModel;
import com.viewVetApiSpring.apiRest.repository.PersonaRepository;

@Component("articuloConverter")

public class ArticuloConverter {

	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository personaRepository;
	
	public Articulo convertModeltoEntity(ArticuloModel a) {
		Articulo ar= new Articulo();
		ar.setId_articulo(a.getId_articulo());
		if(a.getId_usuario()>0) {
		ar.setIdusuario(personaRepository.findByIdusuario(a.getId_usuario()));
		}
		ar.setNombre(a.getNombre());
		ar.setPrecio(a.getPrecio());
		ar.setIva(a.getIva());
		ar.setDescuento(a.getDescuento());
		ar.setCategoria(a.getCategoria());
		ar.setDuracion(a.getDuracion());
		ar.setConsulta(a.getConsulta());
		ar.setTipo(a.getTipo());
		ar.setCantidad(a.getCantidad());
		ar.setEstado(a.isEstado());
		return ar;
	}
	
	public ArticuloModel convertEntitytoModel(Articulo a) {
		ArticuloModel ar= new ArticuloModel();
		ar.setId_articulo(a.getId_articulo());
		if(a.getId_usuario()>0) {
		ar.setId_usuario(a.getId_usuario());
		}
		ar.setNombre(a.getNombre());
		ar.setPrecio(a.getPrecio());
		ar.setIva(a.getIva());
		ar.setDescuento(a.getDescuento());
		ar.setCategoria(a.getCategoria());
		ar.setDuracion(a.getDuracion());
		ar.setConsulta(a.getConsulta());
		ar.setTipo(a.getTipo());
		ar.setCantidad(a.getCantidad());
		ar.setEstado(a.isEstado());
		return ar;
	}
	
}
