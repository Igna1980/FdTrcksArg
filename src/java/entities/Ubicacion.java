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
@Table(name = "ubicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u"),
    @NamedQuery(name = "Ubicacion.findByIdubicacion", query = "SELECT u FROM Ubicacion u WHERE u.ubicacionPK.idubicacion = :idubicacion"),
    @NamedQuery(name = "Ubicacion.findByLatitud", query = "SELECT u FROM Ubicacion u WHERE u.latitud = :latitud"),
    @NamedQuery(name = "Ubicacion.findByLongitud", query = "SELECT u FROM Ubicacion u WHERE u.longitud = :longitud"),
    @NamedQuery(name = "Ubicacion.findByCalle", query = "SELECT u FROM Ubicacion u WHERE u.calle = :calle"),
    @NamedQuery(name = "Ubicacion.findByAltura", query = "SELECT u FROM Ubicacion u WHERE u.altura = :altura"),
    @NamedQuery(name = "Ubicacion.findByBarrio", query = "SELECT u FROM Ubicacion u WHERE u.barrio = :barrio"),
    @NamedQuery(name = "Ubicacion.findByCiudad", query = "SELECT u FROM Ubicacion u WHERE u.ciudad = :ciudad"),
    @NamedQuery(name = "Ubicacion.findByPais", query = "SELECT u FROM Ubicacion u WHERE u.pais = :pais"),
    @NamedQuery(name = "Ubicacion.findByDesde", query = "SELECT u FROM Ubicacion u WHERE u.desde = :desde"),
    @NamedQuery(name = "Ubicacion.findByHasta", query = "SELECT u FROM Ubicacion u WHERE u.hasta = :hasta"),
    @NamedQuery(name = "Ubicacion.findByHorario", query = "SELECT u FROM Ubicacion u WHERE u.horario = :horario"),
    @NamedQuery(name = "Ubicacion.findByCamionIdcamion", query = "SELECT u FROM Ubicacion u WHERE u.ubicacionPK.camionIdcamion = :camionIdcamion"),
    @NamedQuery(name = "Ubicacion.findByCamionUsuarioIdusuario", query = "SELECT u FROM Ubicacion u WHERE u.ubicacionPK.camionUsuarioIdusuario = :camionUsuarioIdusuario")})
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UbicacionPK ubicacionPK;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "calle")
    private String calle;
    @Column(name = "altura")
    private String altura;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "pais")
    private String pais;
    @Column(name = "desde")
    private String desde;
    @Column(name = "hasta")
    private String hasta;
    @Column(name = "horario")
    private String horario;
    @JoinColumns({
        @JoinColumn(name = "camion_idcamion", referencedColumnName = "idcamion", insertable = false, updatable = false),
        @JoinColumn(name = "camion_usuario_idusuario", referencedColumnName = "usuario_idusuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Camion camion;

    public Ubicacion() {
    }

    public Ubicacion(UbicacionPK ubicacionPK) {
        this.ubicacionPK = ubicacionPK;
    }

    public Ubicacion(int idubicacion, int camionIdcamion, int camionUsuarioIdusuario) {
        this.ubicacionPK = new UbicacionPK(idubicacion, camionIdcamion, camionUsuarioIdusuario);
    }

    public UbicacionPK getUbicacionPK() {
        return ubicacionPK;
    }

    public void setUbicacionPK(UbicacionPK ubicacionPK) {
        this.ubicacionPK = ubicacionPK;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        hash += (ubicacionPK != null ? ubicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.ubicacionPK == null && other.ubicacionPK != null) || (this.ubicacionPK != null && !this.ubicacionPK.equals(other.ubicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ubicacion[ ubicacionPK=" + ubicacionPK + " ]";
    }
    
}
