package br.com.api.crud.controller.dto;

import br.com.api.crud.model.PessoaFisica;

public class PessoaFisicaDto {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	
	public PessoaFisicaDto() {
		
	}
	
	public PessoaFisicaDto(PessoaFisica pessoaFisica) {
		this.id = pessoaFisica.getId();
		this.nome = pessoaFisica.getNome();
		this.cpf = pessoaFisica.getCpf();
		this.email = pessoaFisica.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}
	
//	public static List<PessoaFisicaDto> converter(List<PessoaFisica> pessoas) {
//		return pessoas.stream().map(PessoaFisicaDto::new).collect(Collectors.toList());
//	}

	public PessoaFisica toModel() {
		PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf, email);
		return pessoaFisica;
	}

}


