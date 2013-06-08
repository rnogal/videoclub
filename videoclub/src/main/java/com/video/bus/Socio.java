package com.video.bus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SOCIO")
public class Socio extends Usuario {

	@Column(name="numero_socio")
	private Integer numeroSocio;
	
	@Column(name="direccion")
	private String Direccion;

	public Integer getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(Integer numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
}
