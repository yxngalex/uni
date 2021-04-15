/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import entity.Ocena;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Poslovi;
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
public class OcenaJpaController implements Serializable {

    public OcenaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ocena ocena) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslovi idPosla = ocena.getIdPosla();
            if (idPosla != null) {
                idPosla = em.getReference(idPosla.getClass(), idPosla.getIdPosla());
                ocena.setIdPosla(idPosla);
            }
            Radnik idRadnika = ocena.getIdRadnika();
            if (idRadnika != null) {
                idRadnika = em.getReference(idRadnika.getClass(), idRadnika.getIdRadnika());
                ocena.setIdRadnika(idRadnika);
            }
            em.persist(ocena);
            if (idPosla != null) {
                idPosla.getOcenaCollection().add(ocena);
                idPosla = em.merge(idPosla);
            }
            if (idRadnika != null) {
                idRadnika.getOcenaCollection().add(ocena);
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

    public void edit(Ocena ocena) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Ocena persistentOcena = em.find(Ocena.class, ocena.getIdOcene());
            Poslovi idPoslaOld = persistentOcena.getIdPosla();
            Poslovi idPoslaNew = ocena.getIdPosla();
            Radnik idRadnikaOld = persistentOcena.getIdRadnika();
            Radnik idRadnikaNew = ocena.getIdRadnika();
            if (idPoslaNew != null) {
                idPoslaNew = em.getReference(idPoslaNew.getClass(), idPoslaNew.getIdPosla());
                ocena.setIdPosla(idPoslaNew);
            }
            if (idRadnikaNew != null) {
                idRadnikaNew = em.getReference(idRadnikaNew.getClass(), idRadnikaNew.getIdRadnika());
                ocena.setIdRadnika(idRadnikaNew);
            }
            ocena = em.merge(ocena);
            if (idPoslaOld != null && !idPoslaOld.equals(idPoslaNew)) {
                idPoslaOld.getOcenaCollection().remove(ocena);
                idPoslaOld = em.merge(idPoslaOld);
            }
            if (idPoslaNew != null && !idPoslaNew.equals(idPoslaOld)) {
                idPoslaNew.getOcenaCollection().add(ocena);
                idPoslaNew = em.merge(idPoslaNew);
            }
            if (idRadnikaOld != null && !idRadnikaOld.equals(idRadnikaNew)) {
                idRadnikaOld.getOcenaCollection().remove(ocena);
                idRadnikaOld = em.merge(idRadnikaOld);
            }
            if (idRadnikaNew != null && !idRadnikaNew.equals(idRadnikaOld)) {
                idRadnikaNew.getOcenaCollection().add(ocena);
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
                Integer id = ocena.getIdOcene();
                if (findOcena(id) == null) {
                    throw new NonexistentEntityException("The ocena with id " + id + " no longer exists.");
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
            Ocena ocena;
            try {
                ocena = em.getReference(Ocena.class, id);
                ocena.getIdOcene();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ocena with id " + id + " no longer exists.", enfe);
            }
            Poslovi idPosla = ocena.getIdPosla();
            if (idPosla != null) {
                idPosla.getOcenaCollection().remove(ocena);
                idPosla = em.merge(idPosla);
            }
            Radnik idRadnika = ocena.getIdRadnika();
            if (idRadnika != null) {
                idRadnika.getOcenaCollection().remove(ocena);
                idRadnika = em.merge(idRadnika);
            }
            em.remove(ocena);
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

    public List<Ocena> findOcenaEntities() {
        return findOcenaEntities(true, -1, -1);
    }

    public List<Ocena> findOcenaEntities(int maxResults, int firstResult) {
        return findOcenaEntities(false, maxResults, firstResult);
    }

    private List<Ocena> findOcenaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ocena.class));
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

    public Ocena findOcena(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ocena.class, id);
        } finally {
            em.close();
        }
    }

    public int getOcenaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ocena> rt = cq.from(Ocena.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
