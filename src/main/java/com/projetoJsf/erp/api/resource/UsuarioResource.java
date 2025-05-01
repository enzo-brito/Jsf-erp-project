package com.projetoJsf.erp.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mindrot.jbcrypt.BCrypt;

import com.projetoJsf.erp.api.config.JwtUtil;
import com.projetoJsf.erp.model.Usuario;
import com.projetoJsf.erp.repository.Usuarios;
import com.projetoJsf.erp.service.CadastroUsuarioService;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	@Inject
	private Usuarios usuarios;

	@POST
	@Path("/registrar")
	public Response registrar(Usuario usuario) {
		if (usuarios.porEmail(usuario.getEmail()) != null) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		usuario.setSenhaHash(BCrypt.hashpw(usuario.getSenhaHash(), BCrypt.gensalt()));
		cadastroUsuarioService.salvar(usuario);
		return Response.status(Response.Status.CREATED).build();
	}

	@POST
	@Path("/login")
	public Response login(Credenciais cred) {
		Usuario user = usuarios.porEmail(cred.getUsuario());
		if (user != null && BCrypt.checkpw(cred.getSenha(), user.getSenhaHash())) {
			String token = JwtUtil.gerarToken(user.getEmail());
			return Response.ok("{\"token\":\"" + token + "\"}").build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}

	public static class Credenciais {
		private String usuario;
		private String senha;

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
	}
}
