package br.com.api.crud.servise;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
		
		public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaRepository.findAll().stream().map(PessoaFisicaDto::new).collect(Collectors.toList());
	}

		
	public PessoaFisica create(PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisica pessoaFisica = pessoaFisicaDto.toModel();	
		return pessoaFisicaRepository.save(pessoaFisica);
	}
	
	public PessoaFisicaDto findById(Long id) {
		return new PessoaFisicaDto(pessoaFisicaRepository.findById(id).get());
		
	}


	public void delete(Long id) {
		pessoaFisicaRepository.deleteById(id);
	}


	public PessoaFisicaDto update(Long pessoaId, PessoaFisicaDto pessoaFisicaDto) {
        
		PessoaFisica pessoaSalva = pessoaFisicaRepository.getById(pessoaId);
		
		pessoaSalva.setEmail(pessoaFisicaDto.getEmail());
		pessoaSalva.setNome(pessoaFisicaDto.getNome());
		pessoaSalva.setCpf(pessoaFisicaDto.getCpf());
		
         pessoaFisicaRepository.save(pessoaSalva);
		return null;
	}
	
	
}




