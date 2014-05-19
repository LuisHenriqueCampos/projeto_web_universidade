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
                .getEntityManager().createQuery("SELECT DISTINCT c FROM Curso c JOIN FETCH c.materias ORDER BY c.nomeCurso",Curso.class);
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
        TypedQuery<Curso> cursoQuery = cursoDao.getEntityManager()
                .createQuery("SELECT c FROM Curso c WHERE c.nomeCurso = :nome",Curso.class);
        cursoQuery.setParameter("nome", curso.getNomeCurso());
        try{
            if(curso.getIdCurso() != null && cursoQuery.getResultList().isEmpty() && !curso.getMaterias().isEmpty()){
                cursoDao.update(curso);
            }else if(curso.getIdCurso() == null && cursoQuery.getResultList().isEmpty() && !curso.getMaterias().isEmpty()){
                cursoDao.save(curso);
            }else if(curso.getIdCurso() == null && cursoQuery.getResultList().isEmpty() && curso.getMaterias().isEmpty()){
                return "Selecione ao menos 1 matéria.";
            }else{
                return "Curso já foi cadastrado.";
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
