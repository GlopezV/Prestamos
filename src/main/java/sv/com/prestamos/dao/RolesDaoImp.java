/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.prestamos.modelo.prRoles;

/**
 *
 * @author egalvez
 */
@Stateless
public class RolesDaoImp extends AbstractDao<prRoles> implements RolesDao {
    @PersistenceContext(unitName = "PrestamosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesDaoImp() {
        super(prRoles.class);
    }
    
}
