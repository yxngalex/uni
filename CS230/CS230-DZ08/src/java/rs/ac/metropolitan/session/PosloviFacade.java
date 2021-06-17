package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Poslovi;

@Stateless
public class PosloviFacade extends AbstractFacade<Poslovi> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PosloviFacade() {
        super(Poslovi.class);
    }
    
}
