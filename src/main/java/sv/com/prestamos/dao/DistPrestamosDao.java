/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrDistPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface DistPrestamosDao {

    void create(PrDistPrestamos prDistPrestamos);

    void edit(PrDistPrestamos prDistPrestamos);

    void remove(PrDistPrestamos prDistPrestamos);

    PrDistPrestamos find(Object id);

    List<PrDistPrestamos> findAll();

    List<PrDistPrestamos> findRange(int[] range);

    int count();
    
}
