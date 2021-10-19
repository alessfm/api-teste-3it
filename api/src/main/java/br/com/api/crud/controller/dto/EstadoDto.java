package br.com.api.crud.controller.dto;

import br.com.api.crud.model.Estado;

public class EstadoDto {

	private Long id;
	private String nome;
	private Integer codigoUf;
	private String uf;

	private String regiao;

	public EstadoDto() {

	}

	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.codigoUf = estado.getCodigoUf();
		this.uf = estado.getUf();
		this.regiao = estado.getRegiao();
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigoUf() {
		return codigoUf;
	}

	public void setCodigoUf(Integer codigoUf) {
		this.codigoUf = codigoUf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Estado toModel() {
		Estado estado = new Estado(nome);
		return estado;
	}

}
