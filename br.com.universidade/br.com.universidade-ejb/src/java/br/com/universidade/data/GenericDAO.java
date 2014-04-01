package br.com.universidade.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class GenericDAO<T> implements IGenericDAO<T>{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void delete(T entity) {
       em.remove(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public List<T> all(TypedQuery<T> query) {
        return query.getResultList();
    }

    @Override
    public T single(TypedQuery<T> query) {
        return query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    } 
    
}
