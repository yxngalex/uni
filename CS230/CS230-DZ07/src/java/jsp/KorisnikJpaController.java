/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Administrator;
import entity.Korisnik;
import java.util.ArrayList;
import java.util.Collection;
import entity.Radnik;
import entity.Poslodavac;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import jsp.exceptions.IllegalOrphanException;
import jsp.exceptions.NonexistentEntityException;
import jsp.exceptions.RollbackFailureException;

/**
 *
 * @author aleks
 */
public class KorisnikJpaController implements Serializable {

    public KorisnikJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Korisnik korisnik) throws RollbackFailureException, Exception {
        if (korisnik.getAdministratorCollection() == null) {
            korisnik.setAdministratorCollection(new ArrayList<Administrator>());
        }
        if (korisnik.getRadnikCollection() == null) {
            korisnik.setRadnikCollection(new ArrayList<Radnik>());
        }
        if (korisnik.getPoslodavacCollection() == null) {
            korisnik.setPoslodavacCollection(new ArrayList<Poslodavac>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Administrator> attachedAdministratorCollection = new ArrayList<Administrator>();
            for (Administrator administratorCollectionAdministratorToAttach : korisnik.getAdministratorCollection()) {
                administratorCollectionAdministratorToAttach = em.getReference(administratorCollectionAdministratorToAttach.getClass(), administratorCollectionAdministratorToAttach.getIdAdministartora());
                attachedAdministratorCollection.add(administratorCollectionAdministratorToAttach);
            }
            korisnik.setAdministratorCollection(attachedAdministratorCollection);
            Collection<Radnik> attachedRadnikCollection = new ArrayList<Radnik>();
            for (Radnik radnikCollectionRadnikToAttach : korisnik.getRadnikCollection()) {
                radnikCollectionRadnikToAttach = em.getReference(radnikCollectionRadnikToAttach.getClass(), radnikCollectionRadnikToAttach.getIdRadnika());
                attachedRadnikCollection.add(radnikCollectionRadnikToAttach);
            }
            korisnik.setRadnikCollection(attachedRadnikCollection);
            Collection<Poslodavac> attachedPoslodavacCollection = new ArrayList<Poslodavac>();
            for (Poslodavac poslodavacCollectionPoslodavacToAttach : korisnik.getPoslodavacCollection()) {
                poslodavacCollectionPoslodavacToAttach = em.getReference(poslodavacCollectionPoslodavacToAttach.getClass(), poslodavacCollectionPoslodavacToAttach.getIdPoslodavca());
                attachedPoslodavacCollection.add(poslodavacCollectionPoslodavacToAttach);
            }
            korisnik.setPoslodavacCollection(attachedPoslodavacCollection);
            em.persist(korisnik);
            for (Administrator administratorCollectionAdministrator : korisnik.getAdministratorCollection()) {
                Korisnik oldIdKorisnikaOfAdministratorCollectionAdministrator = administratorCollectionAdministrator.getIdKorisnika();
                administratorCollectionAdministrator.setIdKorisnika(korisnik);
                administratorCollectionAdministrator = em.merge(administratorCollectionAdministrator);
                if (oldIdKorisnikaOfAdministratorCollectionAdministrator != null) {
                    oldIdKorisnikaOfAdministratorCollectionAdministrator.getAdministratorCollection().remove(administratorCollectionAdministrator);
                    oldIdKorisnikaOfAdministratorCollectionAdministrator = em.merge(oldIdKorisnikaOfAdministratorCollectionAdministrator);
                }
            }
            for (Radnik radnikCollectionRadnik : korisnik.getRadnikCollection()) {
                Korisnik oldIdKorisnikaOfRadnikCollectionRadnik = radnikCollectionRadnik.getIdKorisnika();
                radnikCollectionRadnik.setIdKorisnika(korisnik);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
                if (oldIdKorisnikaOfRadnikCollectionRadnik != null) {
                    oldIdKorisnikaOfRadnikCollectionRadnik.getRadnikCollection().remove(radnikCollectionRadnik);
                    oldIdKorisnikaOfRadnikCollectionRadnik = em.merge(oldIdKorisnikaOfRadnikCollectionRadnik);
                }
            }
            for (Poslodavac poslodavacCollectionPoslodavac : korisnik.getPoslodavacCollection()) {
                Korisnik oldIdKorisnikaOfPoslodavacCollectionPoslodavac = poslodavacCollectionPoslodavac.getIdKorisnika();
                poslodavacCollectionPoslodavac.setIdKorisnika(korisnik);
                poslodavacCollectionPoslodavac = em.merge(poslodavacCollectionPoslodavac);
                if (oldIdKorisnikaOfPoslodavacCollectionPoslodavac != null) {
                    oldIdKorisnikaOfPoslodavacCollectionPoslodavac.getPoslodavacCollection().remove(poslodavacCollectionPoslodavac);
                    oldIdKorisnikaOfPoslodavacCollectionPoslodavac = em.merge(oldIdKorisnikaOfPoslodavacCollectionPoslodavac);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Korisnik korisnik) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Korisnik persistentKorisnik = em.find(Korisnik.class, korisnik.getIdKorisnika());
            Collection<Administrator> administratorCollectionOld = persistentKorisnik.getAdministratorCollection();
            Collection<Administrator> administratorCollectionNew = korisnik.getAdministratorCollection();
            Collection<Radnik> radnikCollectionOld = persistentKorisnik.getRadnikCollection();
            Collection<Radnik> radnikCollectionNew = korisnik.getRadnikCollection();
            Collection<Poslodavac> poslodavacCollectionOld = persistentKorisnik.getPoslodavacCollection();
            Collection<Poslodavac> poslodavacCollectionNew = korisnik.getPoslodavacCollection();
            List<String> illegalOrphanMessages = null;
            for (Administrator administratorCollectionOldAdministrator : administratorCollectionOld) {
                if (!administratorCollectionNew.contains(administratorCollectionOldAdministrator)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Administrator " + administratorCollectionOldAdministrator + " since its idKorisnika field is not nullable.");
                }
            }
            for (Radnik radnikCollectionOldRadnik : radnikCollectionOld) {
                if (!radnikCollectionNew.contains(radnikCollectionOldRadnik)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Radnik " + radnikCollectionOldRadnik + " since its idKorisnika field is not nullable.");
                }
            }
            for (Poslodavac poslodavacCollectionOldPoslodavac : poslodavacCollectionOld) {
                if (!poslodavacCollectionNew.contains(poslodavacCollectionOldPoslodavac)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Poslodavac " + poslodavacCollectionOldPoslodavac + " since its idKorisnika field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Administrator> attachedAdministratorCollectionNew = new ArrayList<Administrator>();
            for (Administrator administratorCollectionNewAdministratorToAttach : administratorCollectionNew) {
                administratorCollectionNewAdministratorToAttach = em.getReference(administratorCollectionNewAdministratorToAttach.getClass(), administratorCollectionNewAdministratorToAttach.getIdAdministartora());
                attachedAdministratorCollectionNew.add(administratorCollectionNewAdministratorToAttach);
            }
            administratorCollectionNew = attachedAdministratorCollectionNew;
            korisnik.setAdministratorCollection(administratorCollectionNew);
            Collection<Radnik> attachedRadnikCollectionNew = new ArrayList<Radnik>();
            for (Radnik radnikCollectionNewRadnikToAttach : radnikCollectionNew) {
                radnikCollectionNewRadnikToAttach = em.getReference(radnikCollectionNewRadnikToAttach.getClass(), radnikCollectionNewRadnikToAttach.getIdRadnika());
                attachedRadnikCollectionNew.add(radnikCollectionNewRadnikToAttach);
            }
            radnikCollectionNew = attachedRadnikCollectionNew;
            korisnik.setRadnikCollection(radnikCollectionNew);
            Collection<Poslodavac> attachedPoslodavacCollectionNew = new ArrayList<Poslodavac>();
            for (Poslodavac poslodavacCollectionNewPoslodavacToAttach : poslodavacCollectionNew) {
                poslodavacCollectionNewPoslodavacToAttach = em.getReference(poslodavacCollectionNewPoslodavacToAttach.getClass(), poslodavacCollectionNewPoslodavacToAttach.getIdPoslodavca());
                attachedPoslodavacCollectionNew.add(poslodavacCollectionNewPoslodavacToAttach);
            }
            poslodavacCollectionNew = attachedPoslodavacCollectionNew;
            korisnik.setPoslodavacCollection(poslodavacCollectionNew);
            korisnik = em.merge(korisnik);
            for (Administrator administratorCollectionNewAdministrator : administratorCollectionNew) {
                if (!administratorCollectionOld.contains(administratorCollectionNewAdministrator)) {
                    Korisnik oldIdKorisnikaOfAdministratorCollectionNewAdministrator = administratorCollectionNewAdministrator.getIdKorisnika();
                    administratorCollectionNewAdministrator.setIdKorisnika(korisnik);
                    administratorCollectionNewAdministrator = em.merge(administratorCollectionNewAdministrator);
                    if (oldIdKorisnikaOfAdministratorCollectionNewAdministrator != null && !oldIdKorisnikaOfAdministratorCollectionNewAdministrator.equals(korisnik)) {
                        oldIdKorisnikaOfAdministratorCollectionNewAdministrator.getAdministratorCollection().remove(administratorCollectionNewAdministrator);
                        oldIdKorisnikaOfAdministratorCollectionNewAdministrator = em.merge(oldIdKorisnikaOfAdministratorCollectionNewAdministrator);
                    }
                }
            }
            for (Radnik radnikCollectionNewRadnik : radnikCollectionNew) {
                if (!radnikCollectionOld.contains(radnikCollectionNewRadnik)) {
                    Korisnik oldIdKorisnikaOfRadnikCollectionNewRadnik = radnikCollectionNewRadnik.getIdKorisnika();
                    radnikCollectionNewRadnik.setIdKorisnika(korisnik);
                    radnikCollectionNewRadnik = em.merge(radnikCollectionNewRadnik);
                    if (oldIdKorisnikaOfRadnikCollectionNewRadnik != null && !oldIdKorisnikaOfRadnikCollectionNewRadnik.equals(korisnik)) {
                        oldIdKorisnikaOfRadnikCollectionNewRadnik.getRadnikCollection().remove(radnikCollectionNewRadnik);
                        oldIdKorisnikaOfRadnikCollectionNewRadnik = em.merge(oldIdKorisnikaOfRadnikCollectionNewRadnik);
                    }
                }
            }
            for (Poslodavac poslodavacCollectionNewPoslodavac : poslodavacCollectionNew) {
                if (!poslodavacCollectionOld.contains(poslodavacCollectionNewPoslodavac)) {
                    Korisnik oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac = poslodavacCollectionNewPoslodavac.getIdKorisnika();
                    poslodavacCollectionNewPoslodavac.setIdKorisnika(korisnik);
                    poslodavacCollectionNewPoslodavac = em.merge(poslodavacCollectionNewPoslodavac);
                    if (oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac != null && !oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac.equals(korisnik)) {
                        oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac.getPoslodavacCollection().remove(poslodavacCollectionNewPoslodavac);
                        oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac = em.merge(oldIdKorisnikaOfPoslodavacCollectionNewPoslodavac);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = korisnik.getIdKorisnika();
                if (findKorisnik(id) == null) {
                    throw new NonexistentEntityException("The korisnik with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Korisnik korisnik;
            try {
                korisnik = em.getReference(Korisnik.class, id);
                korisnik.getIdKorisnika();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The korisnik with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Administrator> administratorCollectionOrphanCheck = korisnik.getAdministratorCollection();
            for (Administrator administratorCollectionOrphanCheckAdministrator : administratorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Korisnik (" + korisnik + ") cannot be destroyed since the Administrator " + administratorCollectionOrphanCheckAdministrator + " in its administratorCollection field has a non-nullable idKorisnika field.");
            }
            Collection<Radnik> radnikCollectionOrphanCheck = korisnik.getRadnikCollection();
            for (Radnik radnikCollectionOrphanCheckRadnik : radnikCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Korisnik (" + korisnik + ") cannot be destroyed since the Radnik " + radnikCollectionOrphanCheckRadnik + " in its radnikCollection field has a non-nullable idKorisnika field.");
            }
            Collection<Poslodavac> poslodavacCollectionOrphanCheck = korisnik.getPoslodavacCollection();
            for (Poslodavac poslodavacCollectionOrphanCheckPoslodavac : poslodavacCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Korisnik (" + korisnik + ") cannot be destroyed since the Poslodavac " + poslodavacCollectionOrphanCheckPoslodavac + " in its poslodavacCollection field has a non-nullable idKorisnika field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(korisnik);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Korisnik> findKorisnikEntities() {
        return findKorisnikEntities(true, -1, -1);
    }

    public List<Korisnik> findKorisnikEntities(int maxResults, int firstResult) {
        return findKorisnikEntities(false, maxResults, firstResult);
    }

    private List<Korisnik> findKorisnikEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Korisnik.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Korisnik findKorisnik(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Korisnik.class, id);
        } finally {
            em.close();
        }
    }

    public int getKorisnikCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Korisnik> rt = cq.from(Korisnik.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
