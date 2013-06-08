package com.video.bus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="USUARIO")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO", discriminatorType=DiscriminatorType.STRING)
public abstract class Usuario {

	public enum TipoUsuario {SOCIO, ADMIN};
	
	/** Tipo de usuario */
	@Column(name="tipo") 
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	@Id
	@Column(name="usuario", length=30, unique = true)
	private String user;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="email", nullable= false)
	@Email
	private String email;

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
