package br.com.api.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.crud.model.Cidade;
import br.com.api.crud.repository.MunicipioRepository;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioRepository municipioRepository;

	@GetMapping
	public List<Cidade> findAll() {
		return municipioRepository.findAll();
	}

	@GetMapping("/{id}")
	public Cidade findById(@PathVariable("id") Long id) {
		return municipioRepository.findById(id).get();
	}

	@GetMapping("/uf/{sigla}")
	public List<Cidade> findByUf(@PathVariable("sigla") String sigla) {
		return municipioRepository.findByUf(sigla);
	}

}
