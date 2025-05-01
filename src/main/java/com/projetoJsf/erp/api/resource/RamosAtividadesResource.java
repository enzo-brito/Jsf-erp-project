package com.projetoJsf.erp.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetoJsf.erp.model.RamoAtividade;
import com.projetoJsf.erp.repository.RamoAtividades;
import com.projetoJsf.erp.service.CadastroRamoAtividadeService;
import com.projetoJsf.erp.util.Transacional;

@Path("/ramoatividades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RamosAtividadesResource {

	@Inject
	private RamoAtividades ramoAtividades;

	@Inject
	private CadastroRamoAtividadeService cadastroRamoAtividadeService;

	@GET
	public List<RamoAtividade> todas() {
		return ramoAtividades.todas();
	}

	@GET
	@Path("/{id}")
	public Response porId(@PathParam("id") Long id) {
		RamoAtividade ramo = ramoAtividades.porId(id);
		if (ramo != null) {
			return Response.ok(ramo).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/pesquisar")
	public List<RamoAtividade> pesquisar(@QueryParam("descricao") String descricao) {
		return ramoAtividades.pesquisar(descricao);
	}

	@POST
	public Response criar(RamoAtividade ramoAtividade) {
		cadastroRamoAtividadeService.Salvar(ramoAtividade);
		return Response.status(Response.Status.CREATED).build();
	}

	@Transacional
	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, RamoAtividade ramoAtividade) {
		RamoAtividade existente = ramoAtividades.porId(id);
		if (existente == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		ramoAtividade.setId(id);
		cadastroRamoAtividadeService.Salvar(ramoAtividade);
		return Response.ok().build();
	}

	@Transacional
	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") Long id) {
		RamoAtividade existente = ramoAtividades.porId(id);
		if (existente == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		cadastroRamoAtividadeService.Excluir(existente);
		return Response.noContent().build();
	}
}
