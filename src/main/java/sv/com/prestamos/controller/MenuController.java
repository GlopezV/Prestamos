
package sv.com.prestamos.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.com.prestamos.bs.MenusBs;
import sv.com.prestamos.modelo.prMenus;

@Named(value = "menuController")
@SessionScoped
public class MenuController implements Serializable{
    
    @EJB
    private MenusBs menusBS;
    private List<prMenus> listaMenu;
    private MenuModel modelo;
    
    
    @PostConstruct
    public void init(){
        this.ListarMenus();
        modelo=new DefaultMenuModel();
        this.estabelecerMenu();
    }
    
    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

    public List<prMenus> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<prMenus> listaMenu) {
        this.listaMenu = listaMenu;
    }
    
    public void ListarMenus(){
        try {
            listaMenu=menusBS.ListarMenusByOrden();
        } catch (Exception e) {
            //mensaje JSF
        }
    }
    
    public void estabelecerMenu(){
        for (prMenus m:listaMenu){
            if(m.getSubMenu().equals(false)){
                DefaultSubMenu firstMenu=new DefaultSubMenu(m.getMenu(),m.getIcon());
               
                for(prMenus i:listaMenu){
                    prMenus SubMenu=i.getMenu_Padre();
                    if(SubMenu!=null){
                        if(SubMenu.getIdMenu().equals(m.getIdMenu())){
                            DefaultMenuItem item=new DefaultMenuItem(i.getMenu(),i.getIcon());
                            item.setUrl(i.getUrl());
                            firstMenu.addElement(item);
                            
                        }
                    }
                }
                modelo.addElement(firstMenu);
            }
        }
    }
    
    public void establecerPanelmenu(){
        for (prMenus m:listaMenu){
            if(m.getSubMenu().equals(false)){
                
                DefaultSubMenu firstMenu=new DefaultSubMenu(m.getMenu(),m.getIcon());
                for(prMenus i:listaMenu){
                    prMenus SubMenu=i.getMenu_Padre();
                    if(SubMenu!=null){
                        if(SubMenu.getIdMenu().equals(m.getIdMenu())){
                            DefaultMenuItem item=new DefaultMenuItem(i.getMenu(),i.getIcon());
                            item.setUrl(i.getUrl());
                            firstMenu.addElement(item);
                        }
                    }
                }
                modelo.addElement(firstMenu);
            }
        }
    }
    
}
