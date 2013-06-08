package com.video.dao.impl;

import java.util.Collection;
import java.util.Collections;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.video.bus.Pelicula;
import com.video.dao.PeliculaDAO;
import com.video.utils.HibernateUtils;

public class HibernatePeliculaDAO implements PeliculaDAO {

	public Collection<Pelicula> getPeliculas() {
		try {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Pelicula.class);
		Collection<Pelicula> peliculas = criteria.list();
		return peliculas; 
		} catch (Exception e) {
			return null;
		}
	}

	public Pelicula getPeliculaByISAN(String isan) {
		Session session = HibernateUtils.getSession();
		Pelicula pelicula = (Pelicula) session.load(Pelicula.class, isan);
		return pelicula;
	}

	public Collection<Pelicula> getPeliculasByGenero(String genero) {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Pelicula.class);
		criteria.createCriteria("genero").add(Restrictions.eq("codigo", genero));
		Collection peliculas = criteria.list();
		return peliculas;
	}

	public void saveOrUpdate(Pelicula pelicula) {
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(pelicula);		
	}

	public void delete(Pelicula pelicula) {
		Session session = HibernateUtils.getSession();
		session.delete(pelicula);
	}

}
