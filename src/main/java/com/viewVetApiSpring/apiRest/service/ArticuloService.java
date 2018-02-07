package com.viewVetApiSpring.apiRest.service;

import java.util.List;

import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Persona;
import com.viewVetApiSpring.apiRest.modelo.ArticuloModel;

public interface ArticuloService {
	
	public abstract List<ArticuloModel> findArticulos(boolean estado);

}
