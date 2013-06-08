package com.video.dao;

import java.util.Date;
import java.util.List;

import com.video.bus.Alquiler;
import com.video.bus.Socio;

public interface AlquilerDAO {

	public void saveOrUpdate(Alquiler alquiler);
	
	public void delete(Alquiler alquiler);
	
	public List<Alquiler> getAlquileresSocioEntreFechas(Socio socio, Date fechaInicial, Date fechaFinal);

	
}
