/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prDistPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface DistPrestamosDao {

    void create(prDistPrestamos prDistPrestamos);

    void edit(prDistPrestamos prDistPrestamos);

    void remove(prDistPrestamos prDistPrestamos);

    prDistPrestamos find(Object id);

    List<prDistPrestamos> findAll();

    List<prDistPrestamos> findRange(int[] range);

    int count();
    
}
