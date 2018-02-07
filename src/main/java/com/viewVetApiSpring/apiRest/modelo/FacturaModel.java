package com.viewVetApiSpring.apiRest.modelo;

public class FacturaModel {
 
	public int id_factura;
	public int id_usuario;
	public String fecha;
	public double precio_total;
	public FacturaModel(int id_factura, int id_usuario, String fecha, double precio_total) {
		super();
		this.id_factura = id_factura;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
		this.precio_total = precio_total;
	}
	public FacturaModel() {
		super();
	}
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	
	
}
