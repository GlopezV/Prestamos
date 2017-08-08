/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prClientes;

/**
 *
 * @author egalvez
 */
@Local
public interface ClientesDao {

    void create(prClientes prClientes);

    void edit(prClientes prClientes);

    void remove(prClientes prClientes);

    prClientes find(Object id);

    List<prClientes> findAll();

    List<prClientes> findRange(int[] range);

    List<prClientes> findByNombreApellidos(String nombres,String apellidos);
    
    List<prClientes> findByClientesTop();
    
    List<prClientes> findByCodigo(String idCliente);
    
    List<prClientes> findByDui(String dui);
    
    int count();
    
}
