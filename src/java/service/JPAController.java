/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Gary
 */
public class JPAController {
    
    private static final long serialVersionUID = 1L;
    private static EntityManager em; 
    
    
    public JPAController(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return em;
    }
    
}
