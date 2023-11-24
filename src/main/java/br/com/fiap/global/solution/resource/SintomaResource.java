package br.com.fiap.global.solution.resource;

import br.com.fiap.global.solution.beans.Sintoma;
import br.com.fiap.global.solution.service.SintomaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/sintomas")
public class SintomaResource {

    private final SintomaService service = new SintomaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSintomas() {
        try {
            List<Sintoma> sintomas = service.findAll();
            return Response.ok(sintomas).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSintomaById(@PathParam("id") int id) {
        try {
            Sintoma sintoma = service.findById(id);

            if (sintoma != null) {
                return Response.ok(sintoma).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
