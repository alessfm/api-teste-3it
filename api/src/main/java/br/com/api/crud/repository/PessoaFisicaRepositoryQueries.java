package br.com.api.crud.repository;

import br.com.api.crud.model.Cidade;
import br.com.api.crud.model.Estado;

public interface PessoaFisicaRepositoryQueries {

	Cidade findCidadeByPessoaId(Long pessoaId);

	Estado findEstadoByPessoaId(Long pessoaId);

	Cidade findCidadeById(Long cidadeId);
	
	Estado findEstadoByUf(String uf);
}
