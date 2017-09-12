/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prTransaccionesPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface TransaccionesPrestamosDao {

    void create(prTransaccionesPrestamos prTransaccionesPrestamos);

    void edit(prTransaccionesPrestamos prTransaccionesPrestamos);

    void remove(prTransaccionesPrestamos prTransaccionesPrestamos);

    prTransaccionesPrestamos find(Object id);

    List<prTransaccionesPrestamos> findAll();

    List<prTransaccionesPrestamos> findRange(int[] range);

    int count();
    
}
