package com.dashboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.Entities.ContenidoEntidad;

public interface ContenidoRepositorio extends JpaRepository<ContenidoEntidad, Long>{
	
}
