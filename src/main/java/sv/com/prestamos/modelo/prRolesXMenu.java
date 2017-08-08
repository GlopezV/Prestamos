/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_roles_x_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prRolesXMenu.findAll", query = "SELECT p FROM prRolesXMenu p"),
    @NamedQuery(name = "prRolesXMenu.findByIdRolMenu", query = "SELECT p FROM prRolesXMenu p WHERE p.idRolMenu = :idRolMenu")})
public class prRolesXMenu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_rol_menu")
    private String idRolMenu;
    
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private prRoles Roles;
    
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    @ManyToOne
    private prMenus Menu;

    public prRolesXMenu() {
    }

    public prRolesXMenu(String idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public String getIdRolMenu() {
        return idRolMenu;
    }

    public void setIdRolMenu(String idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public prRoles getIdRol() {
        return Roles;
    }

    public void setIdRol(prRoles Roles) {
        this.Roles = Roles;
    }

    public prMenus getIdMenu() {
        return Menu;
    }

    public void setIdMenu(prMenus Menu) {
        this.Menu = Menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolMenu != null ? idRolMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prRolesXMenu)) {
            return false;
        }
        prRolesXMenu other = (prRolesXMenu) object;
        if ((this.idRolMenu == null && other.idRolMenu != null) || (this.idRolMenu != null && !this.idRolMenu.equals(other.idRolMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prRolesXMenu[ idRolMenu=" + idRolMenu + " ]";
    }
    
}
