/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Gary
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    private JPAController jpa;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        jpa =  new JPAController(Persistence.createEntityManagerFactory("FdTrcksArgPU"));
    }


    public void create(T entity) {
        EntityManager em = null;
        try {
            em = jpa.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T entity) {
        EntityManager em = null;
        try {
            em = jpa.getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void remove(T entity) {
        EntityManager em = null;
        try {
            em = jpa.getEntityManager();
            em.getTransaction().begin();
            em.remove(jpa.getEntityManager().merge(entity));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T find(Object id) {
        return  jpa.getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq =  jpa.getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return  jpa.getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq =  jpa.getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q =  jpa.getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq =  jpa.getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(jpa.getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q =  jpa.getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
