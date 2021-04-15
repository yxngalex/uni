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
import entity.Poslodavac;
import entity.Radnik;
import java.util.ArrayList;
import java.util.Collection;
import entity.Ponuda;
import entity.Ocena;
import entity.Poslovi;
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
public class PosloviJpaController implements Serializable {

    public PosloviJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Poslovi poslovi) throws RollbackFailureException, Exception {
        if (poslovi.getRadnikCollection() == null) {
            poslovi.setRadnikCollection(new ArrayList<Radnik>());
        }
        if (poslovi.getPonudaCollection() == null) {
            poslovi.setPonudaCollection(new ArrayList<Ponuda>());
        }
        if (poslovi.getOcenaCollection() == null) {
            poslovi.setOcenaCollection(new ArrayList<Ocena>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslodavac idPoslodavca = poslovi.getIdPoslodavca();
            if (idPoslodavca != null) {
                idPoslodavca = em.getReference(idPoslodavca.getClass(), idPoslodavca.getIdPoslodavca());
                poslovi.setIdPoslodavca(idPoslodavca);
            }
            Collection<Radnik> attachedRadnikCollection = new ArrayList<Radnik>();
            for (Radnik radnikCollectionRadnikToAttach : poslovi.getRadnikCollection()) {
                radnikCollectionRadnikToAttach = em.getReference(radnikCollectionRadnikToAttach.getClass(), radnikCollectionRadnikToAttach.getIdRadnika());
                attachedRadnikCollection.add(radnikCollectionRadnikToAttach);
            }
            poslovi.setRadnikCollection(attachedRadnikCollection);
            Collection<Ponuda> attachedPonudaCollection = new ArrayList<Ponuda>();
            for (Ponuda ponudaCollectionPonudaToAttach : poslovi.getPonudaCollection()) {
                ponudaCollectionPonudaToAttach = em.getReference(ponudaCollectionPonudaToAttach.getClass(), ponudaCollectionPonudaToAttach.getIdPonude());
                attachedPonudaCollection.add(ponudaCollectionPonudaToAttach);
            }
            poslovi.setPonudaCollection(attachedPonudaCollection);
            Collection<Ocena> attachedOcenaCollection = new ArrayList<Ocena>();
            for (Ocena ocenaCollectionOcenaToAttach : poslovi.getOcenaCollection()) {
                ocenaCollectionOcenaToAttach = em.getReference(ocenaCollectionOcenaToAttach.getClass(), ocenaCollectionOcenaToAttach.getIdOcene());
                attachedOcenaCollection.add(ocenaCollectionOcenaToAttach);
            }
            poslovi.setOcenaCollection(attachedOcenaCollection);
            em.persist(poslovi);
            if (idPoslodavca != null) {
                idPoslodavca.getPosloviCollection().add(poslovi);
                idPoslodavca = em.merge(idPoslodavca);
            }
            for (Radnik radnikCollectionRadnik : poslovi.getRadnikCollection()) {
                Poslovi oldIdPoslaOfRadnikCollectionRadnik = radnikCollectionRadnik.getIdPosla();
                radnikCollectionRadnik.setIdPosla(poslovi);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
                if (oldIdPoslaOfRadnikCollectionRadnik != null) {
                    oldIdPoslaOfRadnikCollectionRadnik.getRadnikCollection().remove(radnikCollectionRadnik);
                    oldIdPoslaOfRadnikCollectionRadnik = em.merge(oldIdPoslaOfRadnikCollectionRadnik);
                }
            }
            for (Ponuda ponudaCollectionPonuda : poslovi.getPonudaCollection()) {
                Poslovi oldIdPoslaOfPonudaCollectionPonuda = ponudaCollectionPonuda.getIdPosla();
                ponudaCollectionPonuda.setIdPosla(poslovi);
                ponudaCollectionPonuda = em.merge(ponudaCollectionPonuda);
                if (oldIdPoslaOfPonudaCollectionPonuda != null) {
                    oldIdPoslaOfPonudaCollectionPonuda.getPonudaCollection().remove(ponudaCollectionPonuda);
                    oldIdPoslaOfPonudaCollectionPonuda = em.merge(oldIdPoslaOfPonudaCollectionPonuda);
                }
            }
            for (Ocena ocenaCollectionOcena : poslovi.getOcenaCollection()) {
                Poslovi oldIdPoslaOfOcenaCollectionOcena = ocenaCollectionOcena.getIdPosla();
                ocenaCollectionOcena.setIdPosla(poslovi);
                ocenaCollectionOcena = em.merge(ocenaCollectionOcena);
                if (oldIdPoslaOfOcenaCollectionOcena != null) {
                    oldIdPoslaOfOcenaCollectionOcena.getOcenaCollection().remove(ocenaCollectionOcena);
                    oldIdPoslaOfOcenaCollectionOcena = em.merge(oldIdPoslaOfOcenaCollectionOcena);
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

    public void edit(Poslovi poslovi) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslovi persistentPoslovi = em.find(Poslovi.class, poslovi.getIdPosla());
            Poslodavac idPoslodavcaOld = persistentPoslovi.getIdPoslodavca();
            Poslodavac idPoslodavcaNew = poslovi.getIdPoslodavca();
            Collection<Radnik> radnikCollectionOld = persistentPoslovi.getRadnikCollection();
            Collection<Radnik> radnikCollectionNew = poslovi.getRadnikCollection();
            Collection<Ponuda> ponudaCollectionOld = persistentPoslovi.getPonudaCollection();
            Collection<Ponuda> ponudaCollectionNew = poslovi.getPonudaCollection();
            Collection<Ocena> ocenaCollectionOld = persistentPoslovi.getOcenaCollection();
            Collection<Ocena> ocenaCollectionNew = poslovi.getOcenaCollection();
            List<String> illegalOrphanMessages = null;
            for (Ponuda ponudaCollectionOldPonuda : ponudaCollectionOld) {
                if (!ponudaCollectionNew.contains(ponudaCollectionOldPonuda)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ponuda " + ponudaCollectionOldPonuda + " since its idPosla field is not nullable.");
                }
            }
            for (Ocena ocenaCollectionOldOcena : ocenaCollectionOld) {
                if (!ocenaCollectionNew.contains(ocenaCollectionOldOcena)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ocena " + ocenaCollectionOldOcena + " since its idPosla field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPoslodavcaNew != null) {
                idPoslodavcaNew = em.getReference(idPoslodavcaNew.getClass(), idPoslodavcaNew.getIdPoslodavca());
                poslovi.setIdPoslodavca(idPoslodavcaNew);
            }
            Collection<Radnik> attachedRadnikCollectionNew = new ArrayList<Radnik>();
            for (Radnik radnikCollectionNewRadnikToAttach : radnikCollectionNew) {
                radnikCollectionNewRadnikToAttach = em.getReference(radnikCollectionNewRadnikToAttach.getClass(), radnikCollectionNewRadnikToAttach.getIdRadnika());
                attachedRadnikCollectionNew.add(radnikCollectionNewRadnikToAttach);
            }
            radnikCollectionNew = attachedRadnikCollectionNew;
            poslovi.setRadnikCollection(radnikCollectionNew);
            Collection<Ponuda> attachedPonudaCollectionNew = new ArrayList<Ponuda>();
            for (Ponuda ponudaCollectionNewPonudaToAttach : ponudaCollectionNew) {
                ponudaCollectionNewPonudaToAttach = em.getReference(ponudaCollectionNewPonudaToAttach.getClass(), ponudaCollectionNewPonudaToAttach.getIdPonude());
                attachedPonudaCollectionNew.add(ponudaCollectionNewPonudaToAttach);
            }
            ponudaCollectionNew = attachedPonudaCollectionNew;
            poslovi.setPonudaCollection(ponudaCollectionNew);
            Collection<Ocena> attachedOcenaCollectionNew = new ArrayList<Ocena>();
            for (Ocena ocenaCollectionNewOcenaToAttach : ocenaCollectionNew) {
                ocenaCollectionNewOcenaToAttach = em.getReference(ocenaCollectionNewOcenaToAttach.getClass(), ocenaCollectionNewOcenaToAttach.getIdOcene());
                attachedOcenaCollectionNew.add(ocenaCollectionNewOcenaToAttach);
            }
            ocenaCollectionNew = attachedOcenaCollectionNew;
            poslovi.setOcenaCollection(ocenaCollectionNew);
            poslovi = em.merge(poslovi);
            if (idPoslodavcaOld != null && !idPoslodavcaOld.equals(idPoslodavcaNew)) {
                idPoslodavcaOld.getPosloviCollection().remove(poslovi);
                idPoslodavcaOld = em.merge(idPoslodavcaOld);
            }
            if (idPoslodavcaNew != null && !idPoslodavcaNew.equals(idPoslodavcaOld)) {
                idPoslodavcaNew.getPosloviCollection().add(poslovi);
                idPoslodavcaNew = em.merge(idPoslodavcaNew);
            }
            for (Radnik radnikCollectionOldRadnik : radnikCollectionOld) {
                if (!radnikCollectionNew.contains(radnikCollectionOldRadnik)) {
                    radnikCollectionOldRadnik.setIdPosla(null);
                    radnikCollectionOldRadnik = em.merge(radnikCollectionOldRadnik);
                }
            }
            for (Radnik radnikCollectionNewRadnik : radnikCollectionNew) {
                if (!radnikCollectionOld.contains(radnikCollectionNewRadnik)) {
                    Poslovi oldIdPoslaOfRadnikCollectionNewRadnik = radnikCollectionNewRadnik.getIdPosla();
                    radnikCollectionNewRadnik.setIdPosla(poslovi);
                    radnikCollectionNewRadnik = em.merge(radnikCollectionNewRadnik);
                    if (oldIdPoslaOfRadnikCollectionNewRadnik != null && !oldIdPoslaOfRadnikCollectionNewRadnik.equals(poslovi)) {
                        oldIdPoslaOfRadnikCollectionNewRadnik.getRadnikCollection().remove(radnikCollectionNewRadnik);
                        oldIdPoslaOfRadnikCollectionNewRadnik = em.merge(oldIdPoslaOfRadnikCollectionNewRadnik);
                    }
                }
            }
            for (Ponuda ponudaCollectionNewPonuda : ponudaCollectionNew) {
                if (!ponudaCollectionOld.contains(ponudaCollectionNewPonuda)) {
                    Poslovi oldIdPoslaOfPonudaCollectionNewPonuda = ponudaCollectionNewPonuda.getIdPosla();
                    ponudaCollectionNewPonuda.setIdPosla(poslovi);
                    ponudaCollectionNewPonuda = em.merge(ponudaCollectionNewPonuda);
                    if (oldIdPoslaOfPonudaCollectionNewPonuda != null && !oldIdPoslaOfPonudaCollectionNewPonuda.equals(poslovi)) {
                        oldIdPoslaOfPonudaCollectionNewPonuda.getPonudaCollection().remove(ponudaCollectionNewPonuda);
                        oldIdPoslaOfPonudaCollectionNewPonuda = em.merge(oldIdPoslaOfPonudaCollectionNewPonuda);
                    }
                }
            }
            for (Ocena ocenaCollectionNewOcena : ocenaCollectionNew) {
                if (!ocenaCollectionOld.contains(ocenaCollectionNewOcena)) {
                    Poslovi oldIdPoslaOfOcenaCollectionNewOcena = ocenaCollectionNewOcena.getIdPosla();
                    ocenaCollectionNewOcena.setIdPosla(poslovi);
                    ocenaCollectionNewOcena = em.merge(ocenaCollectionNewOcena);
                    if (oldIdPoslaOfOcenaCollectionNewOcena != null && !oldIdPoslaOfOcenaCollectionNewOcena.equals(poslovi)) {
                        oldIdPoslaOfOcenaCollectionNewOcena.getOcenaCollection().remove(ocenaCollectionNewOcena);
                        oldIdPoslaOfOcenaCollectionNewOcena = em.merge(oldIdPoslaOfOcenaCollectionNewOcena);
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
                Integer id = poslovi.getIdPosla();
                if (findPoslovi(id) == null) {
                    throw new NonexistentEntityException("The poslovi with id " + id + " no longer exists.");
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
            Poslovi poslovi;
            try {
                poslovi = em.getReference(Poslovi.class, id);
                poslovi.getIdPosla();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The poslovi with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ponuda> ponudaCollectionOrphanCheck = poslovi.getPonudaCollection();
            for (Ponuda ponudaCollectionOrphanCheckPonuda : ponudaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Poslovi (" + poslovi + ") cannot be destroyed since the Ponuda " + ponudaCollectionOrphanCheckPonuda + " in its ponudaCollection field has a non-nullable idPosla field.");
            }
            Collection<Ocena> ocenaCollectionOrphanCheck = poslovi.getOcenaCollection();
            for (Ocena ocenaCollectionOrphanCheckOcena : ocenaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Poslovi (" + poslovi + ") cannot be destroyed since the Ocena " + ocenaCollectionOrphanCheckOcena + " in its ocenaCollection field has a non-nullable idPosla field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Poslodavac idPoslodavca = poslovi.getIdPoslodavca();
            if (idPoslodavca != null) {
                idPoslodavca.getPosloviCollection().remove(poslovi);
                idPoslodavca = em.merge(idPoslodavca);
            }
            Collection<Radnik> radnikCollection = poslovi.getRadnikCollection();
            for (Radnik radnikCollectionRadnik : radnikCollection) {
                radnikCollectionRadnik.setIdPosla(null);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
            }
            em.remove(poslovi);
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

    public List<Poslovi> findPosloviEntities() {
        return findPosloviEntities(true, -1, -1);
    }

    public List<Poslovi> findPosloviEntities(int maxResults, int firstResult) {
        return findPosloviEntities(false, maxResults, firstResult);
    }

    private List<Poslovi> findPosloviEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Poslovi.class));
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

    public Poslovi findPoslovi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Poslovi.class, id);
        } finally {
            em.close();
        }
    }

    public int getPosloviCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Poslovi> rt = cq.from(Poslovi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
