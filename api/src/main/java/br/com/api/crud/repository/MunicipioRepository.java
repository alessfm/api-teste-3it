package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.crud.model.Cidade;

@Repository
public interface MunicipioRepository extends JpaRepository<Cidade, Long>{

    List<Cidade> findByUf(String sigla);
	
}
