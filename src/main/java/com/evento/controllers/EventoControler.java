package com.evento.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evento.models.Evento;
import com.evento.repositories.EventoRepository;

@RestController
@RequestMapping("/evento")
public class EventoControler {

	@Autowired
	private EventoRepository er;
	
	@PostMapping(consumes = "application/json")
	public Evento cadastraEvento(@Valid @RequestBody Evento evento){		
		return er.save(evento);
	}
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Evento> listaEventos(){
		Iterable<Evento> eventos = er.findAll();
		return eventos;
	}

	@DeleteMapping(consumes = "application/json")
	public Evento deletaEvento(@Valid @RequestBody Evento evento){
		er.delete(evento);
		return evento;
	}
	
	@PutMapping(consumes = "application/json")
	public String alteraEvento(@Valid @RequestBody Evento evento){
		if (er.existsById(evento.getCodigo())) {
			er.save(evento);
			return "Evento alterado com sucesso";
		}else {
			return "Evento inexistente";
		}
	}
}
