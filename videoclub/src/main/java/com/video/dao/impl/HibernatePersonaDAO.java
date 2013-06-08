package com.video.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.video.bus.Perfil;
import com.video.bus.Persona;
import com.video.dao.PersonaDAO;
import com.video.utils.HibernateUtils;

public class HibernatePersonaDAO implements PersonaDAO {

	public List<Persona> getPersonasByPerfil(String perfil) {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Persona.class)
				.createCriteria("perfiles")
				.add(Restrictions.eq("codigo", perfil));
		List<Persona> personas = criteria.list();
		return personas;
	}

	public Persona getPersonaByCodigo(Integer codigo) {
		Session session = HibernateUtils.getSession();
		Persona persona = (Persona) session.load(Persona.class, codigo);
		return persona;
	}

	public void saveOrUpdate(Persona persona) {
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(persona);
	}

	public void delete(Persona persona) {
		Session session = HibernateUtils.getSession();
		session.delete(persona);
	}

}
