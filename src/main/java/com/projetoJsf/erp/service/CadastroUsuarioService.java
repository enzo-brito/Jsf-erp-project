package com.projetoJsf.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projetoJsf.erp.model.Usuario;
import com.projetoJsf.erp.repository.Usuarios;
import com.projetoJsf.erp.util.Transacional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	Usuarios usuarios;
	
	@Transacional
	public void salvar(Usuario usuario) {
		usuarios.guardar(usuario);
	}
	
	@Transacional
	public void Excluir(Usuario usuario) {
		usuarios.remover(usuario);
	}
	

}
