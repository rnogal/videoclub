package com.video.services;

import com.video.bus.Administrador;
import com.video.bus.Socio;

public interface UsuariosService {
	
	public boolean darAltaSocio(Socio socioNuevo);
	
	public boolean darBajaSocio(Integer codigoSocio);
	
	public boolean modificarSocio(Socio socio);
	
	public boolean darAltaAdministrador(Administrador admin);
	
	public boolean eliminarAdministrador(Integer administrador);
	

}
