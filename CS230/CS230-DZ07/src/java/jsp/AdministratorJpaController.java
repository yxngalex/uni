/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import entity.Administrator;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Korisnik;
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
public class AdministratorJpaController implements Serializable {

    public AdministratorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrator administrator) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Korisnik idKorisnika = administrator.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika = em.getReference(idKorisnika.getClass(), idKorisnika.getIdKorisnika());
                administrator.setIdKorisnika(idKorisnika);
            }
            em.persist(administrator);
            if (idKorisnika != null) {
                idKorisnika.getAdministratorCollection().add(administrator);
                idKorisnika = em.merge(idKorisnika);
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

    public void edit(Administrator administrator) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Administrator persistentAdministrator = em.find(Administrator.class, administrator.getIdAdministartora());
            Korisnik idKorisnikaOld = persistentAdministrator.getIdKorisnika();
            Korisnik idKorisnikaNew = administrator.getIdKorisnika();
            if (idKorisnikaNew != null) {
                idKorisnikaNew = em.getReference(idKorisnikaNew.getClass(), idKorisnikaNew.getIdKorisnika());
                administrator.setIdKorisnika(idKorisnikaNew);
            }
            administrator = em.merge(administrator);
            if (idKorisnikaOld != null && !idKorisnikaOld.equals(idKorisnikaNew)) {
                idKorisnikaOld.getAdministratorCollection().remove(administrator);
                idKorisnikaOld = em.merge(idKorisnikaOld);
            }
            if (idKorisnikaNew != null && !idKorisnikaNew.equals(idKorisnikaOld)) {
                idKorisnikaNew.getAdministratorCollection().add(administrator);
                idKorisnikaNew = em.merge(idKorisnikaNew);
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
                Integer id = administrator.getIdAdministartora();
                if (findAdministrator(id) == null) {
                    throw new NonexistentEntityException("The administrator with id " + id + " no longer exists.");
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
            Administrator administrator;
            try {
                administrator = em.getReference(Administrator.class, id);
                administrator.getIdAdministartora();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrator with id " + id + " no longer exists.", enfe);
            }
            Korisnik idKorisnika = administrator.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika.getAdministratorCollection().remove(administrator);
                idKorisnika = em.merge(idKorisnika);
            }
            em.remove(administrator);
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

    public List<Administrator> findAdministratorEntities() {
        return findAdministratorEntities(true, -1, -1);
    }

    public List<Administrator> findAdministratorEntities(int maxResults, int firstResult) {
        return findAdministratorEntities(false, maxResults, firstResult);
    }

    private List<Administrator> findAdministratorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrator.class));
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

    public Administrator findAdministrator(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrator.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministratorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrator> rt = cq.from(Administrator.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
