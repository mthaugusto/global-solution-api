package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Imagem;
import br.com.fiap.global.solution.service.ImagemService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/imagens")
public class ImagemResource {

    private final ImagemService service = new ImagemService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Imagem> index() throws ClassNotFoundException {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int idImagem) throws ClassNotFoundException {
        var imagem = service.findById(idImagem);
        if (imagem == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(imagem).build();
    }
}