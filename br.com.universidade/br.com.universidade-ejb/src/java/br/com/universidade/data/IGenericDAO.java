package br.com.universidade.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public interface IGenericDAO<T> {
    
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> all(TypedQuery<T> query);
    T single(TypedQuery<T> query);
    
    EntityManager getEntityManager();
    
}
