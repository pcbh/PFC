/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import java.io.Serializable;
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
@Table(name = "ofertas", catalog = "Usuario", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idUsuario"}),
    @UniqueConstraint(columnNames = {"idOferta"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o"),
    @NamedQuery(name = "Ofertas.findByIdOferta", query = "SELECT o FROM Ofertas o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Ofertas.findByTitulo", query = "SELECT o FROM Ofertas o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Ofertas.findByDetalles", query = "SELECT o FROM Ofertas o WHERE o.detalles = :detalles"),
    @NamedQuery(name = "Ofertas.findByDemandantes", query = "SELECT o FROM Ofertas o WHERE o.demandantes = :demandantes")})
public class Ofertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOferta", nullable = false)
    private Integer idOferta;
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
    @Size(max = 50)
    @Column(name = "demandantes", length = 50)
    private String demandantes;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(optional = false)
    private Usuarios idUsuario;

    public Ofertas() {
    }

    public Ofertas(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Ofertas(Integer idOferta, String titulo, String detalles) {
        this.idOferta = idOferta;
        this.titulo = titulo;
        this.detalles = detalles;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
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

    public String getDemandantes() {
        return demandantes;
    }

    public void setDemandantes(String demandantes) {
        this.demandantes = demandantes;
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
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBs.Ofertas[ idOferta=" + idOferta + " ]";
    }
    
}
