package com.viewVetApiSpring.apiRest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue
	@Column(name = "id_factura")
	public int idfactura;
	
	@Column(name="precioTotal")
	public double precio_total;
	
	@Column(name="fecha")
	public String fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Persona id_usuario;
	
	@OneToMany(mappedBy = "id.id_factura", fetch = FetchType.EAGER)
	private Set<Detalles_Compra> detalle_compra = new HashSet<Detalles_Compra>();
	
	public Factura() {
		super();
	}

	public Factura(int id_factura, double precio_total, String fecha) {
		super();
		this.idfactura = id_factura;
		this.precio_total = precio_total;
		this.fecha = fecha;
	}

	public Factura(int id_factura, double precio_total, String fecha, Persona id_usuario) {
		super();
		this.idfactura = id_factura;
		this.precio_total = precio_total;
		this.fecha = fecha;
		this.id_usuario = id_usuario;
	}

	public int getId_factura() {
		return idfactura;
	}

	public void setId_factura(int id_factura) {
		this.idfactura = id_factura;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_usuario() {
		return id_usuario.getid_usuario();
	}

	public void setId_usuario(Persona id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Set<Detalles_Compra> getDetalle_compra() {
		return detalle_compra;
	}

	public void setDetalle_compra(Set<Detalles_Compra> detalle_compra) {
		this.detalle_compra = detalle_compra;
	}
	
	

	

}
