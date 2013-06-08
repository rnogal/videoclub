package com.video.dao.impl;

import com.video.dao.impl.HibernatePersonaDAO.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.video.bus.Perfil;
import com.video.bus.Persona;
import com.video.dao.PerfilDAO;
import com.video.dao.PersonaDAO;
import com.video.utils.HibernateUtils;
public class HibernatePersonaDAOTest {

	static HibernatePersonaDAO dao;
	static List<Perfil> perfiles = new LinkedList();
	static Perfil actor;
	
	@BeforeClass
	public static void testStart() {
		dao = new HibernatePersonaDAO();
		PerfilDAO perfilDao = new HibernatePerfilDAO();
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
	
		Perfil perfil = new Perfil("D","Director");
		perfiles.add(perfil);
		perfil = new Perfil("A","Actor");
		actor = perfil;				
		perfiles.add(perfil);
		tr.commit();
		
		
	}
	
	@Test
	public void type() throws Exception {
		assertThat(HibernatePersonaDAO.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		HibernatePersonaDAO target = new HibernatePersonaDAO();
		assertThat(target, notNullValue());
	}

	@Test
	public void getPersonasByPerfil_A$String() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Persona> expected = new ArrayList();

		Persona persona = new Persona("Keanu", "Reeves", new Date(1966, 4, 2));
		persona.setPerfiles(perfiles);
		session.saveOrUpdate(persona);
		expected.add(persona);
		
		persona = new Persona("John", "Travolta", new Date(1955, 9, 23));
		persona.setPerfiles(Arrays.asList(actor));
		session.saveOrUpdate(persona);
		expected.add(persona);

		String perfil = "A";
		List<Persona> actual = dao.getPersonasByPerfil(perfil);
		assertThat(actual.size(), is(equalTo(expected.size())));
		
		for(Persona p: expected) {
			session.delete(p);
		}
		tr.commit();
	}

	@Test
	public void getPersonaByCodigo() throws Exception {

		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
	
		Persona persona = new Persona("Keanu", "Reeves", new Date(1966, 4, 2));
		session.saveOrUpdate(persona);
		
		Integer codigo = persona.getCodigo();
		Persona actual = dao.getPersonaByCodigo(codigo);
		Persona expected = persona;
		assertThat(actual, is(equalTo(expected)));
		
		tr.commit();
	}


}
