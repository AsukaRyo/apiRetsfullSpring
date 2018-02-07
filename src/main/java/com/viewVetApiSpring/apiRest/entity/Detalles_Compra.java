package com.viewVetApiSpring.apiRest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "detalles_compra")
public class Detalles_Compra extends PK {

	@EmbeddedId
	public PK id;
		
	@Column(name="precio_final")
	public double precio_final;
	
	@Column(name="cantidad")
	public int cantidad;
	
	@Column(name="descuento")
	public double descuento;

	@Column(name="iva")
	public double iva;

	

	public Detalles_Compra() {
		super();
	}

	

	public Detalles_Compra(Factura id_factura, Articulo id_articulo, PK id, double precio_final, int cantidad,
			double descuento, double iva) {
		super(id_factura, id_articulo);
		this.id = id;
		this.precio_final = precio_final;
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.iva = iva;
	}

	


	public PK getId() {
		return id;
	}



	public void setId(PK id) {
		this.id = id;
	}



	public double getPrecio_final() {
		return precio_final;
	}

	public void setPrecio_final(double precio_final) {
		this.precio_final = precio_final;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	
	


}
