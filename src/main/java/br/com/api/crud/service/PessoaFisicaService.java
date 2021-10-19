package br.com.api.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.api.crud.controller.dto.PessoaFisicaDto;
import br.com.api.crud.exception.PessoaNotFoundException;
import br.com.api.crud.model.Cidade;
import br.com.api.crud.model.Estado;
import br.com.api.crud.model.PessoaFisica;
import br.com.api.crud.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	
	
	private PessoaFisicaRepository pessoaFisicaRepository;

	public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}

	public List<PessoaFisicaDto> findAll() {
		return pessoaFisicaRepository.findAll().stream().map(PessoaFisicaDto::new).collect(Collectors.toList());
	}

	public PessoaFisica create(PessoaFisicaDto pessoaFisicaDto) {
		PessoaFisica pessoaFisica = pessoaFisicaDto.toModel();
		
		Cidade cidadeEncontrada = pessoaFisicaRepository.findCidadeById(pessoaFisica.getCidade().getId());
		Estado estadoDaCidade = pessoaFisicaRepository.findEstadoByUf(cidadeEncontrada.getUf());
		
		pessoaFisica.setEstado(estadoDaCidade);
		pessoaFisica.setCidade(cidadeEncontrada);
		
		return pessoaFisicaRepository.save(pessoaFisica);
	}

	public PessoaFisica findById(Long id) {
		return verifyAndGetIfExists(id);

	}

	public PessoaFisica update(Long pessoaId, PessoaFisica pessoaSalva) {
		pessoaFisicaRepository.save(pessoaSalva);
		return pessoaSalva;
	}

	public void delete(Long id) {
		verifyAndGetIfExists(id);
		pessoaFisicaRepository.deleteById(id);
	}

	public Cidade getCidadeByPessoaId(Long pessoaId) {
		verifyAndGetIfExists(pessoaId);
		return pessoaFisicaRepository.findCidadeById(pessoaId);
	}

	public Estado getEstadoByPessoaId(Long pessoaId) {
		verifyAndGetIfExists(pessoaId);
		return pessoaFisicaRepository.findEstadoByPessoaId(pessoaId);
	}
	
    public PessoaFisica verifyAndGetIfExists(Long id) {
    	PessoaFisica pessoaEncontrada = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
        return pessoaEncontrada;
    }

}
