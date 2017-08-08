/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prDetallePrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface DetallePrestamosDao {

    void create(prDetallePrestamos prDetallePrestamos);

    void edit(prDetallePrestamos prDetallePrestamos);

    void remove(prDetallePrestamos prDetallePrestamos);

    prDetallePrestamos find(Object id);

    List<prDetallePrestamos> findAll();

    List<prDetallePrestamos> findRange(int[] range);

    int count();
    
}
