/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entities.Locations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ray
 */
@Stateless
public class LocationsFacade extends AbstractFacade<Locations> {
    @PersistenceContext(unitName = "COMP31_A3_RealOrtelliPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationsFacade() {
        super(Locations.class);
    }
    
}
