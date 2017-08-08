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
import sv.com.prestamos.modelo.prMenus;

/**
 *
 * @author egalvez
 */
@Stateless
public class MenusDaoImp extends AbstractDao<prMenus> implements MenusDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenusDaoImp() {
        super(prMenus.class);
    }

    @Override
    public List<prMenus> findAllByOrden() {
        //Codigo creando la consulta atravez de un createQuery se sustityo por un Namequery para mejora de Rendimiento
        /*String queryStr="SELECT p FROM prMenus p order by p.orden asc";
        Query query=em.createQuery(queryStr);
        return query.getResultList();*/
        //--------------------------------------
        //Codigo de Consulta simplificada con createQuery se sustityo por un Namequery para mejora de Rendimiento
        //return em.createQuery("SELECT p FROM prMenus p order by p.orden asc").getResultList();
        //-------------------------------------
        return em.createNamedQuery("prMenus.findAllByOrden").getResultList();
    }

   
    
}
