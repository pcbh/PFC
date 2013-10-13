/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "usuarios", catalog = "Usuario", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idUsuario"}),
    @UniqueConstraint(columnNames = {"mail"}),
    @UniqueConstraint(columnNames = {"alias"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByAlias", query = "SELECT u FROM Usuarios u WHERE u.alias = :alias"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByMail", query = "SELECT u FROM Usuarios u WHERE u.mail = :mail"),
    @NamedQuery(name = "Usuarios.findByReputacion", query = "SELECT u FROM Usuarios u WHERE u.reputacion = :reputacion"),
    @NamedQuery(name = "Usuarios.findByCiudad", query = "SELECT u FROM Usuarios u WHERE u.ciudad = :ciudad"),
    @NamedQuery(name = "Usuarios.findByCalle", query = "SELECT u FROM Usuarios u WHERE u.calle = :calle"),
    @NamedQuery(name = "Usuarios.findByCp", query = "SELECT u FROM Usuarios u WHERE u.cp = :cp"),
    @NamedQuery(name = "Usuarios.findByAnyoNacimiento", query = "SELECT u FROM Usuarios u WHERE u.anyoNacimiento = :anyoNacimiento")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "alias", nullable = false, length = 45)
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mail", nullable = false, length = 45)
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reputacion", nullable = false)
    private int reputacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ciudad", nullable = false, length = 20)
    private String ciudad;
    @Size(max = 30)
    @Column(name = "calle", length = 30)
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CP", nullable = false, length = 5)
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anyo_Nacimiento", nullable = false)
    private int anyoNacimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Ofertas ofertas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Demandas demandas;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String alias, String nombre, String password, String mail, 
            int reputacion, String ciudad, String cp, int anyoNacimiento) {
        this.idUsuario = idUsuario;
        this.alias = alias;
        this.nombre = nombre;
        this.password = password;
        this.mail = mail;
        this.reputacion = reputacion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.anyoNacimiento = anyoNacimiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    public Ofertas getOfertas() {
        return ofertas;
    }

    public void setOfertas(Ofertas ofertas) {
        this.ofertas = ofertas;
    }

    public Demandas getDemandas() {
        return demandas;
    }

    public void setDemandas(Demandas demandas) {
        this.demandas = demandas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBs.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
