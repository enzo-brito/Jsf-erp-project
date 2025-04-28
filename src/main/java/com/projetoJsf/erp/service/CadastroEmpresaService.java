package com.projetoJsf.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projetoJsf.erp.model.Empresa;
import com.projetoJsf.erp.repository.Empresas;
import com.projetoJsf.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}

	@Transacional
	public void Excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
