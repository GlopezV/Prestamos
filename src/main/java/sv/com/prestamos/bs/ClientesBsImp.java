/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.bs;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.prestamos.dao.ClientesDao;
import sv.com.prestamos.modelo.prClientes;
import java.util.Calendar;

/**
 *
 * @author egalvez
 */
@Stateless
public class ClientesBsImp implements ClientesBs {

    @EJB
    private ClientesDao clienteDao; 
    private List<prClientes> listaClientes;
    
    @Override
    public String crear(prClientes prClientes) {
        try {
            prClientes.setFechaCreacion(Calendar.getInstance());
            clienteDao.create(prClientes);
            return "Exitoso";
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public String editar(prClientes prClientes) {
          try {
            prClientes.setFechaModificacion(Calendar.getInstance());
            clienteDao.edit(prClientes);
            return "Exitoso";
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public String remover(prClientes prClientes) {
          try {
            clienteDao.remove(prClientes);
            return "Exitoso";
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public prClientes ListarById(Object id) {
        try {
            return clienteDao.find(id);
        } catch (Exception e) {
            return null;
        }
            
    }

    @Override
    public List<prClientes> Listar() {
        try {
            listaClientes=clienteDao.findAll();
            return listaClientes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int Contar() {
        try {
            return clienteDao.count();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<prClientes> findByNombreApellidos(String nombres, String apellidos) {
        try {
            listaClientes=clienteDao.findByNombreApellidos(nombres, apellidos);
            return listaClientes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<prClientes> findByClientesTop() {
         try {
            listaClientes=clienteDao.findByClientesTop();
            return listaClientes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<prClientes> findByCodigo(String idCliente) {
        try {
            listaClientes=clienteDao.findByCodigo(idCliente);
            return listaClientes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<prClientes> findByDui(String dui) {
        try {
            listaClientes=clienteDao.findByDui(dui);
            return listaClientes;
        } catch (Exception e) {
            return null;
        }
    }

}
