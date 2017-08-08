/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prRoles;

/**
 *
 * @author egalvez
 */
@Local
public interface RolesDao {

    void create(prRoles prRoles);

    void edit(prRoles prRoles);

    void remove(prRoles prRoles);

    prRoles find(Object id);

    List<prRoles> findAll();

    List<prRoles> findRange(int[] range);

    int count();
    
}
