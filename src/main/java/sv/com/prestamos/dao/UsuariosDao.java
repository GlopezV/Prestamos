/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prUsuarios;

/**
 *
 * @author egalvez
 */
@Local
public interface UsuariosDao {

    void create(prUsuarios prUsuarios);

    void edit(prUsuarios prUsuarios);

    void remove(prUsuarios prUsuarios);

    prUsuarios find(Object id);

    List<prUsuarios> findAll();

    List<prUsuarios> findRange(int[] range);

    int count();
    
}
