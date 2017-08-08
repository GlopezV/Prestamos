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
@Table(name = "pr_menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prMenus.findAll", query = "SELECT p FROM prMenus p"),
    @NamedQuery(name = "prMenus.findByIdMenu", query = "SELECT p FROM prMenus p WHERE p.idMenu = :idMenu"),
    @NamedQuery(name = "prMenus.findByMenu", query = "SELECT p FROM prMenus p WHERE p.menu = :menu"),
    @NamedQuery(name = "prMenus.findBySubMenu", query = "SELECT p FROM prMenus p WHERE p.subMenu = :subMenu"),
    @NamedQuery(name = "prMenus.findByMenuPadre", query = "SELECT p FROM prMenus p WHERE p.menuPadre = :menuPadre"),
    @NamedQuery(name = "prMenus.findByUrl", query = "SELECT p FROM prMenus p WHERE p.url = :url"),
    @NamedQuery(name = "prMenus.findAllByOrden",query="SELECT p FROM prMenus p order by p.orden asc")})
public class prMenus implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_menu")
    private String idMenu;
    
    @Size(max = 75)
    @Column(name = "menu")
    private String menu;
    
    @Column(name = "sub_menu")
    private Boolean subMenu;
    
    @Size(max = 15)
    @Column(name = "menu_padre")
    private String menuPadre;
    
    @Size(max = 50)
    @Column(name = "url")
    private String url;
    
    @Column(name = "orden")
    private Integer orden;
    
    @Column(name="icon")
    private String icon;
    
    @OneToMany(mappedBy = "Menu")
    private List<prRolesXMenu> ListaRolesXMenu;
    
    @ManyToOne
    @JoinColumn(name = "menu_padre", referencedColumnName = "id_menu", insertable=false, updatable=false)
    private prMenus SubMenus;
    
    public prMenus() {
    }

    public prMenus(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Boolean getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Boolean subMenu) {
        this.subMenu = subMenu;
    }

    public String getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(String menuPadre) {
        this.menuPadre = menuPadre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public List<prRolesXMenu> getPrRolesXMenuList() {
        return ListaRolesXMenu;
    }

    public void setPrRolesXMenuList(List<prRolesXMenu> ListaRolesXMenu) {
        this.ListaRolesXMenu = ListaRolesXMenu;
    }

    public prMenus getMenu_Padre() {
        return SubMenus;
    }

    public void setMenu_Padre(prMenus SubMenus) {
        this.SubMenus = SubMenus;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prMenus)) {
            return false;
        }
        prMenus other = (prMenus) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prMenus[ idMenu=" + idMenu + " ]";
    }
    
}
