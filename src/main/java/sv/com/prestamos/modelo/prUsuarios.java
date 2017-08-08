/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prUsuarios.findAll", query = "SELECT p FROM prUsuarios p"),
    @NamedQuery(name = "prUsuarios.findByIdUsuario", query = "SELECT p FROM prUsuarios p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "prUsuarios.findByUsuario", query = "SELECT p FROM prUsuarios p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "prUsuarios.findByPassword", query = "SELECT p FROM prUsuarios p WHERE p.password = :password"),
    @NamedQuery(name = "prUsuarios.findByActivo", query = "SELECT p FROM prUsuarios p WHERE p.activo = :activo")})
public class prUsuarios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_usuario")
    private String idUsuario;
    
    @Size(max = 25)
    @Column(name = "usuario")
    private String usuario;
    
    @Size(max = 25)
    @Column(name = "password")
    private String password;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private prRoles Roles;
    
    @OneToMany(mappedBy = "Usuario")
    private List<prLogTransacciones> ListaLogTransacciones;

    public prUsuarios() {
    }

    public prUsuarios(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public prRoles getIdRol() {
        return Roles;
    }

    public void setIdRol(prRoles Roles) {
        this.Roles = Roles;
    }

    @XmlTransient
    public List<prLogTransacciones> getPrLogTransaccionesList() {
        return ListaLogTransacciones;
    }

    public void setPrLogTransaccionesList(List<prLogTransacciones> ListaLogTransacciones) {
        this.ListaLogTransacciones = ListaLogTransacciones;
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
        if (!(object instanceof prUsuarios)) {
            return false;
        }
        prUsuarios other = (prUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
