/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.bs;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prClientes;

/**
 *
 * @author egalvez
 */
@Local
public interface ClientesBs {
    
    String crear(prClientes prClientes);

    String editar(prClientes prClientes);

    String remover(prClientes prClientes);

    prClientes ListarById(Object id);

    List<prClientes> Listar();

    List<prClientes> findByNombreApellidos(String nombres,String apellidos);
    
    List<prClientes> findByClientesTop();
    
    List<prClientes> findByCodigo(String idCliente);
    
    List<prClientes> findByDui(String dui);
    
    int Contar();
}
