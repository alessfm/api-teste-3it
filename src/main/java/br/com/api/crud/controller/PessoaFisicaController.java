package br.com.api.crud.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.crud.controller.dto.CidadeDto;
import br.com.api.crud.controller.dto.EstadoDto;
import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaFisicaController {


	@Autowired
	private PessoaFisicaService pessoaFisicaService;

	@GetMapping
	public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaService.findAll();

	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaFisica create(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
		return pessoaFisicaService.create(pessoaFisicaDto);
	}

	@GetMapping("/{id}")
	@Transactional
	public PessoaFisicaDto findById(@PathVariable("id") Long pessoaId) {
		
		return new PessoaFisicaDto(pessoaFisicaService.findById(pessoaId));
	}
	
	@GetMapping("/{id}/cidade")
	@Transactional
	public CidadeDto getCidadeByPessoaId(@PathVariable("id") Long pessoaId) {
		
		return new CidadeDto(pessoaFisicaService.getCidadeByPessoaId(pessoaId));
	}

	@GetMapping("/{id}/cidade/estado")
	@Transactional
	public EstadoDto getEstadoByPessoaId(@PathVariable("id") Long pessoaId) {
		return new EstadoDto(pessoaFisicaService.getEstadoByPessoaId(pessoaId));
	}

	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaFisicaDto> update(@PathVariable("id") Long pessoaId, @RequestBody PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisica pessoaAtual = pessoaFisicaService.findById(pessoaId);
		
		if(pessoaAtual != null) {
			BeanUtils.copyProperties(pessoaFisicaDto, pessoaAtual, "id", "cidade", "estado");
			
			pessoaAtual = pessoaFisicaService.update(pessoaId, pessoaAtual);
			PessoaFisicaDto pessoaFisicaAtualizada = new PessoaFisicaDto(pessoaAtual);
			return ResponseEntity.ok(pessoaFisicaAtualizada);
		}
		
		return ResponseEntity.notFound().build();
	}

	
	
	@DeleteMapping("/{id}")
	@Transactional
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pessoaFisicaService.delete(id);
	}
	
//	@PostMapping
//	@RequestMapping("/{usuarioId}/")
//	@Transactional
//
//
	}
