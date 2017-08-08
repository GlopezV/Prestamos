/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prLogTransacciones;

/**
 *
 * @author egalvez
 */
@Local
public interface LogTransaccionesDao {

    void create(prLogTransacciones prLogTransacciones);

    void edit(prLogTransacciones prLogTransacciones);

    void remove(prLogTransacciones prLogTransacciones);

    prLogTransacciones find(Object id);

    List<prLogTransacciones> findAll();

    List<prLogTransacciones> findRange(int[] range);

    int count();
    
}
