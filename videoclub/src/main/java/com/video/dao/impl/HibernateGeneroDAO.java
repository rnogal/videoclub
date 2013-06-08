package com.video.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.video.bus.Genero;
import com.video.dao.GeneroDAO;
import com.video.utils.HibernateUtils;

public class HibernateGeneroDAO implements GeneroDAO {

	public List<Genero> getGeneros() {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Genero.class);
		List<Genero> generos = criteria.list();
		return generos;
	}

	public Genero getByCodigo(String codigo) {
		Session session = HibernateUtils.getSession();
		Genero genero = (Genero) session.get(Genero.class, codigo);
		return genero;
	}

	public void saveOrUpdate(Genero genero) {
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(genero);
	}

	public void delete(Genero genero) {
		Session session = HibernateUtils.getSession();
		session.delete(genero);
	}

}
