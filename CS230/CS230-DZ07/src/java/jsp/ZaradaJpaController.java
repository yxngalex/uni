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
import entity.Radnik;
import entity.Zarada;
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
public class ZaradaJpaController implements Serializable {

    public ZaradaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Zarada zarada) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Radnik idRadnika = zarada.getIdRadnika();
            if (idRadnika != null) {
                idRadnika = em.getReference(idRadnika.getClass(), idRadnika.getIdRadnika());
                zarada.setIdRadnika(idRadnika);
            }
            em.persist(zarada);
            if (idRadnika != null) {
                idRadnika.getZaradaCollection().add(zarada);
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

    public void edit(Zarada zarada) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Zarada persistentZarada = em.find(Zarada.class, zarada.getIdZarade());
            Radnik idRadnikaOld = persistentZarada.getIdRadnika();
            Radnik idRadnikaNew = zarada.getIdRadnika();
            if (idRadnikaNew != null) {
                idRadnikaNew = em.getReference(idRadnikaNew.getClass(), idRadnikaNew.getIdRadnika());
                zarada.setIdRadnika(idRadnikaNew);
            }
            zarada = em.merge(zarada);
            if (idRadnikaOld != null && !idRadnikaOld.equals(idRadnikaNew)) {
                idRadnikaOld.getZaradaCollection().remove(zarada);
                idRadnikaOld = em.merge(idRadnikaOld);
            }
            if (idRadnikaNew != null && !idRadnikaNew.equals(idRadnikaOld)) {
                idRadnikaNew.getZaradaCollection().add(zarada);
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
                Integer id = zarada.getIdZarade();
                if (findZarada(id) == null) {
                    throw new NonexistentEntityException("The zarada with id " + id + " no longer exists.");
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
            Zarada zarada;
            try {
                zarada = em.getReference(Zarada.class, id);
                zarada.getIdZarade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The zarada with id " + id + " no longer exists.", enfe);
            }
            Radnik idRadnika = zarada.getIdRadnika();
            if (idRadnika != null) {
                idRadnika.getZaradaCollection().remove(zarada);
                idRadnika = em.merge(idRadnika);
            }
            em.remove(zarada);
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

    public List<Zarada> findZaradaEntities() {
        return findZaradaEntities(true, -1, -1);
    }

    public List<Zarada> findZaradaEntities(int maxResults, int firstResult) {
        return findZaradaEntities(false, maxResults, firstResult);
    }

    private List<Zarada> findZaradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Zarada.class));
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

    public Zarada findZarada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zarada.class, id);
        } finally {
            em.close();
        }
    }

    public int getZaradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Zarada> rt = cq.from(Zarada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
