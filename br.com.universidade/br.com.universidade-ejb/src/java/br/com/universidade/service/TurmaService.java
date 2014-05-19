/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.service;

import br.com.universidade.IService.ITurmaService;
import br.com.universidade.aplicacao.Turma;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luis
 */
@Stateless
public class TurmaService implements ITurmaService{
    
    @Inject
    IGenericDAO<Turma> turmaDao;

    @Override
    public List<Turma> listar() {
        TypedQuery<Turma> turmaQuery = turmaDao.getEntityManager()
                .createQuery("SELECT t FROM Turma t ORDER BY t.nomeTurma",Turma.class);
        return turmaQuery.getResultList();
    }

    @Override
    public String salvar(Turma turma) {
        TypedQuery<Turma> turmaQuery = turmaDao.getEntityManager()
                .createQuery("SELECT t FROM Turma t WHERE t.nomeTurma = :nome",Turma.class);
        turmaQuery.setParameter("nome", turma.getNomeTurma());
        try{
            if(turma.getIdTurma() != null && turmaQuery.getResultList().isEmpty()){
                turmaDao.update(turma);
            }else if(turma.getIdTurma() == null && turmaQuery.getResultList().isEmpty()){
                turmaDao.save(turma);
            }else{
                return "Turma já cadastrada.";
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String remover(Integer idTurma) {
        try{
            Turma turma = obter(idTurma);
            turmaDao.delete(turma);
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public Turma obter(Integer id) {
        Turma turma = turmaDao.getEntityManager().find(Turma.class, id);
        return turma;
    }   
    
}
