/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrDetallePrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface DetallePrestamosDao {

    void create(PrDetallePrestamos prDetallePrestamos);

    void edit(PrDetallePrestamos prDetallePrestamos);

    void remove(PrDetallePrestamos prDetallePrestamos);

    PrDetallePrestamos find(Object id);

    List<PrDetallePrestamos> findAll();

    List<PrDetallePrestamos> findRange(int[] range);

    int count();
    
}
