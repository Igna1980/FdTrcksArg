/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gary
 */
@Embeddable
public class UbicacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idubicacion")
    private int idubicacion;
    @Basic(optional = false)
    @Column(name = "camion_idcamion")
    private int camionIdcamion;
    @Basic(optional = false)
    @Column(name = "camion_usuario_idusuario")
    private int camionUsuarioIdusuario;

    public UbicacionPK() {
    }

    public UbicacionPK(int idubicacion, int camionIdcamion, int camionUsuarioIdusuario) {
        this.idubicacion = idubicacion;
        this.camionIdcamion = camionIdcamion;
        this.camionUsuarioIdusuario = camionUsuarioIdusuario;
    }

    public int getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(int idubicacion) {
        this.idubicacion = idubicacion;
    }

    public int getCamionIdcamion() {
        return camionIdcamion;
    }

    public void setCamionIdcamion(int camionIdcamion) {
        this.camionIdcamion = camionIdcamion;
    }

    public int getCamionUsuarioIdusuario() {
        return camionUsuarioIdusuario;
    }

    public void setCamionUsuarioIdusuario(int camionUsuarioIdusuario) {
        this.camionUsuarioIdusuario = camionUsuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idubicacion;
        hash += (int) camionIdcamion;
        hash += (int) camionUsuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionPK)) {
            return false;
        }
        UbicacionPK other = (UbicacionPK) object;
        if (this.idubicacion != other.idubicacion) {
            return false;
        }
        if (this.camionIdcamion != other.camionIdcamion) {
            return false;
        }
        if (this.camionUsuarioIdusuario != other.camionUsuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UbicacionPK[ idubicacion=" + idubicacion + ", camionIdcamion=" + camionIdcamion + ", camionUsuarioIdusuario=" + camionUsuarioIdusuario + " ]";
    }
    
}
