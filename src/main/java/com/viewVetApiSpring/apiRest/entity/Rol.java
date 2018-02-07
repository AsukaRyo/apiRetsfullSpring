package com.viewVetApiSpring.apiRest.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQuery(
		name = "asociarPermisos", 
		procedureName = "asociarPermisos", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "idPermiso"), 
		}
	)
@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue
	@Column(name = "id_rol")
	public int idrol;
	
	/** The dni. */
	@Column(name = "name", length = 255)
	public String name;
	
	@OneToMany(mappedBy = "idrol", fetch = FetchType.EAGER)
	private Set<Persona> personas = new HashSet<Persona>();
	
	@ManyToMany
	@JoinTable
	private Set<Permiso> permisos = new HashSet<Permiso>();
	public Rol(int id_rol, String name) {
		super();
		this.idrol = id_rol;
		this.name = name;
	}
	
	
	public Rol() {
		super();
	}

	public int getid_rol() {
		return idrol;
	}

	public void setid_rol(int id_rol) {
		this.idrol = id_rol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<Permiso> getPermisos() {
		return permisos;
	}


	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	
	
}
