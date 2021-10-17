package br.com.api.crud.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.servise.PessoaFisicaService;

@RestController
@RequestMapping("/usuarios")
public class PessoaFisicaController {

	@Autowired
	private PessoaFisicaService pessoaFisicaService;

	@GetMapping
	public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaService.findAll();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaFisica create(@RequestBody PessoaFisicaDto pessoaFisicaDto) {
		return pessoaFisicaService.create(pessoaFisicaDto);
	}

	@GetMapping("/{id}")
	public PessoaFisicaDto findById(@PathVariable("id") Long pessoaId) {
		return pessoaFisicaService.findById(pessoaId);
	}

	@PutMapping("/{Id}")
	@Transactional
	public PessoaFisicaDto update(@PathVariable Long pessoaId, @RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
		return pessoaFisicaService.update(pessoaId, pessoaFisicaDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pessoaFisicaService.delete(id);
	}

}
