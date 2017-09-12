/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.bs;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.PrClientes;

/**
 *
 * @author egalvez
 */
@Local
public interface ClientesBs {
    
    String crear(PrClientes prClientes);

    String editar(PrClientes prClientes);

    String remover(PrClientes prClientes);

    PrClientes ListarById(Object id);

    List<PrClientes> Listar();

    List<PrClientes> findByNombreApellidos(String nombres,String apellidos);
    
    List<PrClientes> findByClientesTop();
    
    List<PrClientes> findByCodigo(String idCliente);
    
    List<PrClientes> findByDui(String dui);
    
    int Contar();
}
