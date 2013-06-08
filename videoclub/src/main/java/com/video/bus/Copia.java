package com.video.bus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "COPIAS" )
public class Copia {

	public enum Formato {VHS, DVD, BlueRay};
	
	/** C—digo interno de la copia */
	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name="codigo", unique=true)
	private Integer codigo;
	
	/** C—digo de la pelicula */
	@ManyToOne(cascade=CascadeType.ALL)
	private Pelicula pelicula;
	
	/** Formato de la copia de la pel’cula*/
	@Column(name="formato") 
	@Enumerated(EnumType.STRING) 
	private Formato formato;
	
	/** Flag indicando si la copia est‡ alquilada o no*/
	@Column(name="alquilada")
	private boolean alquilada;

	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public boolean isAlquilada() {
		return alquilada;
	}

	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}
	
	
}
