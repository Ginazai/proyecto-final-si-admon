package com.dashboard.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dashboard.Entities.ContenidoEntidad;
import com.dashboard.Repositories.ContenidoRepositorio;
import com.dashboard.Services.ContenidoServicio;

@Service
public class ContenidoServicioImpl implements ContenidoServicio {
	
	
	private final ContenidoRepositorio contenidoRepositorio;
	
	
	public ContenidoServicioImpl(ContenidoRepositorio contenidoRepositorio) {
		this.contenidoRepositorio = contenidoRepositorio;
	}

	@Override
	public List<ContenidoEntidad> allContenido() {
		return contenidoRepositorio.findAll();
	}

	@Override
	public ContenidoEntidad saveContenido(ContenidoEntidad contenido) {
		return contenidoRepositorio.save(contenido);
	}

	@Override
	public void deleteContenido(Long id) {
		contenidoRepositorio.deleteById(id);
	}

	@Override
	public ContenidoEntidad getContenido(Long id) {
		return contenidoRepositorio.getReferenceById(id);
	}

	@Override
	public ContenidoEntidad editarContenido(Long id, ContenidoEntidad contenidoActualizado) {
		ContenidoEntidad contenidoExistente = contenidoRepositorio.findById(id).orElse(null);
		if (contenidoExistente != null) {
			contenidoExistente.setImage(contenidoActualizado.getImage());
			contenidoExistente.setTitulo(contenidoActualizado.getTitulo());
			contenidoExistente.setContenido(contenidoActualizado.getContenido());
			contenidoExistente.setCategoria(contenidoActualizado.getCategoria());
			return contenidoRepositorio.save(contenidoExistente);
		} else {return null;}
	}

	@Override
	public List<ContenidoEntidad> getPorCategoria(String categoria) {
		List<ContenidoEntidad> contenidos = contenidoRepositorio.findAll();
		List<ContenidoEntidad> elementos = new ArrayList<ContenidoEntidad>();
		if (contenidos != null) {
			for (int i = 0; i < contenidos.size(); i++) {
				if (contenidos.get(i).getCategoria().equals(categoria)) {
					elementos.add(contenidos.get(i));
				}
			}
			return elementos;
		} else {return null;}
	}

}
