package com.viewVetApiSpring.apiRest.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_factura")
	public Factura id_factura;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_articulo")
	public Articulo id_articulo;

	public PK(Factura id_factura, Articulo id_articulo) {
		super();
		this.id_factura = id_factura;
		this.id_articulo = id_articulo;
	}

	public PK() {
		super();
	}

	public Factura getId_factura() {
		return id_factura;
	}

	public void setId_factura(Factura id_factura) {
		this.id_factura = id_factura;
	}

	public Articulo getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Articulo id_articulo) {
		this.id_articulo = id_articulo;
	}
	
	
}
