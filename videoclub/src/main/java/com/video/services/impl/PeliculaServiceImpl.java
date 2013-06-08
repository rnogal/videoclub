package com.video.services.impl;

import java.util.List;

import com.video.beans.CriteriosPelicula;
import com.video.bus.Copia;
import com.video.bus.Pelicula;
import com.video.dao.PeliculaDAO;
import com.video.services.PeliculaService;

public class PeliculaServiceImpl implements PeliculaService {
	
	PeliculaDAO peliculaDAO;
	
	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void darAltaNuevaPelicula(Pelicula pelicula) {
		peliculaDAO.saveOrUpdate(pelicula);
		
	}

	public void darBajaPelicula(String isan) {
		Pelicula pelicula = peliculaDAO.getPeliculaByISAN(isan);
		peliculaDAO.delete(pelicula);
	}

	public void modificarFichaPelicula(Pelicula pelicula) {
		Pelicula p = peliculaDAO.getPeliculaByISAN(pelicula.getIsan());
		if (p == null){ 
			peliculaDAO.saveOrUpdate(p);
		}
	}

	public void darAltaCopia(Integer pelicula, Copia copiaPelicula) {
		// TODO Auto-generated method stub
		
	}

	public void darBajaCopia(Copia copia) {
		// TODO Auto-generated method stub
		
	}

	public Pelicula getFichaPelicula(Integer pelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Copia> getCopiasPelicula(Integer pelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Copia> getCopiasDisponiblesPelicula(Integer pelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pelicula> buscarPeliculasPorCriterio(CriteriosPelicula criterios) {
		// TODO Auto-generated method stub
		return null;
	}

}
