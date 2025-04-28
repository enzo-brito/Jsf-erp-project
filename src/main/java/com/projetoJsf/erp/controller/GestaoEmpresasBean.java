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

import com.projetoJsf.erp.model.Empresa;
import com.projetoJsf.erp.model.RamoAtividade;
import com.projetoJsf.erp.model.TipoEmpresa;
import com.projetoJsf.erp.repository.Empresas;
import com.projetoJsf.erp.repository.RamoAtividades;
import com.projetoJsf.erp.service.CadastroEmpresaService;
import com.projetoJsf.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Inject
	private FacesMessages messages;

	@Inject
	private RamoAtividades ramoAtividades;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	private Converter ramoAtividadeConverter;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Empresa empresa;

	@PostConstruct
	public void init() {
		listaEmpresas = empresas.todas();
	}

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void prepararEdicao() {
		if (empresa != null) {
			ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade()));
		}
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		
		atualizarRegistros();

		messages.info("Empresa salva com Sucesso!!");

		PrimeFaces.current().ajax().update(Arrays.asList("frm:empresasDataTable", "frm:messages"));

	}

	public void excluir() {
		cadastroEmpresaService.Excluir(empresa);

		empresa = null;
		
		atualizarRegistros();
		
		messages.info("Empresa Excluida Com Sucesso!!");

	}

	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		if (listaEmpresas.isEmpty()) {
			messages.info("Sua Consulta não retornou Registros");
		}
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividade = ramoAtividades.pesquisar(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividade);

		return listaRamoAtividade;
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
	
	

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isEmpresaSelecionada() {
		return empresa != null && empresa.getId() != null;
	}

}
