package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Ponuda;

@Stateless
public class PonudaFacade extends AbstractFacade<Ponuda> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PonudaFacade() {
        super(Ponuda.class);
    }
    
}
