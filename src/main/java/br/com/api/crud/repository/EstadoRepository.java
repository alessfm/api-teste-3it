package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.crud.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	List<Estado> findByNome(String nome);

}
