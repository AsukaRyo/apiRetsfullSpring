package com.viewVetApiSpring.apiRest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.viewVetApiSpring.apiRest.converter.ArticuloConverter;
import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.ArticuloModel;
import com.viewVetApiSpring.apiRest.repository.ArticuloRepository;
import com.viewVetApiSpring.apiRest.service.ArticuloService;

@Service("articuloService")

public class ArticuloServiceimpl implements ArticuloService {
	@Autowired
	@Qualifier("articuloRepository")
	private ArticuloRepository articuloRepository;
	
	@Autowired
	@Qualifier("articuloConverter")
	private ArticuloConverter converter;
	
	@Override
	public List<ArticuloModel> findArticulos(boolean estado) {
		List<ArticuloModel> listaArticulo = new ArrayList<ArticuloModel>();
		List<Articulo> listaArticu = articuloRepository.findAll();
		if (!listaArticu.isEmpty()) {
			for (Articulo a : listaArticu) {
				if (a.isEstado()==estado) {
					listaArticulo.add(converter.convertEntitytoModel(a));
				}
			}
		}
		return listaArticulo;
	}
}
