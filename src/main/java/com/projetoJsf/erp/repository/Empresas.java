package com.projetoJsf.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projetoJsf.erp.model.Empresa;
import com.projetoJsf.erp.model.TipoEmpresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Empresas() {
	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where razaoSocial like :razaoSocial",
				Empresa.class);
		query.setParameter("razaoSocial", nome + "%");
		return query.getResultList();
	}

	public List<Empresa> todas() {
		 return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	public long totalPorTipo(TipoEmpresa tipo) {
	    String jpql = "select count(e) from Empresa e where e.tipo = :tipo";
	    return manager.createQuery(jpql, Long.class)
	            .setParameter("tipo", tipo)
	            .getSingleResult();
	}

	public List<Object[]> totalPorRamo() {
	    String jpql = "select e.ramoAtividade.descricao, count(e) from Empresa e group by e.ramoAtividade.descricao";
	    return manager.createQuery(jpql, Object[].class).getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}
