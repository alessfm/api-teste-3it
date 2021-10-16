package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.crud.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{
	
	List<PessoaFisica> findByNome(String nome);

}
