package br.com.api.crud.controller.dto;

import br.com.api.crud.model.Cidade;

public class CidadeDto {

	private Long id;
	private String nome;
	private Integer codigo;
	private String uf;

	public CidadeDto() {

	}

	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.codigo = cidade.getCodigo();
		this.uf = cidade.getUf();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getUf() {
		return uf;
	}

	public Cidade toModel() {
		return new Cidade(id, codigo, nome, uf);
	}

}
