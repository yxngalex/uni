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
import entity.Poslovi;
import entity.Ponuda;
import entity.Poruka;
import entity.Korisnik;
import entity.Radnik;
import java.util.ArrayList;
import java.util.Collection;
import entity.Zarada;
import entity.Ocena;
import entity.Fajlovi;
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
public class RadnikJpaController implements Serializable {

    public RadnikJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Radnik radnik) throws RollbackFailureException, Exception {
        if (radnik.getRadnikCollection() == null) {
            radnik.setRadnikCollection(new ArrayList<Radnik>());
        }
        if (radnik.getZaradaCollection() == null) {
            radnik.setZaradaCollection(new ArrayList<Zarada>());
        }
        if (radnik.getOcenaCollection() == null) {
            radnik.setOcenaCollection(new ArrayList<Ocena>());
        }
        if (radnik.getFajloviCollection() == null) {
            radnik.setFajloviCollection(new ArrayList<Fajlovi>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Poslovi idPosla = radnik.getIdPosla();
            if (idPosla != null) {
                idPosla = em.getReference(idPosla.getClass(), idPosla.getIdPosla());
                radnik.setIdPosla(idPosla);
            }
            Ponuda idPonude = radnik.getIdPonude();
            if (idPonude != null) {
                idPonude = em.getReference(idPonude.getClass(), idPonude.getIdPonude());
                radnik.setIdPonude(idPonude);
            }
            Poruka idPoruke = radnik.getIdPoruke();
            if (idPoruke != null) {
                idPoruke = em.getReference(idPoruke.getClass(), idPoruke.getIdPoruke());
                radnik.setIdPoruke(idPoruke);
            }
            Korisnik idKorisnika = radnik.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika = em.getReference(idKorisnika.getClass(), idKorisnika.getIdKorisnika());
                radnik.setIdKorisnika(idKorisnika);
            }
            Radnik radIdRadnika = radnik.getRadIdRadnika();
            if (radIdRadnika != null) {
                radIdRadnika = em.getReference(radIdRadnika.getClass(), radIdRadnika.getIdRadnika());
                radnik.setRadIdRadnika(radIdRadnika);
            }
            Collection<Radnik> attachedRadnikCollection = new ArrayList<Radnik>();
            for (Radnik radnikCollectionRadnikToAttach : radnik.getRadnikCollection()) {
                radnikCollectionRadnikToAttach = em.getReference(radnikCollectionRadnikToAttach.getClass(), radnikCollectionRadnikToAttach.getIdRadnika());
                attachedRadnikCollection.add(radnikCollectionRadnikToAttach);
            }
            radnik.setRadnikCollection(attachedRadnikCollection);
            Collection<Zarada> attachedZaradaCollection = new ArrayList<Zarada>();
            for (Zarada zaradaCollectionZaradaToAttach : radnik.getZaradaCollection()) {
                zaradaCollectionZaradaToAttach = em.getReference(zaradaCollectionZaradaToAttach.getClass(), zaradaCollectionZaradaToAttach.getIdZarade());
                attachedZaradaCollection.add(zaradaCollectionZaradaToAttach);
            }
            radnik.setZaradaCollection(attachedZaradaCollection);
            Collection<Ocena> attachedOcenaCollection = new ArrayList<Ocena>();
            for (Ocena ocenaCollectionOcenaToAttach : radnik.getOcenaCollection()) {
                ocenaCollectionOcenaToAttach = em.getReference(ocenaCollectionOcenaToAttach.getClass(), ocenaCollectionOcenaToAttach.getIdOcene());
                attachedOcenaCollection.add(ocenaCollectionOcenaToAttach);
            }
            radnik.setOcenaCollection(attachedOcenaCollection);
            Collection<Fajlovi> attachedFajloviCollection = new ArrayList<Fajlovi>();
            for (Fajlovi fajloviCollectionFajloviToAttach : radnik.getFajloviCollection()) {
                fajloviCollectionFajloviToAttach = em.getReference(fajloviCollectionFajloviToAttach.getClass(), fajloviCollectionFajloviToAttach.getIdFajla());
                attachedFajloviCollection.add(fajloviCollectionFajloviToAttach);
            }
            radnik.setFajloviCollection(attachedFajloviCollection);
            em.persist(radnik);
            if (idPosla != null) {
                idPosla.getRadnikCollection().add(radnik);
                idPosla = em.merge(idPosla);
            }
            if (idPonude != null) {
                idPonude.getRadnikCollection().add(radnik);
                idPonude = em.merge(idPonude);
            }
            if (idPoruke != null) {
                idPoruke.getRadnikCollection().add(radnik);
                idPoruke = em.merge(idPoruke);
            }
            if (idKorisnika != null) {
                idKorisnika.getRadnikCollection().add(radnik);
                idKorisnika = em.merge(idKorisnika);
            }
            if (radIdRadnika != null) {
                radIdRadnika.getRadnikCollection().add(radnik);
                radIdRadnika = em.merge(radIdRadnika);
            }
            for (Radnik radnikCollectionRadnik : radnik.getRadnikCollection()) {
                Radnik oldRadIdRadnikaOfRadnikCollectionRadnik = radnikCollectionRadnik.getRadIdRadnika();
                radnikCollectionRadnik.setRadIdRadnika(radnik);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
                if (oldRadIdRadnikaOfRadnikCollectionRadnik != null) {
                    oldRadIdRadnikaOfRadnikCollectionRadnik.getRadnikCollection().remove(radnikCollectionRadnik);
                    oldRadIdRadnikaOfRadnikCollectionRadnik = em.merge(oldRadIdRadnikaOfRadnikCollectionRadnik);
                }
            }
            for (Zarada zaradaCollectionZarada : radnik.getZaradaCollection()) {
                Radnik oldIdRadnikaOfZaradaCollectionZarada = zaradaCollectionZarada.getIdRadnika();
                zaradaCollectionZarada.setIdRadnika(radnik);
                zaradaCollectionZarada = em.merge(zaradaCollectionZarada);
                if (oldIdRadnikaOfZaradaCollectionZarada != null) {
                    oldIdRadnikaOfZaradaCollectionZarada.getZaradaCollection().remove(zaradaCollectionZarada);
                    oldIdRadnikaOfZaradaCollectionZarada = em.merge(oldIdRadnikaOfZaradaCollectionZarada);
                }
            }
            for (Ocena ocenaCollectionOcena : radnik.getOcenaCollection()) {
                Radnik oldIdRadnikaOfOcenaCollectionOcena = ocenaCollectionOcena.getIdRadnika();
                ocenaCollectionOcena.setIdRadnika(radnik);
                ocenaCollectionOcena = em.merge(ocenaCollectionOcena);
                if (oldIdRadnikaOfOcenaCollectionOcena != null) {
                    oldIdRadnikaOfOcenaCollectionOcena.getOcenaCollection().remove(ocenaCollectionOcena);
                    oldIdRadnikaOfOcenaCollectionOcena = em.merge(oldIdRadnikaOfOcenaCollectionOcena);
                }
            }
            for (Fajlovi fajloviCollectionFajlovi : radnik.getFajloviCollection()) {
                Radnik oldIdRadnikaOfFajloviCollectionFajlovi = fajloviCollectionFajlovi.getIdRadnika();
                fajloviCollectionFajlovi.setIdRadnika(radnik);
                fajloviCollectionFajlovi = em.merge(fajloviCollectionFajlovi);
                if (oldIdRadnikaOfFajloviCollectionFajlovi != null) {
                    oldIdRadnikaOfFajloviCollectionFajlovi.getFajloviCollection().remove(fajloviCollectionFajlovi);
                    oldIdRadnikaOfFajloviCollectionFajlovi = em.merge(oldIdRadnikaOfFajloviCollectionFajlovi);
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

    public void edit(Radnik radnik) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Radnik persistentRadnik = em.find(Radnik.class, radnik.getIdRadnika());
            Poslovi idPoslaOld = persistentRadnik.getIdPosla();
            Poslovi idPoslaNew = radnik.getIdPosla();
            Ponuda idPonudeOld = persistentRadnik.getIdPonude();
            Ponuda idPonudeNew = radnik.getIdPonude();
            Poruka idPorukeOld = persistentRadnik.getIdPoruke();
            Poruka idPorukeNew = radnik.getIdPoruke();
            Korisnik idKorisnikaOld = persistentRadnik.getIdKorisnika();
            Korisnik idKorisnikaNew = radnik.getIdKorisnika();
            Radnik radIdRadnikaOld = persistentRadnik.getRadIdRadnika();
            Radnik radIdRadnikaNew = radnik.getRadIdRadnika();
            Collection<Radnik> radnikCollectionOld = persistentRadnik.getRadnikCollection();
            Collection<Radnik> radnikCollectionNew = radnik.getRadnikCollection();
            Collection<Zarada> zaradaCollectionOld = persistentRadnik.getZaradaCollection();
            Collection<Zarada> zaradaCollectionNew = radnik.getZaradaCollection();
            Collection<Ocena> ocenaCollectionOld = persistentRadnik.getOcenaCollection();
            Collection<Ocena> ocenaCollectionNew = radnik.getOcenaCollection();
            Collection<Fajlovi> fajloviCollectionOld = persistentRadnik.getFajloviCollection();
            Collection<Fajlovi> fajloviCollectionNew = radnik.getFajloviCollection();
            List<String> illegalOrphanMessages = null;
            for (Zarada zaradaCollectionOldZarada : zaradaCollectionOld) {
                if (!zaradaCollectionNew.contains(zaradaCollectionOldZarada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Zarada " + zaradaCollectionOldZarada + " since its idRadnika field is not nullable.");
                }
            }
            for (Ocena ocenaCollectionOldOcena : ocenaCollectionOld) {
                if (!ocenaCollectionNew.contains(ocenaCollectionOldOcena)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ocena " + ocenaCollectionOldOcena + " since its idRadnika field is not nullable.");
                }
            }
            for (Fajlovi fajloviCollectionOldFajlovi : fajloviCollectionOld) {
                if (!fajloviCollectionNew.contains(fajloviCollectionOldFajlovi)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Fajlovi " + fajloviCollectionOldFajlovi + " since its idRadnika field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPoslaNew != null) {
                idPoslaNew = em.getReference(idPoslaNew.getClass(), idPoslaNew.getIdPosla());
                radnik.setIdPosla(idPoslaNew);
            }
            if (idPonudeNew != null) {
                idPonudeNew = em.getReference(idPonudeNew.getClass(), idPonudeNew.getIdPonude());
                radnik.setIdPonude(idPonudeNew);
            }
            if (idPorukeNew != null) {
                idPorukeNew = em.getReference(idPorukeNew.getClass(), idPorukeNew.getIdPoruke());
                radnik.setIdPoruke(idPorukeNew);
            }
            if (idKorisnikaNew != null) {
                idKorisnikaNew = em.getReference(idKorisnikaNew.getClass(), idKorisnikaNew.getIdKorisnika());
                radnik.setIdKorisnika(idKorisnikaNew);
            }
            if (radIdRadnikaNew != null) {
                radIdRadnikaNew = em.getReference(radIdRadnikaNew.getClass(), radIdRadnikaNew.getIdRadnika());
                radnik.setRadIdRadnika(radIdRadnikaNew);
            }
            Collection<Radnik> attachedRadnikCollectionNew = new ArrayList<Radnik>();
            for (Radnik radnikCollectionNewRadnikToAttach : radnikCollectionNew) {
                radnikCollectionNewRadnikToAttach = em.getReference(radnikCollectionNewRadnikToAttach.getClass(), radnikCollectionNewRadnikToAttach.getIdRadnika());
                attachedRadnikCollectionNew.add(radnikCollectionNewRadnikToAttach);
            }
            radnikCollectionNew = attachedRadnikCollectionNew;
            radnik.setRadnikCollection(radnikCollectionNew);
            Collection<Zarada> attachedZaradaCollectionNew = new ArrayList<Zarada>();
            for (Zarada zaradaCollectionNewZaradaToAttach : zaradaCollectionNew) {
                zaradaCollectionNewZaradaToAttach = em.getReference(zaradaCollectionNewZaradaToAttach.getClass(), zaradaCollectionNewZaradaToAttach.getIdZarade());
                attachedZaradaCollectionNew.add(zaradaCollectionNewZaradaToAttach);
            }
            zaradaCollectionNew = attachedZaradaCollectionNew;
            radnik.setZaradaCollection(zaradaCollectionNew);
            Collection<Ocena> attachedOcenaCollectionNew = new ArrayList<Ocena>();
            for (Ocena ocenaCollectionNewOcenaToAttach : ocenaCollectionNew) {
                ocenaCollectionNewOcenaToAttach = em.getReference(ocenaCollectionNewOcenaToAttach.getClass(), ocenaCollectionNewOcenaToAttach.getIdOcene());
                attachedOcenaCollectionNew.add(ocenaCollectionNewOcenaToAttach);
            }
            ocenaCollectionNew = attachedOcenaCollectionNew;
            radnik.setOcenaCollection(ocenaCollectionNew);
            Collection<Fajlovi> attachedFajloviCollectionNew = new ArrayList<Fajlovi>();
            for (Fajlovi fajloviCollectionNewFajloviToAttach : fajloviCollectionNew) {
                fajloviCollectionNewFajloviToAttach = em.getReference(fajloviCollectionNewFajloviToAttach.getClass(), fajloviCollectionNewFajloviToAttach.getIdFajla());
                attachedFajloviCollectionNew.add(fajloviCollectionNewFajloviToAttach);
            }
            fajloviCollectionNew = attachedFajloviCollectionNew;
            radnik.setFajloviCollection(fajloviCollectionNew);
            radnik = em.merge(radnik);
            if (idPoslaOld != null && !idPoslaOld.equals(idPoslaNew)) {
                idPoslaOld.getRadnikCollection().remove(radnik);
                idPoslaOld = em.merge(idPoslaOld);
            }
            if (idPoslaNew != null && !idPoslaNew.equals(idPoslaOld)) {
                idPoslaNew.getRadnikCollection().add(radnik);
                idPoslaNew = em.merge(idPoslaNew);
            }
            if (idPonudeOld != null && !idPonudeOld.equals(idPonudeNew)) {
                idPonudeOld.getRadnikCollection().remove(radnik);
                idPonudeOld = em.merge(idPonudeOld);
            }
            if (idPonudeNew != null && !idPonudeNew.equals(idPonudeOld)) {
                idPonudeNew.getRadnikCollection().add(radnik);
                idPonudeNew = em.merge(idPonudeNew);
            }
            if (idPorukeOld != null && !idPorukeOld.equals(idPorukeNew)) {
                idPorukeOld.getRadnikCollection().remove(radnik);
                idPorukeOld = em.merge(idPorukeOld);
            }
            if (idPorukeNew != null && !idPorukeNew.equals(idPorukeOld)) {
                idPorukeNew.getRadnikCollection().add(radnik);
                idPorukeNew = em.merge(idPorukeNew);
            }
            if (idKorisnikaOld != null && !idKorisnikaOld.equals(idKorisnikaNew)) {
                idKorisnikaOld.getRadnikCollection().remove(radnik);
                idKorisnikaOld = em.merge(idKorisnikaOld);
            }
            if (idKorisnikaNew != null && !idKorisnikaNew.equals(idKorisnikaOld)) {
                idKorisnikaNew.getRadnikCollection().add(radnik);
                idKorisnikaNew = em.merge(idKorisnikaNew);
            }
            if (radIdRadnikaOld != null && !radIdRadnikaOld.equals(radIdRadnikaNew)) {
                radIdRadnikaOld.getRadnikCollection().remove(radnik);
                radIdRadnikaOld = em.merge(radIdRadnikaOld);
            }
            if (radIdRadnikaNew != null && !radIdRadnikaNew.equals(radIdRadnikaOld)) {
                radIdRadnikaNew.getRadnikCollection().add(radnik);
                radIdRadnikaNew = em.merge(radIdRadnikaNew);
            }
            for (Radnik radnikCollectionOldRadnik : radnikCollectionOld) {
                if (!radnikCollectionNew.contains(radnikCollectionOldRadnik)) {
                    radnikCollectionOldRadnik.setRadIdRadnika(null);
                    radnikCollectionOldRadnik = em.merge(radnikCollectionOldRadnik);
                }
            }
            for (Radnik radnikCollectionNewRadnik : radnikCollectionNew) {
                if (!radnikCollectionOld.contains(radnikCollectionNewRadnik)) {
                    Radnik oldRadIdRadnikaOfRadnikCollectionNewRadnik = radnikCollectionNewRadnik.getRadIdRadnika();
                    radnikCollectionNewRadnik.setRadIdRadnika(radnik);
                    radnikCollectionNewRadnik = em.merge(radnikCollectionNewRadnik);
                    if (oldRadIdRadnikaOfRadnikCollectionNewRadnik != null && !oldRadIdRadnikaOfRadnikCollectionNewRadnik.equals(radnik)) {
                        oldRadIdRadnikaOfRadnikCollectionNewRadnik.getRadnikCollection().remove(radnikCollectionNewRadnik);
                        oldRadIdRadnikaOfRadnikCollectionNewRadnik = em.merge(oldRadIdRadnikaOfRadnikCollectionNewRadnik);
                    }
                }
            }
            for (Zarada zaradaCollectionNewZarada : zaradaCollectionNew) {
                if (!zaradaCollectionOld.contains(zaradaCollectionNewZarada)) {
                    Radnik oldIdRadnikaOfZaradaCollectionNewZarada = zaradaCollectionNewZarada.getIdRadnika();
                    zaradaCollectionNewZarada.setIdRadnika(radnik);
                    zaradaCollectionNewZarada = em.merge(zaradaCollectionNewZarada);
                    if (oldIdRadnikaOfZaradaCollectionNewZarada != null && !oldIdRadnikaOfZaradaCollectionNewZarada.equals(radnik)) {
                        oldIdRadnikaOfZaradaCollectionNewZarada.getZaradaCollection().remove(zaradaCollectionNewZarada);
                        oldIdRadnikaOfZaradaCollectionNewZarada = em.merge(oldIdRadnikaOfZaradaCollectionNewZarada);
                    }
                }
            }
            for (Ocena ocenaCollectionNewOcena : ocenaCollectionNew) {
                if (!ocenaCollectionOld.contains(ocenaCollectionNewOcena)) {
                    Radnik oldIdRadnikaOfOcenaCollectionNewOcena = ocenaCollectionNewOcena.getIdRadnika();
                    ocenaCollectionNewOcena.setIdRadnika(radnik);
                    ocenaCollectionNewOcena = em.merge(ocenaCollectionNewOcena);
                    if (oldIdRadnikaOfOcenaCollectionNewOcena != null && !oldIdRadnikaOfOcenaCollectionNewOcena.equals(radnik)) {
                        oldIdRadnikaOfOcenaCollectionNewOcena.getOcenaCollection().remove(ocenaCollectionNewOcena);
                        oldIdRadnikaOfOcenaCollectionNewOcena = em.merge(oldIdRadnikaOfOcenaCollectionNewOcena);
                    }
                }
            }
            for (Fajlovi fajloviCollectionNewFajlovi : fajloviCollectionNew) {
                if (!fajloviCollectionOld.contains(fajloviCollectionNewFajlovi)) {
                    Radnik oldIdRadnikaOfFajloviCollectionNewFajlovi = fajloviCollectionNewFajlovi.getIdRadnika();
                    fajloviCollectionNewFajlovi.setIdRadnika(radnik);
                    fajloviCollectionNewFajlovi = em.merge(fajloviCollectionNewFajlovi);
                    if (oldIdRadnikaOfFajloviCollectionNewFajlovi != null && !oldIdRadnikaOfFajloviCollectionNewFajlovi.equals(radnik)) {
                        oldIdRadnikaOfFajloviCollectionNewFajlovi.getFajloviCollection().remove(fajloviCollectionNewFajlovi);
                        oldIdRadnikaOfFajloviCollectionNewFajlovi = em.merge(oldIdRadnikaOfFajloviCollectionNewFajlovi);
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
                Integer id = radnik.getIdRadnika();
                if (findRadnik(id) == null) {
                    throw new NonexistentEntityException("The radnik with id " + id + " no longer exists.");
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
            Radnik radnik;
            try {
                radnik = em.getReference(Radnik.class, id);
                radnik.getIdRadnika();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The radnik with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Zarada> zaradaCollectionOrphanCheck = radnik.getZaradaCollection();
            for (Zarada zaradaCollectionOrphanCheckZarada : zaradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Radnik (" + radnik + ") cannot be destroyed since the Zarada " + zaradaCollectionOrphanCheckZarada + " in its zaradaCollection field has a non-nullable idRadnika field.");
            }
            Collection<Ocena> ocenaCollectionOrphanCheck = radnik.getOcenaCollection();
            for (Ocena ocenaCollectionOrphanCheckOcena : ocenaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Radnik (" + radnik + ") cannot be destroyed since the Ocena " + ocenaCollectionOrphanCheckOcena + " in its ocenaCollection field has a non-nullable idRadnika field.");
            }
            Collection<Fajlovi> fajloviCollectionOrphanCheck = radnik.getFajloviCollection();
            for (Fajlovi fajloviCollectionOrphanCheckFajlovi : fajloviCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Radnik (" + radnik + ") cannot be destroyed since the Fajlovi " + fajloviCollectionOrphanCheckFajlovi + " in its fajloviCollection field has a non-nullable idRadnika field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Poslovi idPosla = radnik.getIdPosla();
            if (idPosla != null) {
                idPosla.getRadnikCollection().remove(radnik);
                idPosla = em.merge(idPosla);
            }
            Ponuda idPonude = radnik.getIdPonude();
            if (idPonude != null) {
                idPonude.getRadnikCollection().remove(radnik);
                idPonude = em.merge(idPonude);
            }
            Poruka idPoruke = radnik.getIdPoruke();
            if (idPoruke != null) {
                idPoruke.getRadnikCollection().remove(radnik);
                idPoruke = em.merge(idPoruke);
            }
            Korisnik idKorisnika = radnik.getIdKorisnika();
            if (idKorisnika != null) {
                idKorisnika.getRadnikCollection().remove(radnik);
                idKorisnika = em.merge(idKorisnika);
            }
            Radnik radIdRadnika = radnik.getRadIdRadnika();
            if (radIdRadnika != null) {
                radIdRadnika.getRadnikCollection().remove(radnik);
                radIdRadnika = em.merge(radIdRadnika);
            }
            Collection<Radnik> radnikCollection = radnik.getRadnikCollection();
            for (Radnik radnikCollectionRadnik : radnikCollection) {
                radnikCollectionRadnik.setRadIdRadnika(null);
                radnikCollectionRadnik = em.merge(radnikCollectionRadnik);
            }
            em.remove(radnik);
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

    public List<Radnik> findRadnikEntities() {
        return findRadnikEntities(true, -1, -1);
    }

    public List<Radnik> findRadnikEntities(int maxResults, int firstResult) {
        return findRadnikEntities(false, maxResults, firstResult);
    }

    private List<Radnik> findRadnikEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Radnik.class));
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

    public Radnik findRadnik(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Radnik.class, id);
        } finally {
            em.close();
        }
    }

    public int getRadnikCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Radnik> rt = cq.from(Radnik.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
