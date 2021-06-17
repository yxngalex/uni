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
import entity.Korisnik;
import entity.Poruka;
import entity.Poslodavac;
import entity.Poslovi;
import java.util.ArrayList;
import java.util.Collection;
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
public class PoslodavacJpaController implements Serializable {

    public PoslodavacJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Poslodavac poslodavac) throws RollbackFailureException, Exception {
        if (poslodavac.getPosloviCollection() == null) {
            poslodavac.setPosloviCollection(new ArrayList<Poslovi>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Korisnik idKorisnika = poslodavac.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika = em.getReference(idKorisnika.getClass(), idKorisnika.getIdKorisnika());
                poslodavac.setIdKorisnika(idKorisnika);
            }
            Poruka idPoruke = poslodavac.getIdPoruke();
            if (idPoruke != null) {
                idPoruke = em.getReference(idPoruke.getClass(), idPoruke.getIdPoruke());
                poslodavac.setIdPoruke(idPoruke);
            }
            Collection<Poslovi> attachedPosloviCollection = new ArrayList<Poslovi>();
            for (Poslovi posloviCollectionPosloviToAttach : poslodavac.getPosloviCollection()) {
                posloviCollectionPosloviToAttach = em.getReference(posloviCollectionPosloviToAttach.getClass(), posloviCollectionPosloviToAttach.getIdPosla());
                attachedPosloviCollection.add(posloviCollectionPosloviToAttach);
            }
            poslodavac.setPosloviCollection(attachedPosloviCollection);
            em.persist(poslodavac);
            if (idKorisnika != null) {
                idKorisnika.getPoslodavacCollection().add(poslodavac);
                idKorisnika = em.merge(idKorisnika);
            }
            if (idPoruke != null) {
                idPoruke.getPoslodavacCollection().add(poslodavac);
                idPoruke = em.merge(idPoruke);
            }
            for (Poslovi posloviCollectionPoslovi : poslodavac.getPosloviCollection()) {
                Poslodavac oldIdPoslodavcaOfPosloviCollectionPoslovi = posloviCollectionPoslovi.getIdPoslodavca();
                posloviCollectionPoslovi.setIdPoslodavca(poslodavac);
                posloviCollectionPoslovi = em.merge(posloviCollectionPoslovi);
                if (oldIdPoslodavcaOfPosloviCollectionPoslovi != null) {
                    oldIdPoslodavcaOfPosloviCollectionPoslovi.getPosloviCollection().remove(posloviCollectionPoslovi);
                    oldIdPoslodavcaOfPosloviCollectionPoslovi = em.merge(oldIdPoslodavcaOfPosloviCollectionPoslovi);
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

    public void edit(Poslodavac poslodavac) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslodavac persistentPoslodavac = em.find(Poslodavac.class, poslodavac.getIdPoslodavca());
            Korisnik idKorisnikaOld = persistentPoslodavac.getIdKorisnika();
            Korisnik idKorisnikaNew = poslodavac.getIdKorisnika();
            Poruka idPorukeOld = persistentPoslodavac.getIdPoruke();
            Poruka idPorukeNew = poslodavac.getIdPoruke();
            Collection<Poslovi> posloviCollectionOld = persistentPoslodavac.getPosloviCollection();
            Collection<Poslovi> posloviCollectionNew = poslodavac.getPosloviCollection();
            List<String> illegalOrphanMessages = null;
            for (Poslovi posloviCollectionOldPoslovi : posloviCollectionOld) {
                if (!posloviCollectionNew.contains(posloviCollectionOldPoslovi)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Poslovi " + posloviCollectionOldPoslovi + " since its idPoslodavca field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idKorisnikaNew != null) {
                idKorisnikaNew = em.getReference(idKorisnikaNew.getClass(), idKorisnikaNew.getIdKorisnika());
                poslodavac.setIdKorisnika(idKorisnikaNew);
            }
            if (idPorukeNew != null) {
                idPorukeNew = em.getReference(idPorukeNew.getClass(), idPorukeNew.getIdPoruke());
                poslodavac.setIdPoruke(idPorukeNew);
            }
            Collection<Poslovi> attachedPosloviCollectionNew = new ArrayList<Poslovi>();
            for (Poslovi posloviCollectionNewPosloviToAttach : posloviCollectionNew) {
                posloviCollectionNewPosloviToAttach = em.getReference(posloviCollectionNewPosloviToAttach.getClass(), posloviCollectionNewPosloviToAttach.getIdPosla());
                attachedPosloviCollectionNew.add(posloviCollectionNewPosloviToAttach);
            }
            posloviCollectionNew = attachedPosloviCollectionNew;
            poslodavac.setPosloviCollection(posloviCollectionNew);
            poslodavac = em.merge(poslodavac);
            if (idKorisnikaOld != null && !idKorisnikaOld.equals(idKorisnikaNew)) {
                idKorisnikaOld.getPoslodavacCollection().remove(poslodavac);
                idKorisnikaOld = em.merge(idKorisnikaOld);
            }
            if (idKorisnikaNew != null && !idKorisnikaNew.equals(idKorisnikaOld)) {
                idKorisnikaNew.getPoslodavacCollection().add(poslodavac);
                idKorisnikaNew = em.merge(idKorisnikaNew);
            }
            if (idPorukeOld != null && !idPorukeOld.equals(idPorukeNew)) {
                idPorukeOld.getPoslodavacCollection().remove(poslodavac);
                idPorukeOld = em.merge(idPorukeOld);
            }
            if (idPorukeNew != null && !idPorukeNew.equals(idPorukeOld)) {
                idPorukeNew.getPoslodavacCollection().add(poslodavac);
                idPorukeNew = em.merge(idPorukeNew);
            }
            for (Poslovi posloviCollectionNewPoslovi : posloviCollectionNew) {
                if (!posloviCollectionOld.contains(posloviCollectionNewPoslovi)) {
                    Poslodavac oldIdPoslodavcaOfPosloviCollectionNewPoslovi = posloviCollectionNewPoslovi.getIdPoslodavca();
                    posloviCollectionNewPoslovi.setIdPoslodavca(poslodavac);
                    posloviCollectionNewPoslovi = em.merge(posloviCollectionNewPoslovi);
                    if (oldIdPoslodavcaOfPosloviCollectionNewPoslovi != null && !oldIdPoslodavcaOfPosloviCollectionNewPoslovi.equals(poslodavac)) {
                        oldIdPoslodavcaOfPosloviCollectionNewPoslovi.getPosloviCollection().remove(posloviCollectionNewPoslovi);
                        oldIdPoslodavcaOfPosloviCollectionNewPoslovi = em.merge(oldIdPoslodavcaOfPosloviCollectionNewPoslovi);
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
                Integer id = poslodavac.getIdPoslodavca();
                if (findPoslodavac(id) == null) {
                    throw new NonexistentEntityException("The poslodavac with id " + id + " no longer exists.");
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
            Poslodavac poslodavac;
            try {
                poslodavac = em.getReference(Poslodavac.class, id);
                poslodavac.getIdPoslodavca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The poslodavac with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Poslovi> posloviCollectionOrphanCheck = poslodavac.getPosloviCollection();
            for (Poslovi posloviCollectionOrphanCheckPoslovi : posloviCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Poslodavac (" + poslodavac + ") cannot be destroyed since the Poslovi " + posloviCollectionOrphanCheckPoslovi + " in its posloviCollection field has a non-nullable idPoslodavca field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Korisnik idKorisnika = poslodavac.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika.getPoslodavacCollection().remove(poslodavac);
                idKorisnika = em.merge(idKorisnika);
            }
            Poruka idPoruke = poslodavac.getIdPoruke();
            if (idPoruke != null) {
                idPoruke.getPoslodavacCollection().remove(poslodavac);
                idPoruke = em.merge(idPoruke);
            }
            em.remove(poslodavac);
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

    public List<Poslodavac> findPoslodavacEntities() {
        return findPoslodavacEntities(true, -1, -1);
    }

    public List<Poslodavac> findPoslodavacEntities(int maxResults, int firstResult) {
        return findPoslodavacEntities(false, maxResults, firstResult);
    }

    private List<Poslodavac> findPoslodavacEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Poslodavac.class));
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

    public Poslodavac findPoslodavac(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Poslodavac.class, id);
        } finally {
            em.close();
        }
    }

    public int getPoslodavacCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Poslodavac> rt = cq.from(Poslodavac.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
