/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "demandas", catalog = "Usuario", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idUsuario"}),
    @UniqueConstraint(columnNames = {"idDemanda"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandas.findAll", query = "SELECT d FROM Demandas d"),
    @NamedQuery(name = "Demandas.findByIdDemanda", query = "SELECT d FROM Demandas d WHERE d.idDemanda = :idDemanda"),
    @NamedQuery(name = "Demandas.findByTitulo", query = "SELECT d FROM Demandas d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "Demandas.findByDetalles", query = "SELECT d FROM Demandas d WHERE d.detalles = :detalles"),
    @NamedQuery(name = "Demandas.findByOfertantes", query = "SELECT d FROM Demandas d WHERE d.ofertantes = :ofertantes")})
public class Demandas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDemanda", nullable = false)
    private Integer idDemanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "detalles", nullable = false, length = 1000)
    private String detalles;
    @Column(name = "ofertantes")
    private BigInteger ofertantes;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(optional = false)
    private Usuarios idUsuario;

    public Demandas() {
    }

    public Demandas(Integer idDemanda) {
        this.idDemanda = idDemanda;
    }

    public Demandas(Integer idDemanda, String titulo, String detalles) {
        this.idDemanda = idDemanda;
        this.titulo = titulo;
        this.detalles = detalles;
    }

    public Integer getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Integer idDemanda) {
        this.idDemanda = idDemanda;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public BigInteger getOfertantes() {
        return ofertantes;
    }

    public void setOfertantes(BigInteger ofertantes) {
        this.ofertantes = ofertantes;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemanda != null ? idDemanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandas)) {
            return false;
        }
        Demandas other = (Demandas) object;
        if ((this.idDemanda == null && other.idDemanda != null) || (this.idDemanda != null && !this.idDemanda.equals(other.idDemanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBs.Demandas[ idDemanda=" + idDemanda + " ]";
    }
    
}
