package br.com.universidade.persistencia;

import br.com.universidade.aplicacao.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    
    private static EntityManager em 
            = Persistence
            .createEntityManagerFactory("br.com.universidade-ejbPU")
            .createEntityManager();
    
    public static void main(String[] args){
        
        em.getTransaction().begin();
        
        Materia materia = new Materia();
        
        materia.setDescricao("Analise de Sistemas");        
        
        em.persist(materia);
        
        em.getTransaction().commit();
        
    }
    
}
