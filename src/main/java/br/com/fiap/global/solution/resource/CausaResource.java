package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Causa;
import br.com.fiap.global.solution.beans.Cliente;
import br.com.fiap.global.solution.service.CausaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/causas")
public class CausaResource {

    private final CausaService service = new CausaService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Causa> index() throws ClassNotFoundException {
		return service.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) throws ClassNotFoundException {
		var causa = service.findById(id);
		if (causa == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(causa).build();
		}
   }

