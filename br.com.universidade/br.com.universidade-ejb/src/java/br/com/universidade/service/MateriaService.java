/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.service;

import br.com.universidade.IService.IMateriaService;
import br.com.universidade.aplicacao.Materia;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luis
 */
@Stateless
public class MateriaService implements IMateriaService{
    
    @Inject
    private IGenericDAO<Materia> materiaDao;

    @Override
    public String salvar(Materia materia) {
       
        try{
            if(materia.getIdMateria() != null){
                materiaDao.update(materia);
            }
            else{
                materiaDao.save(materia);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        
        return null;
        
    }

    @Override
    public String remover(Integer idMateria) {
        
        try{
            Materia materia = obter(idMateria);
            materiaDao.delete(materia);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        return null;
        
    }

    @Override
    public List<Materia> listar() {
        
        TypedQuery<Materia> matQuery = materiaDao.getEntityManager()
                .createQuery("SELECT m FROM Materia m ORDER BY m.descricao",Materia.class);
        return matQuery.getResultList();
        
    }

    @Override
    public Materia obter(Integer id) {
        
        Materia materia = materiaDao.getEntityManager().find(Materia.class, id);
        return materia;
        
    }   
    
}
