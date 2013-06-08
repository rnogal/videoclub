package com.video.dao;

import java.util.List;
import com.video.bus.Genero;

public interface GeneroDAO {
	
	public List<Genero> getGeneros();
	
	public Genero getByCodigo(String codigo);
	
	public void saveOrUpdate(Genero genero);
	
	public void delete(Genero genero);	

}
