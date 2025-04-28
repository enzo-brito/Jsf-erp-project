package com.projetoJsf.erp.model;

public enum TipoEmpresa {

	MEI("Microempreendendor Individual"), EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"), SA("Sociedade Anônima");

	private String descricao;

	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
