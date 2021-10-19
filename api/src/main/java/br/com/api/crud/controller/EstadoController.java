package br.com.api.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.crud.model.Estado;
import br.com.api.crud.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Estado findById(@PathVariable("id") Long id) {
		return estadoRepository.findById(id).get();
	}
	
}
