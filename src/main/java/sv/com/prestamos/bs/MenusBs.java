/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.bs;

import java.util.List;
import javax.ejb.Local;
import sv.com.prestamos.modelo.prMenus;

/**
 *
 * @author egalvez
 */
@Local
public interface MenusBs {
    
    boolean Crear(prMenus prMenus);

    boolean editar(prMenus prMenus);

    boolean remover(prMenus prMenus);

    prMenus ListarMenuById(Object id);
     
    List<prMenus> ListarMenus();
    
    List<prMenus> ListarMenusByOrden();
    
   
}
