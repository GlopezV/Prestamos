/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface PrestamosDao {

    void create(PrPrestamos prPrestamos);

    void edit(PrPrestamos prPrestamos);

    void remove(PrPrestamos prPrestamos);

    PrPrestamos find(Object id);

    List<PrPrestamos> findAll();

    List<PrPrestamos> findRange(int[] range);

    int count();
    
}
