package com.video.bus;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name = "PERSONAS")
public class Persona {
	
	/** C—digo interno de la persona */
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Column (name = "codigo")
	private Integer codigo;
	
	/** Nombre de la persona */
	@Column (name = "nombre", length=20, nullable=false)
	private String nombre;
	
	/** Primer apellido de la persona */
	@Column (name = "apellido", length=30, nullable=false)
	private String apellido;
	
	/** Pel’culas asociadas*/
	@ManyToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
    )
	@JoinTable (
			name = "PELICULAS_PERSONA",
			joinColumns = {@JoinColumn(name="PERSONA_ID") },
			inverseJoinColumns = {@JoinColumn(name="PELICULA_ID") }
	)
	private List<Pelicula> peliculas;
	
	/** Fecha de nacimiento */
	@Column (name = "fecha_nacimiento")
	@Type (type="date")
	private Date fechaNacimiento;
	
	/** Perfiles asociadaos a la persona: Actor, Director, Productor*/
	@ManyToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
    )
	@JoinTable (
			name = "PERFILES_PERSONA",
			joinColumns = {@JoinColumn(name="PERSONA_ID") },
			inverseJoinColumns = {@JoinColumn(name="PERFIL_ID") }
	)
	private List<Perfil> perfiles;

	
	
	public Persona(String nombre, String apellido, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	public void addPerfil(Perfil  perfil) {
		this.perfiles.add(perfil);
	} 
	
	public void deletePerfil(Perfil perfil) {
		this.perfiles.remove(perfil);
	}
	
}
