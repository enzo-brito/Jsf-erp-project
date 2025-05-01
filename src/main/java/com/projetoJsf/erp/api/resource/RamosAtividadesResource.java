package com.projetoJsf.erp.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.projetoJsf.erp.model.RamoAtividade;
import com.projetoJsf.erp.repository.RamoAtividades;

@Path("/ramoatividades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RamosAtividadesResource {

	@Inject
	private RamoAtividades ramoAtividades;

	@GET
	public List<RamoAtividade> todas() {
		return ramoAtividades.todas();
	}



}
