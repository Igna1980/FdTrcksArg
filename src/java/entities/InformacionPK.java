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
public class InformacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idinformacion")
    private int idinformacion;
    @Basic(optional = false)
    @Column(name = "camion_idcamion")
    private int camionIdcamion;
    @Basic(optional = false)
    @Column(name = "camion_usuario_idusuario")
    private int camionUsuarioIdusuario;

    public InformacionPK() {
    }

    public InformacionPK(int idinformacion, int camionIdcamion, int camionUsuarioIdusuario) {
        this.idinformacion = idinformacion;
        this.camionIdcamion = camionIdcamion;
        this.camionUsuarioIdusuario = camionUsuarioIdusuario;
    }

    public int getIdinformacion() {
        return idinformacion;
    }

    public void setIdinformacion(int idinformacion) {
        this.idinformacion = idinformacion;
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
        hash += (int) idinformacion;
        hash += (int) camionIdcamion;
        hash += (int) camionUsuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionPK)) {
            return false;
        }
        InformacionPK other = (InformacionPK) object;
        if (this.idinformacion != other.idinformacion) {
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
        return "entities.InformacionPK[ idinformacion=" + idinformacion + ", camionIdcamion=" + camionIdcamion + ", camionUsuarioIdusuario=" + camionUsuarioIdusuario + " ]";
    }
    
}
