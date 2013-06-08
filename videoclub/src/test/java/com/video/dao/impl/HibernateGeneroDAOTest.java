package com.video.dao.impl;

import com.video.dao.impl.HibernateGeneroDAO.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.video.bus.Genero;
import com.video.dao.GeneroDAO;
import com.video.utils.HibernateUtils;
public class HibernateGeneroDAOTest {

	static HibernateGeneroDAO dao;
	static Map<String, Genero> generosPrueba = new HashMap();
	
	private static void addGeneroPrueba(String codigo, String descripcion) {
		Genero genero = new Genero(codigo, descripcion);
		generosPrueba.put(genero.getCodigo(), genero);
		HibernateUtils.getSession().saveOrUpdate(genero);
	}
	
	@BeforeClass
	public static void testStart() {
		dao = new HibernateGeneroDAO();
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
	
		addGeneroPrueba("SCIFI", "Ciencia ficci—n");
		addGeneroPrueba("DRAMA", "Drama");
		addGeneroPrueba("WESTERN", "Western");
		addGeneroPrueba("INF", "Infantil");
		tr.commit();
	}

	@Test
	public void testGetByCodigo() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		String codigo = "SCIFI";
		Genero actual = dao.getByCodigo(codigo);
		Genero expected = generosPrueba.get(codigo);
		assertThat(actual, is(equalTo(expected)));
		tr.commit();
	}

	@Test
	public void testSaveOrUpdate() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Genero gen = dao.getByCodigo("TERROR");
		dao.saveOrUpdate(gen);
		
		tr.commit();
	}

	@Test
	public void testDelete() throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Genero genero = dao.getByCodigo("SCIFI");
		dao.delete(genero);
		tr.commit();

	}

}
