package br.com.api.crud.config.validacao;

public class ErroDeDto {
	
	private String campo;
	private String erro;

	public ErroDeDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
