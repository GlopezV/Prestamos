/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.prestamos.modelo.PrLineasPrestamos;

/**
 *
 * @author egalvez
 */
@Stateless
public class LineasPrestamosDaoImp extends AbstractDao<PrLineasPrestamos> implements LineasPrestamosDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineasPrestamosDaoImp() {
        super(PrLineasPrestamos.class);
    }
    
}
