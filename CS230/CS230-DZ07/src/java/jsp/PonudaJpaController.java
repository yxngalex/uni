/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import entity.Ponuda;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Poslovi;
import entity.Radnik;
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
public class PonudaJpaController implements Serializable {

    public PonudaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ponuda ponuda) throws RollbackFailureException, Exception {
        if (ponuda.getRadnikCollection() == null) {
            ponuda.setRadnikCollection(new ArrayList<Radnik>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslovi idPosla = ponuda.getIdPosla();
            if (idPosla != null) {
                idPosla = em.getReference(idPosla.getClass(), idPosla.getIdPosla());
                ponuda.setIdPosla(idPosla);
            }
            Collection<Radnik> attachedRadnikCollection = new ArrayList<Radnik>();
            for (Radnik radnikCollectionRadnikToAttach : ponuda.getRadnikCollection()) {
                radnikCollectionRadnikToAttach = em.getReference(radnikCollectionRadnikToAttach.getClass(), radnikCollectionRadnikToAttach.getIdRadnika());
                attachedRadnikCollection.add(radnikCollectionRadnikToAttach);
            }
            ponuda.setRadnikCollection(attachedRadnikCollection);
            em.persist(ponuda);
            if (idPosla != null) {
                idPosla.getPonudaCollection().add(ponuda);
                idPosla = em.merge(idPosla);
            }
            for (Radnik radnikCollectionRadnik : ponuda.getRadnikCollection()) {
                Ponuda oldIdPonudeOfRadnikCollectionRadnik = radnikCollectionRadnik.getIdPonude();
                radnikCollectionRadnik.setIdPonude(ponuda);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
                if (oldIdPonudeOfRadnikCollectionRadnik != null) {
                    oldIdPonudeOfRadnikCollectionRadnik.getRadnikCollection().remove(radnikCollectionRadnik);
                    oldIdPonudeOfRadnikCollectionRadnik = em.merge(oldIdPonudeOfRadnikCollectionRadnik);
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

    public void edit(Ponuda ponuda) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Ponuda persistentPonuda = em.find(Ponuda.class, ponuda.getIdPonude());
            Poslovi idPoslaOld = persistentPonuda.getIdPosla();
            Poslovi idPoslaNew = ponuda.getIdPosla();
            Collection<Radnik> radnikCollectionOld = persistentPonuda.getRadnikCollection();
            Collection<Radnik> radnikCollectionNew = ponuda.getRadnikCollection();
            List<String> illegalOrphanMessages = null;
            for (Radnik radnikCollectionOldRadnik : radnikCollectionOld) {
                if (!radnikCollectionNew.contains(radnikCollectionOldRadnik)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Radnik " + radnikCollectionOldRadnik + " since its idPonude field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPoslaNew != null) {
                idPoslaNew = em.getReference(idPoslaNew.getClass(), idPoslaNew.getIdPosla());
                ponuda.setIdPosla(idPoslaNew);
            }
            Collection<Radnik> attachedRadnikCollectionNew = new ArrayList<Radnik>();
            for (Radnik radnikCollectionNewRadnikToAttach : radnikCollectionNew) {
                radnikCollectionNewRadnikToAttach = em.getReference(radnikCollectionNewRadnikToAttach.getClass(), radnikCollectionNewRadnikToAttach.getIdRadnika());
                attachedRadnikCollectionNew.add(radnikCollectionNewRadnikToAttach);
            }
            radnikCollectionNew = attachedRadnikCollectionNew;
            ponuda.setRadnikCollection(radnikCollectionNew);
            ponuda = em.merge(ponuda);
            if (idPoslaOld != null && !idPoslaOld.equals(idPoslaNew)) {
                idPoslaOld.getPonudaCollection().remove(ponuda);
                idPoslaOld = em.merge(idPoslaOld);
            }
            if (idPoslaNew != null && !idPoslaNew.equals(idPoslaOld)) {
                idPoslaNew.getPonudaCollection().add(ponuda);
                idPoslaNew = em.merge(idPoslaNew);
            }
            for (Radnik radnikCollectionNewRadnik : radnikCollectionNew) {
                if (!radnikCollectionOld.contains(radnikCollectionNewRadnik)) {
                    Ponuda oldIdPonudeOfRadnikCollectionNewRadnik = radnikCollectionNewRadnik.getIdPonude();
                    radnikCollectionNewRadnik.setIdPonude(ponuda);
                    radnikCollectionNewRadnik = em.merge(radnikCollectionNewRadnik);
                    if (oldIdPonudeOfRadnikCollectionNewRadnik != null && !oldIdPonudeOfRadnikCollectionNewRadnik.equals(ponuda)) {
                        oldIdPonudeOfRadnikCollectionNewRadnik.getRadnikCollection().remove(radnikCollectionNewRadnik);
                        oldIdPonudeOfRadnikCollectionNewRadnik = em.merge(oldIdPonudeOfRadnikCollectionNewRadnik);
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
                Integer id = ponuda.getIdPonude();
                if (findPonuda(id) == null) {
                    throw new NonexistentEntityException("The ponuda with id " + id + " no longer exists.");
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
            Ponuda ponuda;
            try {
                ponuda = em.getReference(Ponuda.class, id);
                ponuda.getIdPonude();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ponuda with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Radnik> radnikCollectionOrphanCheck = ponuda.getRadnikCollection();
            for (Radnik radnikCollectionOrphanCheckRadnik : radnikCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ponuda (" + ponuda + ") cannot be destroyed since the Radnik " + radnikCollectionOrphanCheckRadnik + " in its radnikCollection field has a non-nullable idPonude field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Poslovi idPosla = ponuda.getIdPosla();
            if (idPosla != null) {
                idPosla.getPonudaCollection().remove(ponuda);
                idPosla = em.merge(idPosla);
            }
            em.remove(ponuda);
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

    public List<Ponuda> findPonudaEntities() {
        return findPonudaEntities(true, -1, -1);
    }

    public List<Ponuda> findPonudaEntities(int maxResults, int firstResult) {
        return findPonudaEntities(false, maxResults, firstResult);
    }

    private List<Ponuda> findPonudaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ponuda.class));
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

    public Ponuda findPonuda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ponuda.class, id);
        } finally {
            em.close();
        }
    }

    public int getPonudaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ponuda> rt = cq.from(Ponuda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
