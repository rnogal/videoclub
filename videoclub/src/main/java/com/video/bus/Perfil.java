package com.video.bus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class Perfil {

	/** C—digo interno del perfil */
	@Id
	@Column(name="codigo", unique=true)
	private String codigo;
	
	/** Descripci—n del perfil */
	@Column(name="descripcion", length=30, nullable=false)
	private String descripcion;

	
	
	public Perfil(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
