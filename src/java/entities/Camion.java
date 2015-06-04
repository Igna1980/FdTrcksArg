/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gary
 */
@Entity
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByIdcamion", query = "SELECT c FROM Camion c WHERE c.camionPK.idcamion = :idcamion"),
    @NamedQuery(name = "Camion.findByUsuarioIdusuario", query = "SELECT c FROM Camion c WHERE c.camionPK.usuarioIdusuario = :usuarioIdusuario"),
    @NamedQuery(name = "Camion.findByNombre", query = "SELECT c FROM Camion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Camion.findByTipo", query = "SELECT c FROM Camion c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Camion.findByLogo", query = "SELECT c FROM Camion c WHERE c.logo = :logo"),
    @NamedQuery(name = "Camion.findByFoto1", query = "SELECT c FROM Camion c WHERE c.foto1 = :foto1"),
    @NamedQuery(name = "Camion.findByFoto2", query = "SELECT c FROM Camion c WHERE c.foto2 = :foto2"),
    @NamedQuery(name = "Camion.findByReports", query = "SELECT c FROM Camion c WHERE c.reports = :reports")})
public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CamionPK camionPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "logo")
    private String logo;
    @Column(name = "foto1")
    private String foto1;
    @Column(name = "foto2")
    private String foto2;
    @Column (name = "reports")
    private int reports;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camion")
    private Collection<Informacion> menuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camion")
    private Collection<Ubicacion> ubicacionCollection;

    public Camion() {
    }

    public Camion(CamionPK camionPK) {
        this.camionPK = camionPK;
    }

    public Camion(int idcamion, int usuarioIdusuario) {
        this.camionPK = new CamionPK(idcamion, usuarioIdusuario);
    }

    public CamionPK getCamionPK() {
        return camionPK;
    }

    public void setCamionPK(CamionPK camionPK) {
        this.camionPK = camionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Informacion> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Informacion> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @XmlTransient
    public Collection<Ubicacion> getUbicacionCollection() {
        return ubicacionCollection;
    }

    public void setUbicacionCollection(Collection<Ubicacion> ubicacionCollection) {
        this.ubicacionCollection = ubicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camionPK != null ? camionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.camionPK == null && other.camionPK != null) || (this.camionPK != null && !this.camionPK.equals(other.camionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Camion[ camionPK=" + camionPK + " ]";
    }
    
}
