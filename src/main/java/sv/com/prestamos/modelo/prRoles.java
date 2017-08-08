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
@Table(name = "pr_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prRoles.findAll", query = "SELECT p FROM prRoles p"),
    @NamedQuery(name = "prRoles.findByIdRol", query = "SELECT p FROM prRoles p WHERE p.idRol = :idRol"),
    @NamedQuery(name = "prRoles.findByDescripcion", query = "SELECT p FROM prRoles p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "prRoles.findByActivo", query = "SELECT p FROM prRoles p WHERE p.activo = :activo")})
public class prRoles implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_rol")
    private String idRol;
    
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @OneToMany(mappedBy = "Roles")
    private List<prRolesXMenu> ListaRolesXMenu;
    
    @OneToMany(mappedBy = "Roles")
    private List<prUsuarios> ListaUsuarios;

    public prRoles() {
    }

    public prRoles(String idRol) {
        this.idRol = idRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<prRolesXMenu> getPrRolesXMenuList() {
        return ListaRolesXMenu;
    }

    public void setPrRolesXMenuList(List<prRolesXMenu> ListaRolesXMenu) {
        this.ListaRolesXMenu = ListaRolesXMenu;
    }

    @XmlTransient
    public List<prUsuarios> getPrUsuariosList() {
        return ListaUsuarios;
    }

    public void setPrUsuariosList(List<prUsuarios> ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prRoles)) {
            return false;
        }
        prRoles other = (prRoles) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prRoles[ idRol=" + idRol + " ]";
    }
    
}
