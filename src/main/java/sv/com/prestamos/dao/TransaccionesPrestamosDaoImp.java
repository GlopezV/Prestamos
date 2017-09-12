/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.prestamos.modelo.PrTransaccionesPrestamos;

/**
 *
 * @author egalvez
 */
@Stateless
public class TransaccionesPrestamosDaoImp extends AbstractDao<PrTransaccionesPrestamos> implements TransaccionesPrestamosDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesPrestamosDaoImp() {
        super(PrTransaccionesPrestamos.class);
    }
    
}
