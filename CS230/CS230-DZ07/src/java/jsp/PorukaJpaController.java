/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import entity.Poruka;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Radnik;
import java.util.ArrayList;
import java.util.Collection;
import entity.Poslodavac;
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
public class PorukaJpaController implements Serializable {

    public PorukaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Poruka poruka) throws RollbackFailureException, Exception {
        if (poruka.getRadnikCollection() == null) {
            poruka.setRadnikCollection(new ArrayList<Radnik>());
        }
        if (poruka.getPoslodavacCollection() == null) {
            poruka.setPoslodavacCollection(new ArrayList<Poslodavac>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Radnik> attachedRadnikCollection = new ArrayList<Radnik>();
            for (Radnik radnikCollectionRadnikToAttach : poruka.getRadnikCollection()) {
                radnikCollectionRadnikToAttach = em.getReference(radnikCollectionRadnikToAttach.getClass(), radnikCollectionRadnikToAttach.getIdRadnika());
                attachedRadnikCollection.add(radnikCollectionRadnikToAttach);
            }
            poruka.setRadnikCollection(attachedRadnikCollection);
            Collection<Poslodavac> attachedPoslodavacCollection = new ArrayList<Poslodavac>();
            for (Poslodavac poslodavacCollectionPoslodavacToAttach : poruka.getPoslodavacCollection()) {
                poslodavacCollectionPoslodavacToAttach = em.getReference(poslodavacCollectionPoslodavacToAttach.getClass(), poslodavacCollectionPoslodavacToAttach.getIdPoslodavca());
                attachedPoslodavacCollection.add(poslodavacCollectionPoslodavacToAttach);
            }
            poruka.setPoslodavacCollection(attachedPoslodavacCollection);
            em.persist(poruka);
            for (Radnik radnikCollectionRadnik : poruka.getRadnikCollection()) {
                Poruka oldIdPorukeOfRadnikCollectionRadnik = radnikCollectionRadnik.getIdPoruke();
                radnikCollectionRadnik.setIdPoruke(poruka);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
                if (oldIdPorukeOfRadnikCollectionRadnik != null) {
                    oldIdPorukeOfRadnikCollectionRadnik.getRadnikCollection().remove(radnikCollectionRadnik);
                    oldIdPorukeOfRadnikCollectionRadnik = em.merge(oldIdPorukeOfRadnikCollectionRadnik);
                }
            }
            for (Poslodavac poslodavacCollectionPoslodavac : poruka.getPoslodavacCollection()) {
                Poruka oldIdPorukeOfPoslodavacCollectionPoslodavac = poslodavacCollectionPoslodavac.getIdPoruke();
                poslodavacCollectionPoslodavac.setIdPoruke(poruka);
                poslodavacCollectionPoslodavac = em.merge(poslodavacCollectionPoslodavac);
                if (oldIdPorukeOfPoslodavacCollectionPoslodavac != null) {
                    oldIdPorukeOfPoslodavacCollectionPoslodavac.getPoslodavacCollection().remove(poslodavacCollectionPoslodavac);
                    oldIdPorukeOfPoslodavacCollectionPoslodavac = em.merge(oldIdPorukeOfPoslodavacCollectionPoslodavac);
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

    public void edit(Poruka poruka) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poruka persistentPoruka = em.find(Poruka.class, poruka.getIdPoruke());
            Collection<Radnik> radnikCollectionOld = persistentPoruka.getRadnikCollection();
            Collection<Radnik> radnikCollectionNew = poruka.getRadnikCollection();
            Collection<Poslodavac> poslodavacCollectionOld = persistentPoruka.getPoslodavacCollection();
            Collection<Poslodavac> poslodavacCollectionNew = poruka.getPoslodavacCollection();
            Collection<Radnik> attachedRadnikCollectionNew = new ArrayList<Radnik>();
            for (Radnik radnikCollectionNewRadnikToAttach : radnikCollectionNew) {
                radnikCollectionNewRadnikToAttach = em.getReference(radnikCollectionNewRadnikToAttach.getClass(), radnikCollectionNewRadnikToAttach.getIdRadnika());
                attachedRadnikCollectionNew.add(radnikCollectionNewRadnikToAttach);
            }
            radnikCollectionNew = attachedRadnikCollectionNew;
            poruka.setRadnikCollection(radnikCollectionNew);
            Collection<Poslodavac> attachedPoslodavacCollectionNew = new ArrayList<Poslodavac>();
            for (Poslodavac poslodavacCollectionNewPoslodavacToAttach : poslodavacCollectionNew) {
                poslodavacCollectionNewPoslodavacToAttach = em.getReference(poslodavacCollectionNewPoslodavacToAttach.getClass(), poslodavacCollectionNewPoslodavacToAttach.getIdPoslodavca());
                attachedPoslodavacCollectionNew.add(poslodavacCollectionNewPoslodavacToAttach);
            }
            poslodavacCollectionNew = attachedPoslodavacCollectionNew;
            poruka.setPoslodavacCollection(poslodavacCollectionNew);
            poruka = em.merge(poruka);
            for (Radnik radnikCollectionOldRadnik : radnikCollectionOld) {
                if (!radnikCollectionNew.contains(radnikCollectionOldRadnik)) {
                    radnikCollectionOldRadnik.setIdPoruke(null);
                    radnikCollectionOldRadnik = em.merge(radnikCollectionOldRadnik);
                }
            }
            for (Radnik radnikCollectionNewRadnik : radnikCollectionNew) {
                if (!radnikCollectionOld.contains(radnikCollectionNewRadnik)) {
                    Poruka oldIdPorukeOfRadnikCollectionNewRadnik = radnikCollectionNewRadnik.getIdPoruke();
                    radnikCollectionNewRadnik.setIdPoruke(poruka);
                    radnikCollectionNewRadnik = em.merge(radnikCollectionNewRadnik);
                    if (oldIdPorukeOfRadnikCollectionNewRadnik != null && !oldIdPorukeOfRadnikCollectionNewRadnik.equals(poruka)) {
                        oldIdPorukeOfRadnikCollectionNewRadnik.getRadnikCollection().remove(radnikCollectionNewRadnik);
                        oldIdPorukeOfRadnikCollectionNewRadnik = em.merge(oldIdPorukeOfRadnikCollectionNewRadnik);
                    }
                }
            }
            for (Poslodavac poslodavacCollectionOldPoslodavac : poslodavacCollectionOld) {
                if (!poslodavacCollectionNew.contains(poslodavacCollectionOldPoslodavac)) {
                    poslodavacCollectionOldPoslodavac.setIdPoruke(null);
                    poslodavacCollectionOldPoslodavac = em.merge(poslodavacCollectionOldPoslodavac);
                }
            }
            for (Poslodavac poslodavacCollectionNewPoslodavac : poslodavacCollectionNew) {
                if (!poslodavacCollectionOld.contains(poslodavacCollectionNewPoslodavac)) {
                    Poruka oldIdPorukeOfPoslodavacCollectionNewPoslodavac = poslodavacCollectionNewPoslodavac.getIdPoruke();
                    poslodavacCollectionNewPoslodavac.setIdPoruke(poruka);
                    poslodavacCollectionNewPoslodavac = em.merge(poslodavacCollectionNewPoslodavac);
                    if (oldIdPorukeOfPoslodavacCollectionNewPoslodavac != null && !oldIdPorukeOfPoslodavacCollectionNewPoslodavac.equals(poruka)) {
                        oldIdPorukeOfPoslodavacCollectionNewPoslodavac.getPoslodavacCollection().remove(poslodavacCollectionNewPoslodavac);
                        oldIdPorukeOfPoslodavacCollectionNewPoslodavac = em.merge(oldIdPorukeOfPoslodavacCollectionNewPoslodavac);
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
                Integer id = poruka.getIdPoruke();
                if (findPoruka(id) == null) {
                    throw new NonexistentEntityException("The poruka with id " + id + " no longer exists.");
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
            Poruka poruka;
            try {
                poruka = em.getReference(Poruka.class, id);
                poruka.getIdPoruke();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The poruka with id " + id + " no longer exists.", enfe);
            }
            Collection<Radnik> radnikCollection = poruka.getRadnikCollection();
            for (Radnik radnikCollectionRadnik : radnikCollection) {
                radnikCollectionRadnik.setIdPoruke(null);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
            }
            Collection<Poslodavac> poslodavacCollection = poruka.getPoslodavacCollection();
            for (Poslodavac poslodavacCollectionPoslodavac : poslodavacCollection) {
                poslodavacCollectionPoslodavac.setIdPoruke(null);
                poslodavacCollectionPoslodavac = em.merge(poslodavacCollectionPoslodavac);
            }
            em.remove(poruka);
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

    public List<Poruka> findPorukaEntities() {
        return findPorukaEntities(true, -1, -1);
    }

    public List<Poruka> findPorukaEntities(int maxResults, int firstResult) {
        return findPorukaEntities(false, maxResults, firstResult);
    }

    private List<Poruka> findPorukaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Poruka.class));
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

    public Poruka findPoruka(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Poruka.class, id);
        } finally {
            em.close();
        }
    }

    public int getPorukaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Poruka> rt = cq.from(Poruka.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
