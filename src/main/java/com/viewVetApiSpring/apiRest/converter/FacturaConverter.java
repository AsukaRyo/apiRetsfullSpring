package com.viewVetApiSpring.apiRest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.viewVetApiSpring.apiRest.entity.Factura;
import com.viewVetApiSpring.apiRest.modelo.FacturaModel;
import com.viewVetApiSpring.apiRest.repository.FacturaRepository;
import com.viewVetApiSpring.apiRest.repository.PersonaRepository;

@Component("facturaConverter")

public class FacturaConverter {
	

	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository personaRepository;
	
	
	public Factura converterModeltoEntity(FacturaModel modl) {
		Factura f= new Factura();
		f.setId_factura(modl.getId_factura());
		f.setId_usuario(personaRepository.findByIdusuario(modl.getId_usuario()));
		f.setPrecio_total(modl.getPrecio_total());
		f.setFecha(modl.getFecha());
		return f;
	}
	
	public FacturaModel converterEntitytoModel(Factura fac) {
		FacturaModel f= new FacturaModel();
		f.setId_factura(fac.getId_factura());
		f.setId_usuario(fac.getId_usuario());
		f.setPrecio_total(fac.getPrecio_total());
		f.setFecha(fac.getFecha());
		return f;
	}
}
