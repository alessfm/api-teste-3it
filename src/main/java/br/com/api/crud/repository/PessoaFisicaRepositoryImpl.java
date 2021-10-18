package br.com.api.crud.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.api.crud.model.Cidade;
import br.com.api.crud.model.Estado;

@Repository
public class PessoaFisicaRepositoryImpl implements PessoaFisicaRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Cidade findCidadeByPessoaId(Long pessoaId) {
		
		Query query = this.manager.createQuery("SELECT cidade FROM PessoaFisica p WHERE p.id = :pessoaId");
		query.setParameter("pessoaId", pessoaId);
		return (Cidade) query.getSingleResult();
		
	}
	
	@Override
	public Cidade findCidadeById(Long cidadeId) {
		
		Query query = this.manager.createQuery(" FROM Cidade  WHERE id = :cidadeId");
		query.setParameter("cidadeId", cidadeId);
		return (Cidade) query.getSingleResult();
		
	}
	
	@Override
	public Estado findEstadoByUf(String uf) {
		Query query = this.manager.createQuery(" FROM Estado  WHERE uf = :uf");
		query.setParameter("uf", uf);
		return (Estado) query.getSingleResult();
		
	}

	@Override
	public Estado findEstadoByPessoaId(Long pessoaId) {
		Query query = this.manager.createQuery("SELECT estado FROM PessoaFisica p WHERE p.id = :pessoaId");
		query.setParameter("pessoaId", pessoaId);
		return (Estado) query.getSingleResult();
	}

}
