package br.com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.crud.model.Cidade;
import br.com.api.crud.model.Estado;
import br.com.api.crud.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{
	

	Cidade findCidadeByPessoaId(Long pessoaId);

	Estado findEstadoByPessoaId(Long pessoaId);

	Cidade findCidadeById(Long cidadeId);
	
	Estado findEstadoByUf(String uf);
}
