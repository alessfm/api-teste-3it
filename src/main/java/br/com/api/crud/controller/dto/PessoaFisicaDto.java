package br.com.api.crud.controller.dto;

import br.com.api.crud.model.PessoaFisica;

public class PessoaFisicaDto {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private CidadeDto cidade;
	private EstadoDto estado;
	
	public PessoaFisicaDto() {
		
	}
	
	public PessoaFisicaDto(PessoaFisica pessoaFisica) {
		this.id = pessoaFisica.getId();
		this.nome = pessoaFisica.getNome();
		this.cpf = pessoaFisica.getCpf();
		this.email = pessoaFisica.getEmail();
		this.cidade = new CidadeDto(pessoaFisica.getCidade());
		this.estado = new EstadoDto(pessoaFisica.getEstado());
		
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
	

	public CidadeDto getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDto cidade) {
		this.cidade = cidade;
	}

	
	public EstadoDto getEstado() {
		return estado;
	}

	public void setEstado(EstadoDto estado) {
		this.estado = estado;
	}

	public PessoaFisica toModel() {
		PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf, email,  cidade.toModel());
		return pessoaFisica;
	}


}


