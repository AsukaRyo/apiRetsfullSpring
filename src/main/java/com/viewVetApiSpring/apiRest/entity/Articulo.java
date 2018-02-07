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
@Table(name = "articulo")
public class Articulo {

	@Id
	@GeneratedValue
	@Column(name = "id_articulo")
	public int idarticulo;

	@Column(name = "nombre", length = 255)
	public String nombre;

	@Column(name = "precio")
	public double precio;

	@Column(name = "iva")
	public double iva;

	@Column(name = "descuento")
	public double descuento;

	@Column(name = "categoria", length = 255)
	public String categoria;

	@Column(name = "duracion", length = 255)
	public String duracion;

	@Column(name = "consulta")
	public int consulta;

	@Column(name = "tipo", length = 255)
	public String tipo;

	@Column(name = "estado")
	public boolean estado;

	@Column(name = "cantidad")
	public int cantidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Persona id_usuario;
	
	@OneToMany(mappedBy = "id.id_articulo", fetch = FetchType.EAGER)
	private Set<Detalles_Compra> detalles_compra = new HashSet<Detalles_Compra>();
	public Articulo() {
		super();
	}

	public Articulo(int idarticulo, String nombre, double precio, double iva, double descuento, String categoria,
			String duracion, int consulta, String tipo, boolean estado, int cantidad) {
		super();
		this.idarticulo = idarticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.descuento = descuento;
		this.categoria = categoria;
		this.duracion = duracion;
		this.consulta = consulta;
		this.tipo = tipo;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	public Articulo(int idarticulo, String nombre, double precio, double iva, double descuento, String categoria,
			String duracion, int consulta, String tipo, boolean estado, int cantidad, Persona id_usuario) {
		super();
		this.idarticulo = idarticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.descuento = descuento;
		this.categoria = categoria;
		this.duracion = duracion;
		this.consulta = consulta;
		this.tipo = tipo;
		this.estado = estado;
		this.cantidad = cantidad;
		this.id_usuario = id_usuario;
	}

	public int getId_articulo() {
		return idarticulo;
	}

	public void setId_articulo(int id_articulo) {
		try {
			this.idarticulo = id_articulo;

		}catch(NullPointerException e) {
			System.out.println("Entro en sysout");
		}
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getId_usuario() {
		try {
			
			return id_usuario.getid_usuario();
		}catch(Exception e) {
			return 0;

		}
		
	}

	public void setIdusuario(Persona idusuario) {
		this.id_usuario = idusuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
