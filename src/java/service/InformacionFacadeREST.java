/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Informacion;
import entities.InformacionPK;
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

@Path("entities.informacion")
public class InformacionFacadeREST extends AbstractFacade<Informacion> {
    
    private static InformacionFacadeREST _this;
    
    private InformacionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idinformacion=idinformacionValue;camionIdcamion=camionIdcamionValue;camionUsuarioIdusuario=camionUsuarioIdusuarioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.InformacionPK key = new entities.InformacionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idinformacion = map.get("idinformacion");
        if (idinformacion != null && !idinformacion.isEmpty()) {
            key.setIdinformacion(new java.lang.Integer(idinformacion.get(0)));
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

    public InformacionFacadeREST() {
        super(Informacion.class);
        _this = this;
    }
    
    public static InformacionFacadeREST getInstance(){
        return _this;
    }
    
    @POST
    @Path("create")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Informacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("put")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Informacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@QueryParam("id") Integer idInforamcion){
        for(Informacion info : findAll()){
            if(info.getInformacionPK().getIdinformacion() == idInforamcion){
                super.remove(info);
            }
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Informacion find(@PathParam("id") PathSegment id) {
        entities.InformacionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Informacion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Informacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }   
}

