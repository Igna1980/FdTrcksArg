/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Camion;
import entities.CamionPK;
import entities.Informacion;
import entities.Ubicacion;
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
import javax.ws.rs.core.PathSegment;
import util.Imagen;
import util.ManipulateImage;

/**
 *
 * @author Gary
 */

@Path("entities.camion")
public class CamionFacadeREST extends AbstractFacade<Camion> {


    private CamionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idcamion=idcamionValue;usuarioIdusuario=usuarioIdusuarioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.CamionPK key = new entities.CamionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idcamion = map.get("idcamion");
        if (idcamion != null && !idcamion.isEmpty()) {
            key.setIdcamion(new java.lang.Integer(idcamion.get(0)));
        }
        java.util.List<String> usuarioIdusuario = map.get("usuarioIdusuario");
        if (usuarioIdusuario != null && !usuarioIdusuario.isEmpty()) {
            key.setUsuarioIdusuario(new java.lang.Integer(usuarioIdusuario.get(0)));
        }
        return key;
    }

    public CamionFacadeREST() {
        super(Camion.class);
    }

    @POST
    @Path("create")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Camion entity) {
        super.create(entity);
    }
    
    @POST
    @Path("manipulateImage")
    @Consumes(MediaType.APPLICATION_JSON)
    public void manipulateImage(Imagen entity) {
        ManipulateImage.convertStringtoImage(entity);
    }
    
    @PUT
    @Path("put")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Camion entity) {
            super.edit(entity);
    }

    @DELETE
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@QueryParam("id") Integer idCamion){
        for(Camion cam : findAll()){
            if(cam.getCamionPK().getIdcamion() == idCamion){
                super.remove(cam);
            }
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Camion find(@PathParam("id") PathSegment id) {
        entities.CamionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Camion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Camion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    
}
