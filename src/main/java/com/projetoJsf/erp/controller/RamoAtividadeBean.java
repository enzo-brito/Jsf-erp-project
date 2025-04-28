package com.projetoJsf.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.projetoJsf.erp.model.RamoAtividade;
import com.projetoJsf.erp.repository.RamoAtividades;
import com.projetoJsf.erp.service.CadastroRamoAtividadeService;
import com.projetoJsf.erp.util.FacesMessages;

@Named
@ViewScoped
public class RamoAtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages messages;

	@Inject
	private RamoAtividades ramoAtividades;

	@Inject
	private CadastroRamoAtividadeService cadastroRamoAtividadeService;
	
	private Converter ramoAtividadeConverter;


	private List<RamoAtividade> listaRamoAtividades;
	private String termoPesquisa;
	private RamoAtividade ramoAtividade;

	@PostConstruct
	public void init() {
		listaRamoAtividades = ramoAtividades.todas();
	}

	public void prepararNovoRamoAtividade() {
		ramoAtividade = new RamoAtividade();

	}
	
	public void prepararEdicao() {
		if (ramoAtividade != null) {
			ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(ramoAtividade));
		}
	}

	public void salvar() {
		cadastroRamoAtividadeService.Salvar(ramoAtividade);
		
		atualizarRegistros();
		
		messages.info("Ramo de Atividade Salvo com Sucesso!");
		
		PrimeFaces.current().ajax().update(Arrays.asList("frm:RamoAtividadeDataTable", "frm:messages"));
	}
	
	public void excluir() {
		cadastroRamoAtividadeService.Excluir(ramoAtividade);
		
		ramoAtividade = null;
		
		atualizarRegistros();
		
		messages.info("Empresa Exclida Com Sucesso!");
	}

	public void pesquisar() {
		listaRamoAtividades = ramoAtividades.pesquisar(termoPesquisa);
		if (listaRamoAtividades.isEmpty()) {
			messages.info("Sua Consulta não retornou Registros");
		}
	}

	private void atualizarRegistros() {
		if (jaHouvePesquisa()) {
			pesquisar();
		} else {
			init();
		}
	}

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}

	public List<RamoAtividade> getListaRamoAtividades() {
		return listaRamoAtividades;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public boolean isRamoAtividadeSelecionado() {
		return ramoAtividade != null && ramoAtividade.getId() != null;
	}

}
