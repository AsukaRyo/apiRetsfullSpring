package com.viewVetApiSpring.apiRest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewVetApiSpring.apiRest.converter.Detalles_CompraConverter;
import com.viewVetApiSpring.apiRest.converter.FacturaConverter;
import com.viewVetApiSpring.apiRest.entity.Articulo;
import com.viewVetApiSpring.apiRest.entity.Detalles_Compra;
import com.viewVetApiSpring.apiRest.entity.Factura;
import com.viewVetApiSpring.apiRest.entity.Rol;
import com.viewVetApiSpring.apiRest.modelo.ArticuloModel;
import com.viewVetApiSpring.apiRest.modelo.Detalles_CompraModel;
import com.viewVetApiSpring.apiRest.modelo.FacturaModel;
import com.viewVetApiSpring.apiRest.modelo.Response;
import com.viewVetApiSpring.apiRest.modelo.RolModel;
import com.viewVetApiSpring.apiRest.repository.ArticuloRepository;
import com.viewVetApiSpring.apiRest.repository.DetallesRepository;
import com.viewVetApiSpring.apiRest.repository.FacturaRepository;

@RestController
@RequestMapping("/apiViewVet")
@CrossOrigin("*")
public class FacturaController {

	@Autowired
	@Qualifier("facturaRepository")
	private FacturaRepository facturaRepository;

	@Autowired
	@Qualifier("detallesRepository")
	private DetallesRepository detallesRepository;

	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;

	@Autowired
	@Qualifier("detallesConverter")
	private Detalles_CompraConverter detallesConverter;

	@PostMapping(value = "/factura", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response addArticulo(@Valid @RequestBody FacturaModel f) throws JSONException, IOException {
		Factura factura = facturaRepository.save(facturaConverter.converterModeltoEntity(f));
		if (factura == null) {
			return new Response("fallo", "400");
		} else {

			return new Response("ok", "200");

		}
	}
	
	

	@PostMapping(value = "/asociarArticulos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response asociarArticulos(@Valid @RequestBody List<Detalles_CompraModel> listadcm)
			throws JSONException, IOException {
		for (Detalles_CompraModel dcm : listadcm) {
			Detalles_Compra detalles = detallesRepository.save(detallesConverter.convertModeltoEntity(dcm));
			if (detalles == null) {
				return new Response("fallo", "400");
			}

		}
		return new Response("ok", "200");

	}
	
	@GetMapping(value = "/lastFactura")
	public FacturaModel getUltimaFactura() {
		List<Factura> facturas = facturaRepository.findAll();
		int pos = (facturas.size() - 1);
		Factura factura = facturas.get(pos);
		FacturaModel facturaM = facturaConverter.converterEntitytoModel(factura);
		return facturaM;
	}

}
