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
public class OcenaFacade extends AbstractFacade<Ocena> {

    @PersistenceContext(unitName = "CS230-DZ07PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OcenaFacade() {
        super(Ocena.class);
    }
    
}