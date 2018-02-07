package com.viewVetApiSpring.apiRest.modelo;

public class Detalles_CompraModel {

	public int id_factura;
	public int id_articulo;
	public double precio_final;
	public int cantidad;
	public double iva;
	public double descuento;

	public Detalles_CompraModel(int id_factura, int id_articulo, double precio_final, int cantidad, double iva,
			double descuento) {
		super();
		this.id_factura = id_factura;
		this.id_articulo = id_articulo;
		this.precio_final = precio_final;
		this.cantidad = cantidad;
		this.iva = iva;
		this.descuento = descuento;
	}

	public Detalles_CompraModel() {
		super();
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
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

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

}
