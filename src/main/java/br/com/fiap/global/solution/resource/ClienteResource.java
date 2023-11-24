package br.com.fiap.global.solution.resource;

import java.util.List;

import br.com.fiap.global.solution.beans.Cliente;
import br.com.fiap.global.solution.service.ClienteService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClienteResource {

	private final ClienteService service = new ClienteService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> index() throws ClassNotFoundException {
		return service.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) throws ClassNotFoundException {
		var cliente = service.findById(id);
		if (cliente == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(cliente).build();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Cliente cliente) throws ClassNotFoundException {
		if (!service.create(cliente)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(cliente).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Cliente cliente) throws ClassNotFoundException {
		var clienteEncontrado = service.findById(id);
		if (clienteEncontrado == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		if (!service.update(cliente))
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(cliente).build();
	}
	
}
