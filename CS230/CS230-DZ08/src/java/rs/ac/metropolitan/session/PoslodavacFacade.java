package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Poslodavac;

@Stateless
public class PoslodavacFacade extends AbstractFacade<Poslodavac> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoslodavacFacade() {
        super(Poslodavac.class);
    }
    
}
