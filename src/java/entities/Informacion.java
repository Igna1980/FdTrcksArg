/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gary
 */
@Entity
@Table(name = "informacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informacion.findAll", query = "SELECT m FROM Informacion m"),
    @NamedQuery(name = "Informacion.findByIdinformacion", query = "SELECT m FROM Informacion m WHERE m.informacionPK.idinformacion = :idinformacion"),    
    @NamedQuery(name = "Informacion.findByDescripcion", query = "SELECT i FROM Informacion i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Informacion.findByMenu", query = "SELECT i FROM Informacion i WHERE i.menu = :menu"),
    @NamedQuery(name = "Informacion.findByContacto", query = "SELECT i FROM Informacion i WHERE i.contacto = :contacto"),
    @NamedQuery(name = "Informacion.findByInformacion", query = "SELECT i FROM Informacion i WHERE i.informacion = :informacion"),
    @NamedQuery(name = "Informacion.findByWeb", query = "SELECT i FROM Informacion i WHERE i.web = :web"),
    @NamedQuery(name = "Informacion.findByFacebook", query = "SELECT i FROM Informacion i WHERE i.facebook = :facebook"),
    @NamedQuery(name = "Informacion.findByTwitter", query = "SELECT i FROM Informacion i WHERE i.twitter = :twitter"),
    @NamedQuery(name = "Informacion.findByInstagram", query = "SELECT i FROM Informacion i WHERE i.instagram = :instagram"),
    @NamedQuery(name = "Informacion.findByCamionIdcamion", query = "SELECT m FROM Informacion m WHERE m.informacionPK.camionIdcamion = :camionIdcamion"),
    @NamedQuery(name = "Informacion.findByCamionUsuarioIdusuario", query = "SELECT m FROM Informacion m WHERE m.informacionPK.camionUsuarioIdusuario = :camionUsuarioIdusuario")})
public class Informacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InformacionPK informacionPK;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "menu")
    private String menu;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "informacion")
    private String informacion;
    @Column(name = "web")
    private String web;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;
    @Column(name = "instagram")
    private String instagram;
    @JoinColumns({
        @JoinColumn(name = "camion_idcamion", referencedColumnName = "idcamion", insertable = false, updatable = false),
        @JoinColumn(name = "camion_usuario_idusuario", referencedColumnName = "usuario_idusuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Camion camion;

    public Informacion() {
    }

    public Informacion(InformacionPK informacionPK) {
        this.informacionPK = informacionPK;
    }

    public Informacion(int idinformacion, int camionIdcamion, int camionUsuarioIdusuario) {
        this.informacionPK = new InformacionPK(idinformacion, camionIdcamion, camionUsuarioIdusuario);
    }

    public InformacionPK getInformacionPK() {
        return informacionPK;
    }

    public void setInformacionPK(InformacionPK informacionPK) {
        this.informacionPK = informacionPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informacionPK != null ? informacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informacion)) {
            return false;
        }
        Informacion other = (Informacion) object;
        if ((this.informacionPK == null && other.informacionPK != null) || (this.informacionPK != null && !this.informacionPK.equals(other.informacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Informacion[ informacionPK=" + informacionPK + " ]";
    }
    
}
