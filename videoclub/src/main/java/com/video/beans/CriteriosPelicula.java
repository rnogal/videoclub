package com.video.beans;

import java.util.Date;

public class CriteriosPelicula {
	
	/** Genero al que pertenece la pel’cula */ 
	private String genero;
	
	/** Fecha de inicio del criterio de bœsqueda para pel’culas*/
	private Date fechaInicial;
	
	/** Fecha de fin del criterio de bœsqueda para pel’culas*/
	private Date fechaFinal;
	
	/** Patr—n de bœsqueda del t’tulo de la pel’cula */
	private String tituloBusqueda;

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getTituloBusqueda() {
		return tituloBusqueda;
	}

	public void setTituloBusqueda(String tituloBusqueda) {
		this.tituloBusqueda = tituloBusqueda;
	}
	

}
