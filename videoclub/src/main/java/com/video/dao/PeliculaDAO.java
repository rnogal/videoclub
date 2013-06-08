package com.video.dao;

import java.util.Collection;

import com.video.bus.Pelicula;

public interface PeliculaDAO {

	public Collection<Pelicula> getPeliculas();
	
	public Pelicula getPeliculaByISAN(String isan);
	
	public Collection<Pelicula> getPeliculasByGenero(String genero); 

	public void saveOrUpdate(Pelicula pelicula);
	
	public void delete(Pelicula pelicula);
}
