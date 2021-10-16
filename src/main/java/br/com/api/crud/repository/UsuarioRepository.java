package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByNome(String nome);

}
