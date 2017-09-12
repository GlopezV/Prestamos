/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.prestamos.modelo.prClientes;

/**
 *
 * @author egalvez
 */
@Stateless
public class ClientesDaoImp extends AbstractDao<prClientes> implements ClientesDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesDaoImp() {
        super(prClientes.class);
    }

  @Override
    public List<prClientes> findByNombreApellidos(String nombres, String apellidos) {
        String queryStr="SELECT p FROM prClientes p WHERE "
                + "UPPER(p.nombres) LIKE :cnombres or UPPER(p.apellidos) LIKE :capellidos";
        Query query= em.createQuery(queryStr);
        query.setParameter("cnombres", "%"+nombres.toUpperCase()+"%");
        query.setParameter("capellidos", "%"+apellidos.toUpperCase()+"%");
        List<prClientes> lst=query.getResultList();
                /*setParameter(1, nombres).
                setParameter(2, apellidos).getResultList();*/
        return lst;
    }

    @Override
    public List<prClientes> findByClientesTop() {
        String queryStr="SELECT p FROM prClientes p order by p.fecha_creacion,p.fecha_modificacion desc";
        Query query= em.createQuery(queryStr).setMaxResults(25);
        List<prClientes> lst=query.getResultList();
        return lst;
    }

    @Override
    public List<prClientes> findByCodigo(String idCliente) {
        //String queryStr="SELECT p FROM prClientes p WHERE p.idCliente =: idCliente";
        Query query=em.createQuery("SELECT p FROM prClientes p WHERE p.idCliente = :idCliente");
        query.setParameter("idCliente", idCliente);
        List<prClientes> lst=query.getResultList();
        return lst;
    }

    @Override
    public List<prClientes> findByDui(String dui) {
         Query query=em.createQuery("SELECT p FROM prClientes p WHERE p.dui = :dui");
         query.setParameter("dui", dui);
         List<prClientes> lst=query.getResultList();
         return lst;
    }
    
}
