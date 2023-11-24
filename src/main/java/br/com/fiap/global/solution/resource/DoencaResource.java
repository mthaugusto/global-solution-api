package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Doenca;
import br.com.fiap.global.solution.service.DoencaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("doencas")
public class DoencaResource {

    private final DoencaService service = new DoencaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doenca> index() throws ClassNotFoundException {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) throws ClassNotFoundException {
        var doenca = service.findById(id);
        if (doenca == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(doenca).build();
    }

}