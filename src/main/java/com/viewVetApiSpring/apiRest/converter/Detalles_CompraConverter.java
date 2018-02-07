package com.viewVetApiSpring.apiRest.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.viewVetApiSpring.apiRest.entity.Detalles_Compra;
import com.viewVetApiSpring.apiRest.entity.PK;
import com.viewVetApiSpring.apiRest.modelo.Detalles_CompraModel;
import com.viewVetApiSpring.apiRest.repository.ArticuloRepository;
import com.viewVetApiSpring.apiRest.repository.FacturaRepository;
import com.viewVetApiSpring.apiRest.repository.PersonaRepository;

@Component("detallesConverter")
public class Detalles_CompraConverter {
	@Autowired
	@Qualifier("facturaRepository")
	private FacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("articuloRepository")
	private ArticuloRepository articuloRepository;
	
	public Detalles_Compra convertModeltoEntity(Detalles_CompraModel modl) {
		Detalles_Compra dc= new Detalles_Compra();
		dc.setId(new PK(facturaRepository.findByIdfactura(modl.getId_factura()), articuloRepository.findByIdarticulo(modl.getId_articulo())));
		dc.setPrecio_final(modl.getPrecio_final());
		dc.setDescuento(modl.getDescuento());
		dc.setIva(modl.getIva());
		return dc;
	}

}
