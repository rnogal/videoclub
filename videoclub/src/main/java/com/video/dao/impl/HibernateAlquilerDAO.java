package com.video.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.video.bus.Alquiler;
import com.video.bus.Socio;
import com.video.dao.AlquilerDAO;
import com.video.utils.HibernateUtils;

public class HibernateAlquilerDAO implements AlquilerDAO {

	public void saveOrUpdate(Alquiler alquiler) {
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(alquiler);
	}

	public void delete(Alquiler alquiler) {
		Session session = HibernateUtils.getSession();
		session.delete(alquiler);		
	}

	public List<Alquiler> getAlquileresSocioEntreFechas(Socio socio, Date fechaInicial, Date fechaFin) {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Alquiler.class); 
		criteria.add(Restrictions.ge("fechaAlquiler", fechaInicial));
		if (fechaFin != null) {
			criteria.add(Restrictions.le("fechaAlquiler", fechaFin));	
		}
		return criteria.list();
	}

}
