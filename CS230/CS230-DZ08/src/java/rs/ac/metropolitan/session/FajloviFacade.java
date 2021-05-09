package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Fajlovi;

@Stateless
public class FajloviFacade extends AbstractFacade<Fajlovi> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FajloviFacade() {
        super(Fajlovi.class);
    }
    
}
