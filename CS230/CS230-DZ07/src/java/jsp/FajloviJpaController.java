/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import entity.Fajlovi;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Radnik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import jsp.exceptions.NonexistentEntityException;
import jsp.exceptions.RollbackFailureException;

/**
 *
 * @author aleks
 */
public class FajloviJpaController implements Serializable {

    public FajloviJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fajlovi fajlovi) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Radnik idRadnika = fajlovi.getIdRadnika();
            if (idRadnika != null) {
                idRadnika = em.getReference(idRadnika.getClass(), idRadnika.getIdRadnika());
                fajlovi.setIdRadnika(idRadnika);
            }
            em.persist(fajlovi);
            if (idRadnika != null) {
                idRadnika.getFajloviCollection().add(fajlovi);
                idRadnika = em.merge(idRadnika);
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

    public void edit(Fajlovi fajlovi) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Fajlovi persistentFajlovi = em.find(Fajlovi.class, fajlovi.getIdFajla());
            Radnik idRadnikaOld = persistentFajlovi.getIdRadnika();
            Radnik idRadnikaNew = fajlovi.getIdRadnika();
            if (idRadnikaNew != null) {
                idRadnikaNew = em.getReference(idRadnikaNew.getClass(), idRadnikaNew.getIdRadnika());
                fajlovi.setIdRadnika(idRadnikaNew);
            }
            fajlovi = em.merge(fajlovi);
            if (idRadnikaOld != null && !idRadnikaOld.equals(idRadnikaNew)) {
                idRadnikaOld.getFajloviCollection().remove(fajlovi);
                idRadnikaOld = em.merge(idRadnikaOld);
            }
            if (idRadnikaNew != null && !idRadnikaNew.equals(idRadnikaOld)) {
                idRadnikaNew.getFajloviCollection().add(fajlovi);
                idRadnikaNew = em.merge(idRadnikaNew);
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
                Integer id = fajlovi.getIdFajla();
                if (findFajlovi(id) == null) {
                    throw new NonexistentEntityException("The fajlovi with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Fajlovi fajlovi;
            try {
                fajlovi = em.getReference(Fajlovi.class, id);
                fajlovi.getIdFajla();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fajlovi with id " + id + " no longer exists.", enfe);
            }
            Radnik idRadnika = fajlovi.getIdRadnika();
            if (idRadnika != null) {
                idRadnika.getFajloviCollection().remove(fajlovi);
                idRadnika = em.merge(idRadnika);
            }
            em.remove(fajlovi);
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

    public List<Fajlovi> findFajloviEntities() {
        return findFajloviEntities(true, -1, -1);
    }

    public List<Fajlovi> findFajloviEntities(int maxResults, int firstResult) {
        return findFajloviEntities(false, maxResults, firstResult);
    }

    private List<Fajlovi> findFajloviEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fajlovi.class));
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

    public Fajlovi findFajlovi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fajlovi.class, id);
        } finally {
            em.close();
        }
    }

    public int getFajloviCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fajlovi> rt = cq.from(Fajlovi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
