package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Tratamento;
import br.com.fiap.global.solution.service.TratamentoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tratamentos")
public class TratamentoResource {

    private final TratamentoService service = new TratamentoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tratamento> index() throws ClassNotFoundException {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) throws ClassNotFoundException {
        var tratamento = service.findById(id);
        if (tratamento == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(tratamento).build();
    }
}
