package com.viewVetApiSpring.apiRest.modelo;

public class ArticuloModel {

	public int id_articulo;
	public String nombre;
	public double precio;
	public double iva;
	public double descuento;
	public int cantidad;
	public String categoria;
	public String duracion;
	public int consulta;
	public String tipo;
	public boolean estado;
	public int id_usuario;

	public ArticuloModel(int id_articulo, String nombre, double precio, double iva, double descuento, int cantidad,
			String categoria, String duracion, int consulta, String tipo, boolean estado, int id_usuario) {
		super();
		this.id_articulo = id_articulo;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.descuento = descuento;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.duracion = duracion;
		this.consulta = consulta;
		this.tipo = tipo;
		this.estado = estado;
		this.id_usuario = id_usuario;
	}

	public ArticuloModel() {
		super();
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getConsulta() {
		return consulta;
	}

	public void setConsulta(int consulta) {
		this.consulta = consulta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
