/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrTransaccionesPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface TransaccionesPrestamosDao {

    void create(PrTransaccionesPrestamos prTransaccionesPrestamos);

    void edit(PrTransaccionesPrestamos prTransaccionesPrestamos);

    void remove(PrTransaccionesPrestamos prTransaccionesPrestamos);

    PrTransaccionesPrestamos find(Object id);

    List<PrTransaccionesPrestamos> findAll();

    List<PrTransaccionesPrestamos> findRange(int[] range);

    int count();
    
}
