/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrLineasPrestamos;

/*
 *
 * @author egalvez
 */
@Local
public interface LineasPrestamosDao {

    void create(PrLineasPrestamos prlineasPrestamos);

    void edit(PrLineasPrestamos prlineasPrestamos);

    void remove(PrLineasPrestamos prlineasPrestamos);

    PrLineasPrestamos find(Object id);

    List<PrLineasPrestamos> findAll();

    List<PrLineasPrestamos> findRange(int[] range);

    int count();
    
}
