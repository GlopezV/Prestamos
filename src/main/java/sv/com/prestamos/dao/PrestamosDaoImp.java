/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.prestamos.modelo.prPrestamos;

/**
 *
 * @author egalvez
 */
@Stateless
public class PrestamosDaoImp extends AbstractDao<prPrestamos> implements PrestamosDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamosDaoImp() {
        super(prPrestamos.class);
    }
    
}
