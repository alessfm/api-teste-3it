package br.com.api.crud.servise;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaServise {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
		
		public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaRepository.findAll().stream().map(PessoaFisicaDto::new).collect(Collectors.toList());
		
	}
		
		
	public PessoaFisica create(PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisica pessoaFisica = pessoaFisicaDto.toModel();	
		return pessoaFisicaRepository.save(pessoaFisica);
	}
		
}




