package com.video.bus;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity
@Table(name="LINEAS_ALQUILER")
public class LineaAlquiler {

	@Id
	private Integer id;
	
	@NaturalId
	@Column(name="alquiler", nullable= false)
	private Integer alquiler;
	
	/** C—digo de la copia de la pel’cula alquilada */
	@NaturalId
	@Column(name="copia", nullable= false)
	private Integer copia;

	/** Fecha de devoluci—n */
	@Column(name="fechaDevolucion", nullable= true)
	@Type(type = "date")
	private Date fechaDevoluci—n;
	
	/** Importe del alquiler de esta copia */
	@Column(name="importe")
	private Float importe;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Integer alquiler) {
		this.alquiler = alquiler;
	}

	public Integer getCopia() {
		return copia;
	}

	public void setCopia(Integer copia) {
		this.copia = copia;
	}

	public Date getFechaDevoluci—n() {
		return fechaDevoluci—n;
	}

	public void setFechaDevoluci—n(Date fechaDevoluci—n) {
		this.fechaDevoluci—n = fechaDevoluci—n;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}
	
}
