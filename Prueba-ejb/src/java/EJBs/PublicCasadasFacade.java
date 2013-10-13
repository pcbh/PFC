/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author laura
 */
@Stateless
public class PublicCasadasFacade extends AbstractFacade<PublicCasadas> {
    @PersistenceContext(unitName = "Prueba-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicCasadasFacade() {
        super(PublicCasadas.class);
    }
    
}
