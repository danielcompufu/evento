package com.evento.repositories;

import org.springframework.data.repository.CrudRepository;

import com.evento.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{
	
}
