/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.service;

import br.com.universidade.IService.ICursoService;
import br.com.universidade.aplicacao.Curso;
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
public class CursoService implements ICursoService{
    
    @Inject
    private IGenericDAO<Curso> cursoDao;

    @Override
    public List<Curso> listar() {
        TypedQuery<Curso> cursoQuery = cursoDao
                .getEntityManager().createQuery("SELECT c FROM Curso c",Curso.class);
        return cursoDao.all(cursoQuery);
    }

    @Override
    public String remover(Short idCurso) {
        try{
            Curso curso = obter(idCurso);
            cursoDao.delete(curso);
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String salvar(Curso curso) {
        try{
            if(curso.getIdCurso() != null){
                cursoDao.update(curso);
            }else{
                cursoDao.save(curso);
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public Curso obter(Short id) {
        Curso curso = cursoDao
                .getEntityManager().find(Curso.class, id);
        return curso;
    }   
    
}
