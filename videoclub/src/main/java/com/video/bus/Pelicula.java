package com.video.bus;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "PELICULA")
public class Pelicula {

	/** C—digo de la pel’cula */
	@Id
	@Column(name="isan", unique=true, length=96)
	private String isan;
	
	/** T’tulo de la pel’cula */
	@Column(name="titulo", length=100, nullable=false)
	private String titulo;
	
	/** im‡gen de la pel’cula */
	@Lob
	@Column(name="imagen", nullable=true)
	private Blob imagen;
	
	/** Sinopsis de la pel’cula */
	@Column(name="sinopsis", nullable=true, length=4000)
	private String sinopsis;
	
	/** duraci—n de la pel’cula */
	@Column(name="duracion", nullable=true)
	private Integer duracion;
	
	/** a–o de la pel’cula */
	@Column(name="ano", nullable=true)
	private Integer ano;
	
	@ManyToOne
	private Genero genero;
	
	/** actores principales de la pel’cula */
	@ManyToMany(
	   fetch = FetchType.LAZY
	 )
	@Cascade({CascadeType.SAVE_UPDATE})
	 @JoinTable(
	   name = "ACTORES_PELICULA",
	   joinColumns = { @JoinColumn(name = "PELICULA_ID") },
	   inverseJoinColumns = { @JoinColumn(name = "PERSONA_ID") }
	 )
	private Set<Persona> actores;
	
	/** directores de la pel’cula */
	@ManyToMany(
	   fetch = FetchType.LAZY
	 )
	@Cascade({CascadeType.SAVE_UPDATE})
	 @JoinTable(
	   name = "DIRECTORES_PELICULA",
	   joinColumns = { @JoinColumn(name = "PELICULA_ID") },
	   inverseJoinColumns = { @JoinColumn(name = "PERSONA_ID") }
	 )
	private Set<Persona> directores;
	
	@OneToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	@JoinColumn(name = "isan")
	private List<Copia> copias;
	
	public Pelicula() {}
	
	public Pelicula(String iSAN, String titulo, Blob imagen, String sinopsis,
			Integer duracion, Integer ano, Genero genero) {
		super();
		this.isan = iSAN;
		this.titulo = titulo;
		this.imagen = imagen;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.ano = ano;
		this.genero = genero;
	}

	public String getIsan() {
		return isan;
	}

	public void setISAN(String isan) {
		this.isan = isan;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Set<Persona> getActores() {
		return actores;
	}

	public void setActores(Set<Persona> actores) {
		this.actores = actores;
	}

	public Set<Persona> getDirectores() {
		return directores;
	}

	public void setDirectores(Set<Persona> directores) {
		this.directores = directores;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	
}
