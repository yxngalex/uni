package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Ocena;

@Stateless
public class OcenaFacade extends AbstractFacade<Ocena> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OcenaFacade() {
        super(Ocena.class);
    }
    
}
