/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prRolesXMenu;

/**
 *
 * @author egalvez
 */
@Local
public interface RolesXMenuDao {

    void create(prRolesXMenu prRolesXMenu);

    void edit(prRolesXMenu prRolesXMenu);

    void remove(prRolesXMenu prRolesXMenu);

    prRolesXMenu find(Object id);

    List<prRolesXMenu> findAll();

    List<prRolesXMenu> findRange(int[] range);

    int count();
    
}
