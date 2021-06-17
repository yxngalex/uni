package rs.ac.metropolitan.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.ac.metropolitan.entity.Radnik;

@Stateless
public class RadnikFacade extends AbstractFacade<Radnik> {

    @PersistenceContext(unitName = "CS230-DZ08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RadnikFacade() {
        super(Radnik.class);
    }
    
}
