package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.crud.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findByNome(String nome);

}
