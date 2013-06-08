package com.video.dao;

import java.util.List;

import com.video.bus.Perfil;


public interface PerfilDAO {

	public List<Perfil> getPerfiles();
	
	public Perfil getByCodigo(String codigo);
	
	public void saveOrUpdate(Perfil perfil);
	
	public void delete(Perfil perfil);	
}
