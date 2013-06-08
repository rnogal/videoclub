package com.video.bus;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

@Entity
@Table( name="ALQUILERES" )
public class Alquiler {

	/** C—digo de alquiler */
	@Id
	@Generated(GenerationTime.INSERT)
	private Integer codigo;
	
	/** C—digo del usuario del alquiler */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "SOCIO_ID")
	private Socio socio;
	
	/** Fecha de alquiler */
	@Column(name="FECHA_ALQUILER", nullable=false)
	@Type(type="date")
	private Date fechaAlquiler;
	
	/** Conjunto de copias alquiladas en el mismo alquiler */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "ALQUILER_ID")
	private List<LineaAlquiler> copiasAlquiladas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public List<LineaAlquiler> getCopiasAlquiladas() {
		return copiasAlquiladas;
	}

	public void setCopiasAlquiladas(List<LineaAlquiler> copiasAlquiladas) {
		this.copiasAlquiladas = copiasAlquiladas;
	}

	
}
