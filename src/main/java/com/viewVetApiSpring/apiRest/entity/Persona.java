package com.viewVetApiSpring.apiRest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "persona")
public class Persona {
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "id_usuario", unique = true, nullable = false, length = 9)
	public int idusuario;

	/** The dni. */
	@Column(name = "nif", unique = true, nullable = false, length = 255)
	public String nif;

	/** The nombre. */
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	/** The direccion. */
	@Column(name = "direccion", nullable = false, length = 255)
	private String direccion;

	/** The telefono. */
	@Column(name = "telefono", nullable = false, length = 255)
	private String telefono;

	/** The email. */
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	/** The especialidad. */
	@Column(name = "especialidad", nullable = false, length = 255)
	private String especialidad;

	@Column(name = "cuenta_bancaria", nullable = false, length = 255)
	private String cuenta_bancaria;

	/** The password. */
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	/** The password. */
	@Column(name = "imagen", nullable = false, length = 255)
	private String imagen;

	@Column(name = "proveedor", nullable = false)
	private boolean proveedor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol")
	private Rol idrol;

	@OneToMany(mappedBy = "id_usuario", fetch = FetchType.EAGER)
	private Set<Articulo> articulos = new HashSet<Articulo>();

	@OneToMany(mappedBy = "id_usuario", fetch = FetchType.EAGER)
	private Set<Factura> facturas = new HashSet<Factura>();

	public Persona() {
	}

	public Persona(int id_usuario, String nif, String nombre, String direccion, String telefono, String email,
			String especialidad, String cuenta_bancaria, String password, boolean estado, String imagen,
			boolean proveedor) {
		super();
		this.idusuario = id_usuario;
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.especialidad = especialidad;
		this.cuenta_bancaria = cuenta_bancaria;
		this.password = password;
		this.estado = estado;
		this.imagen = imagen;
		this.proveedor = proveedor;
	}

	public int getid_usuario() {
		return idusuario;
	}

	public void setid_usuario(int id_usuario) {
		this.idusuario = id_usuario;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isProveedor() {
		return proveedor;
	}

	public void setProveedor(boolean proveedor) {
		this.proveedor = proveedor;
	}

	public int getId_rol() {
		return idrol.idrol;
	}

	public void setId_rol(Rol id_rol) {
		this.idrol = id_rol;
	}

	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Persona [idusuario=" + idusuario + ", nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", email=" + email + ", especialidad=" + especialidad
				+ ", cuenta_bancaria=" + cuenta_bancaria + ", password=" + password + ", estado=" + estado + ", imagen="
				+ imagen + ", proveedor=" + proveedor + ", idrol=" + idrol + "]";
	}

}
