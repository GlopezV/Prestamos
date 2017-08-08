/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prMenus;

/**
 *
 * @author egalvez
 */
@Local
public interface MenusDao {

    void create(prMenus prMenus);

    void edit(prMenus prMenus);

    void remove(prMenus prMenus);

    prMenus find(Object id);

    List<prMenus> findAll();
    
    List<prMenus> findAllByOrden();

    List<prMenus> findRange(int[] range);

    int count();
    
}
