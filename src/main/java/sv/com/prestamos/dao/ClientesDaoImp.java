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
import sv.com.prestamos.modelo.PrClientes;

/**
 *
 * @author egalvez
 */
@Stateless
public class ClientesDaoImp extends AbstractDao<PrClientes> implements ClientesDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesDaoImp() {
        super(PrClientes.class);
    }

  @Override
    public List<PrClientes> findByNombreApellidos(String nombres, String apellidos) {
        String queryStr="SELECT p FROM PrClientes p WHERE "
                + "UPPER(p.nombres) LIKE :cnombres or UPPER(p.apellidos) LIKE :capellidos";
        Query query= em.createQuery(queryStr);
        query.setParameter("cnombres", "%"+nombres.toUpperCase()+"%");
        query.setParameter("capellidos", "%"+apellidos.toUpperCase()+"%");
        List<PrClientes> lst=query.getResultList();
                /*setParameter(1, nombres).
                setParameter(2, apellidos).getResultList();*/
        return lst;
    }

    @Override
    public List<PrClientes> findByClientesTop() {
        String queryStr="SELECT p FROM PrClientes p order by p.fecha_creacion,p.fecha_modificacion desc";
        Query query= em.createQuery(queryStr).setMaxResults(25);
        List<PrClientes> lst=query.getResultList();
        return lst;
    }

    @Override
    public List<PrClientes> findByCodigo(String idCliente) {
        //String queryStr="SELECT p FROM prClientes p WHERE p.idCliente =: idCliente";
        Query query=em.createQuery("SELECT p FROM PrClientes p WHERE p.idCliente = :idCliente");
        query.setParameter("idCliente", idCliente);
        List<PrClientes> lst=query.getResultList();
        return lst;
    }

    @Override
    public List<PrClientes> findByDui(String dui) {
         Query query=em.createQuery("SELECT p FROM PrClientes p WHERE p.dui = :dui");
         query.setParameter("dui", dui);
         List<PrClientes> lst=query.getResultList();
         return lst;
    }
    
}
