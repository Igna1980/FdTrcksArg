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
public class CamionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idcamion")
    private int idcamion;
    @Basic(optional = false)
    @Column(name = "usuario_idusuario")
    private int usuarioIdusuario;

    public CamionPK() {
    }

    public CamionPK(int idcamion, int usuarioIdusuario) {
        this.idcamion = idcamion;
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getIdcamion() {
        return idcamion;
    }

    public void setIdcamion(int idcamion) {
        this.idcamion = idcamion;
    }

    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcamion;
        hash += (int) usuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CamionPK)) {
            return false;
        }
        CamionPK other = (CamionPK) object;
        if (this.idcamion != other.idcamion) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CamionPK[ idcamion=" + idcamion + ", usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
