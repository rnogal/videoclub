package com.video.dao;

import java.util.List;

import com.video.bus.Persona;

public interface PersonaDAO {
	
	public List<Persona> getPersonasByPerfil(String perfil);
	
	public Persona getPersonaByCodigo(Integer codigo);
	
	public void saveOrUpdate(Persona persona);
	
	public void delete(Persona persona);
}
