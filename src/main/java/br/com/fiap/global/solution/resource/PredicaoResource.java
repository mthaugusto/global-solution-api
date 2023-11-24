package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Predicao;
import br.com.fiap.global.solution.service.PredicaoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/predicoes")
public class PredicaoResource {

    private final PredicaoService service = new PredicaoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Predicao> index() throws ClassNotFoundException {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int idPredicao) throws ClassNotFoundException {
        var predicao = service.findById(idPredicao);
        if (predicao == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(predicao).build();
    }
 }