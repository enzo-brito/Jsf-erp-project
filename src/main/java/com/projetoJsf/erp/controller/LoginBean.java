package com.projetoJsf.erp.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.projetoJsf.erp.model.Usuario;
import com.projetoJsf.erp.repository.Usuarios;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;

	@Inject
	private Usuarios usuarioRepository;

	private Usuario usuarioLogado;

	public String logar() {
		Usuario user = usuarioRepository.porEmail(email);
		if (user != null && BCrypt.checkpw(senha, user.getSenhaHash())) {
			usuarioLogado = user;
			return "GestaoEmpresa?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciais inválidas"));
		return null;
	}

	public String sair() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
}