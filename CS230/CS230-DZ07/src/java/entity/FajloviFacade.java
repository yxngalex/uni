/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aleks
 */
@Stateless
public class FajloviFacade extends AbstractFacade<Fajlovi> {

    @PersistenceContext(unitName = "CS230-DZ07PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FajloviFacade() {
        super(Fajlovi.class);
    }
    
}
