package br.com.api.crud.exception;

import javax.persistence.EntityNotFoundException;

public class PessoaNotFoundException  extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
        super(String.format("Pessoa com ID %s não existe!", id));
    }
}
