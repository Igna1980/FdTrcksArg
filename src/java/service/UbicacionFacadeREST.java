/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Ubicacion;
import entities.UbicacionPK;
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

/**
 *
 * @author Gary
 */

@Path("entities.ubicacion")
public class UbicacionFacadeREST extends AbstractFacade<Ubicacion> {
    
    private static UbicacionFacadeREST _this;
        
    private UbicacionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idubicacion=idubicacionValue;camionIdcamion=camionIdcamionValue;camionUsuarioIdusuario=camionUsuarioIdusuarioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.UbicacionPK key = new entities.UbicacionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idubicacion = map.get("idubicacion");
        if (idubicacion != null && !idubicacion.isEmpty()) {
            key.setIdubicacion(new java.lang.Integer(idubicacion.get(0)));
        }
        java.util.List<String> camionIdcamion = map.get("camionIdcamion");
        if (camionIdcamion != null && !camionIdcamion.isEmpty()) {
            key.setCamionIdcamion(new java.lang.Integer(camionIdcamion.get(0)));
        }
        java.util.List<String> camionUsuarioIdusuario = map.get("camionUsuarioIdusuario");
        if (camionUsuarioIdusuario != null && !camionUsuarioIdusuario.isEmpty()) {
            key.setCamionUsuarioIdusuario(new java.lang.Integer(camionUsuarioIdusuario.get(0)));
        }
        return key;
    }

    public UbicacionFacadeREST() {
        super(Ubicacion.class);
        _this = this;
    }
    
    public static UbicacionFacadeREST getInstance(){
        return _this;
    }
    @POST
    @Path("create")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Ubicacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("put")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Ubicacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@QueryParam("id") Integer idUbicacion){
        for(Ubicacion ubi : findAll()){
            if(ubi.getUbicacionPK().getIdubicacion() == idUbicacion){
                super.remove(ubi);
            }
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ubicacion find(@PathParam("id") PathSegment id) {
        entities.UbicacionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ubicacion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ubicacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
}
