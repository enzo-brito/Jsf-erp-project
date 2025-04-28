package com.projetoJsf.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projetoJsf.erp.model.RamoAtividade;
import com.projetoJsf.erp.repository.RamoAtividades;
import com.projetoJsf.erp.util.Transacional;

public class CadastroRamoAtividadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	RamoAtividades ramoAtividades;
	
	@Transacional
	public void Salvar(RamoAtividade ramoAtividade) {
		ramoAtividades.guardar(ramoAtividade);
	}
	
	@Transacional
	public void Excluir(RamoAtividade ramoAtividade) {
		ramoAtividades.remover(ramoAtividade);
	}

}
