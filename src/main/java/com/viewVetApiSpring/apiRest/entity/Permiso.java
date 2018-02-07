package com.viewVetApiSpring.apiRest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permisos")
public class Permiso {
	
	@Id
	@GeneratedValue
	@Column(name = "id_permiso")
	private int idPermiso;
	
	@Column(name = "nombre_permiso")
	private String nombrePermiso;
	
	@ManyToMany(mappedBy = "permisos", fetch = FetchType.LAZY)
	private Set<Rol> roles = new HashSet<Rol>();
	
	public Permiso() {
	}
	
	public Permiso(String nombrePermiso) {
		super();
		this.nombrePermiso = nombrePermiso;
	}

	public String getPermisos_id_permiso() {
		return String.valueOf(idPermiso);
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getNombre_permiso() {
		return nombrePermiso;
	}

	public void setNombrePermiso(String nombrePermiso) {
		this.nombrePermiso = nombrePermiso;
	}
	
	
}