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

import com.projetoJsf.erp.model.Empresa;
import com.projetoJsf.erp.model.TipoEmpresa;
import com.projetoJsf.erp.repository.Empresas;
import com.projetoJsf.erp.util.Transacional;

@Path("/empresas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaResource {

    @Inject
    private Empresas empresas;

    @GET
    public List<Empresa> todas() {
        return empresas.todas();
    }

    @GET
    @Path("/pesquisar")
    public List<Empresa> pesquisar(@QueryParam("nome") String nome) {
        return empresas.pesquisar(nome);
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Empresa empresa = empresas.porId(id);
        if (empresa != null) {
            return Response.ok(empresa).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Transacional
    @POST
    public Response criar(Empresa empresa) {
        Empresa nova = empresas.guardar(empresa);
        return Response.status(Response.Status.CREATED).entity(nova).build();
    }
    
    @Transacional
    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Empresa empresa) {
        Empresa existente = empresas.porId(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        empresa.setId(id);
        Empresa atualizada = empresas.guardar(empresa);
        return Response.ok(atualizada).build();
    }
    
    @Transacional
    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        Empresa empresa = empresas.porId(id);
        if (empresa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        empresas.remover(empresa);
        return Response.noContent().build();
    }

    @GET
    @Path("/total-por-tipo")
    public Response totalPorTipo(@QueryParam("tipo") String tipoStr) {
        try {
            TipoEmpresa tipo = TipoEmpresa.valueOf(tipoStr);
            long total = empresas.totalPorTipo(tipo);
            return Response.ok(total).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Tipo de empresa inválido.").build();
        }
    }

    @GET
    @Path("/total-por-ramo")
    public List<Object[]> totalPorRamo() {
        return empresas.totalPorRamo();
    }
}
