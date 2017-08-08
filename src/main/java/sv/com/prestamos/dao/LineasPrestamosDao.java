/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prlineasPrestamos;

/**
 *
 * @author egalvez
 */
@Local
public interface LineasPrestamosDao {

    void create(prlineasPrestamos prlineasPrestamos);

    void edit(prlineasPrestamos prlineasPrestamos);

    void remove(prlineasPrestamos prlineasPrestamos);

    prlineasPrestamos find(Object id);

    List<prlineasPrestamos> findAll();

    List<prlineasPrestamos> findRange(int[] range);

    int count();
    
}
