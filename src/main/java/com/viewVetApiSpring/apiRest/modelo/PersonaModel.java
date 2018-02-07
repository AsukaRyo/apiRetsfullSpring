package com.viewVetApiSpring.apiRest.modelo;

import java.io.Serializable;

public class PersonaModel implements Serializable {
	
	int id_usuario;
	String nif;
	String nombre;
	String direccion;
	String telefono;
	String email;
	String especialidad;
	String cuenta_bancaria;
	String password;
	boolean estado;
	String imagen;
	boolean proveedor;
	int id_rol;
	
	public PersonaModel() {
	}
	public PersonaModel(int id_usuario, String nif, String nombre, String direccion, String telefono, String email,
			String especialidad, String cuenta_bancaria, String password, boolean estado, String imagen,
			boolean proveedor, int id_rol) {
		super();
		this.id_usuario = id_usuario;
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
		this.id_rol = id_rol;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	@Override
	public String toString() {
		return "PersonaModel [id_usuario=" + id_usuario + ", nif=" + nif + ", nombre=" + nombre + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + ", especialidad=" + especialidad
				+ ", cuenta_bancaria=" + cuenta_bancaria + ", password=" + password + ", estado=" + estado + ", imagen="
				+ imagen + ", proveedor=" + proveedor + ", id_rol=" + id_rol + "]";
	}
	
	
	
}
