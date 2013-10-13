/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "public_casadas", catalog = "Usuario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicCasadas.findAll", query = "SELECT p FROM PublicCasadas p"),
    @NamedQuery(name = "PublicCasadas.findByIdPublicacion", query = "SELECT p FROM PublicCasadas p WHERE p.idPublicacion = :idPublicacion"),
    @NamedQuery(name = "PublicCasadas.findByIdUsuario", query = "SELECT p FROM PublicCasadas p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "PublicCasadas.findByReputacion", query = "SELECT p FROM PublicCasadas p WHERE p.reputacion = :reputacion"),
    @NamedQuery(name = "PublicCasadas.findByValorsubasta", query = "SELECT p FROM PublicCasadas p WHERE p.valorsubasta = :valorsubasta"),
    @NamedQuery(name = "PublicCasadas.findByIdUsuarioPub", query = "SELECT p FROM PublicCasadas p WHERE p.idUsuarioPub = :idUsuarioPub"),
    @NamedQuery(name = "PublicCasadas.findByFechaCasacion", query = "SELECT p FROM PublicCasadas p WHERE p.fechaCasacion = :fechaCasacion"),
    @NamedQuery(name = "PublicCasadas.findByCerrada", query = "SELECT p FROM PublicCasadas p WHERE p.cerrada = :cerrada")})
public class PublicCasadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPublicacion", nullable = false)
    private Integer idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reputacion", nullable = false)
    private int reputacion;
    @Column(name = "Valor_subasta")
    private Integer valorsubasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioPub", nullable = false)
    private int idUsuarioPub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_casacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCasacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cerrada", nullable = false)
    private boolean cerrada;

    public PublicCasadas() {
    }

    public PublicCasadas(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public PublicCasadas(Integer idPublicacion, int idUsuario, int reputacion, int idUsuarioPub, Date fechaCasacion, boolean cerrada) {
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.reputacion = reputacion;
        this.idUsuarioPub = idUsuarioPub;
        this.fechaCasacion = fechaCasacion;
        this.cerrada = cerrada;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public Integer getValorsubasta() {
        return valorsubasta;
    }

    public void setValorsubasta(Integer valorsubasta) {
        this.valorsubasta = valorsubasta;
    }

    public int getIdUsuarioPub() {
        return idUsuarioPub;
    }

    public void setIdUsuarioPub(int idUsuarioPub) {
        this.idUsuarioPub = idUsuarioPub;
    }

    public Date getFechaCasacion() {
        return fechaCasacion;
    }

    public void setFechaCasacion(Date fechaCasacion) {
        this.fechaCasacion = fechaCasacion;
    }

    public boolean getCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicCasadas)) {
            return false;
        }
        PublicCasadas other = (PublicCasadas) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBs.PublicCasadas[ idPublicacion=" + idPublicacion + " ]";
    }
    
}
