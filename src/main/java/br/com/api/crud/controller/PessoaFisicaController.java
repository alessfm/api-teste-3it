package br.com.api.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.servise.PessoaFisicaServise;

@RestController
@RequestMapping("/usuarios")
public class PessoaFisicaController {

	@Autowired
	private PessoaFisicaServise pessoaFisicaServise;
	
	@GetMapping
	public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaServise.findAll();
		
	}
	
	@PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	public PessoaFisica create(@RequestBody PessoaFisicaDto pessoaFisicaDto) {
		return pessoaFisicaServise.create(pessoaFisicaDto);
	}

}
