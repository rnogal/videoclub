package com.video.services;

import java.util.List;

import com.video.beans.CriteriosPelicula;
import com.video.bus.Copia;
import com.video.bus.Pelicula;

public interface PeliculaService {

	public void darAltaNuevaPelicula(Pelicula pelicula);
	
	public void darBajaPelicula(String isan);
	
	public void modificarFichaPelicula(Pelicula pelicula);
	
	public void darAltaCopia(Integer pelicula, Copia copiaPelicula);
	
	public void darBajaCopia(Copia copia);
	
	public Pelicula getFichaPelicula(Integer pelicula);
	
	public List<Copia> getCopiasPelicula(Integer pelicula);
	
	public List<Copia> getCopiasDisponiblesPelicula(Integer pelicula);
	
	public List<Pelicula> buscarPeliculasPorCriterio(CriteriosPelicula criterios);
	
}
