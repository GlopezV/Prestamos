/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface PrestamosDao {

    void create(prPrestamos prPrestamos);

    void edit(prPrestamos prPrestamos);

    void remove(prPrestamos prPrestamos);

    prPrestamos find(Object id);

    List<prPrestamos> findAll();

    List<prPrestamos> findRange(int[] range);

    int count();
    
}
