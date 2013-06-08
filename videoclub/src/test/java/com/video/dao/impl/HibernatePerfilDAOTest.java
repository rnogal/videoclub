package com.video.dao.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.video.bus.Perfil;
import com.video.utils.HibernateUtils;

public class HibernatePerfilDAOTest {
	
	static HibernatePerfilDAO dao;
	
	@BeforeClass
	public static void testStart() {
		dao = new HibernatePerfilDAO();
	}


	@Test
	public void getPerfiles() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		List<Perfil> expected = new LinkedList();
		Perfil perfil = new Perfil("A", "Actor");
		expected.add(perfil);		
		dao.saveOrUpdate(perfil);
		perfil = new Perfil("D", "Director");
		expected.add(perfil);
		dao.saveOrUpdate(perfil);
		List<Perfil> actual = dao.getPerfiles();
		assertThat(actual, is(equalTo(expected)));
		for(Perfil p: expected ){
			dao.delete(p);
		}
		tr.commit();
	}

	@Test
	public void getByCodigo() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		Perfil expected = new Perfil("A", "Actor");
		dao.saveOrUpdate(expected);
		
		String codigo = "A";
		Perfil actual = dao.getByCodigo(codigo);
		assertThat(actual, is(equalTo(expected)));
		dao.delete(expected);
		actual = dao.getByCodigo(codigo);

		assertNull(actual);
		tr.commit();
	}

}
