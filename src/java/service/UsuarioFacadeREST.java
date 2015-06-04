/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Camion;
import entities.Usuario;
import java.util.List;
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

/**
 *
 * @author Gary
 */

@Path("entities.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@QueryParam("id") Integer idUsuario){
        for(Usuario usu : findAll()){
            if(usu.getIdusuario() == idUsuario){
                super.remove(usu);
            }
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
}
