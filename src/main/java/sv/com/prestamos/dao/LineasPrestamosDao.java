/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prLineasPrestamos;

/*
 *
 * @author egalvez
 */
@Local
public interface LineasPrestamosDao {

    void create(prLineasPrestamos prlineasPrestamos);

    void edit(prLineasPrestamos prlineasPrestamos);

    void remove(prLineasPrestamos prlineasPrestamos);

    prLineasPrestamos find(Object id);

    List<prLineasPrestamos> findAll();

    List<prLineasPrestamos> findRange(int[] range);

    int count();
    
}
