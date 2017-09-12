/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrClientes;

/**
 *
 * @author egalvez
 */
@Local
public interface ClientesDao {

    void create(PrClientes prClientes);

    void edit(PrClientes prClientes);

    void remove(PrClientes prClientes);

    PrClientes find(Object id);

    List<PrClientes> findAll();

    List<PrClientes> findRange(int[] range);

    List<PrClientes> findByNombreApellidos(String nombres,String apellidos);
    
    List<PrClientes> findByClientesTop();
    
    List<PrClientes> findByCodigo(String idCliente);
    
    List<PrClientes> findByDui(String dui);
    
    int count();
    
}
