package com.projetoJsf.erp.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.projetoJsf.erp.model.Empresa;
import com.projetoJsf.erp.repository.Empresas;

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


}
