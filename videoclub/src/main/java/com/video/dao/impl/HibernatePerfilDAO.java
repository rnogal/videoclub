package com.video.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.video.bus.Genero;
import com.video.bus.Perfil;
import com.video.dao.PerfilDAO;
import com.video.utils.HibernateUtils;

public class HibernatePerfilDAO implements PerfilDAO {
	
	Logger log = Logger.getLogger(HibernatePerfilDAO.class);

	public List<Perfil> getPerfiles() {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Perfil.class);
		List<Perfil> perfiles = criteria.list();
		log.info("getPerfiles ejecutado");
		return perfiles;
	}

	public Perfil getByCodigo(String codigo) {
		Session session = HibernateUtils.getSession();
		log.info("getByCodigo ejecutado");
		return (Perfil)session.get(Perfil.class, codigo);
	}

	public void saveOrUpdate(Perfil perfil) {
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(perfil);
		log.info("saveOrUndate ejecutado");
	}

	public void delete(Perfil perfil) {
		Session session = HibernateUtils.getSession();
		session.delete(perfil);
		log.info("delete ejecutado");

	}

}
