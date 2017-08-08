/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.bs;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.prestamos.dao.MenusDao;
import sv.com.prestamos.modelo.prMenus;

/**
 *
 * @author egalvez
 */
@Stateless
public class MenusBsImp implements MenusBs {

    @EJB
    private MenusDao menuDao;
    private List<prMenus> listaMenus;
    
    @Override
    public boolean Crear(prMenus prMenus) {
        try {
            menuDao.create(prMenus);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    @Override
    public boolean editar(prMenus prMenus) {
        try {
            menuDao.edit(prMenus);
            return true;
        } catch (Exception e) {
            return false; 
        }
    }

    @Override
    public boolean remover(prMenus prMenus) {
        try {
            menuDao.remove(prMenus);
            return true;
        } catch (Exception e) {
            return false;
            //throw new UnsupportedOperationException(e); 
        }
        
    }

    @Override
    public prMenus ListarMenuById(Object id) {
        try {
            return menuDao.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<prMenus> ListarMenus() {
        try {
            listaMenus= menuDao.findAll();
        } catch (Exception e) {
            listaMenus= null;
        }
        return listaMenus;
    }

    @Override
    public List<prMenus> ListarMenusByOrden() {
        try {
            listaMenus=menuDao.findAllByOrden();
        } catch (Exception e) {
            listaMenus= null;
        }
         return listaMenus;
    }

    

   

   
        

}
