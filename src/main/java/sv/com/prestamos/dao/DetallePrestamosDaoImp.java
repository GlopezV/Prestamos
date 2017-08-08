/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.prestamos.modelo.prDetallePrestamos;

/**
 *
 * @author egalvez
 */
@Stateless
public class DetallePrestamosDaoImp extends AbstractDao<prDetallePrestamos> implements DetallePrestamosDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePrestamosDaoImp() {
        super(prDetallePrestamos.class);
    }
    
}
