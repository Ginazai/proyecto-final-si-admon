package com.dashboard.Services;

import java.util.List;

import com.dashboard.Entities.ContenidoEntidad;

public interface ContenidoServicio {
	
	List<ContenidoEntidad> allContenido();
	
	ContenidoEntidad saveContenido(ContenidoEntidad contenido);
	
	void deleteContenido(Long id);
	
	ContenidoEntidad getContenido(Long id);
	
	ContenidoEntidad editarContenido(Long id, ContenidoEntidad contenidoEntidad);
	
	List<ContenidoEntidad> getPorCategoria(String categoria);
}