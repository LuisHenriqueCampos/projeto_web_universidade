/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.service;

import br.com.universidade.IService.IMatriculaService;
import br.com.universidade.aplicacao.Matricula;
import br.com.universidade.aplicacao.Turma;
import br.com.universidade.data.IGenericDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luis
 */
@Stateless
public class MatriculaService implements IMatriculaService{
    
    @Inject
    IGenericDAO<Matricula> matriculaDao;
    @Inject
    IGenericDAO<Turma> turmaDao;

    @Override
    public List<Matricula> listar() {
        TypedQuery<Matricula> matQuery = matriculaDao.getEntityManager()
                .createQuery("SELECT m FROM Matricula m ORDER BY m.aluno.pessoa.nome",Matricula.class);
        return matQuery.getResultList();
    }

    @Override
    public String salvar(Matricula matricula) { 
        TypedQuery<Matricula> matquery = matriculaDao.getEntityManager()
                .createQuery("SELECT m FROM Matricula m WHERE m.aluno.idPessoa = :nome and m.turma.idTurma = :turma",Matricula.class);
        matquery.setParameter("nome", matricula.getAluno().getIdPessoa());
        matquery.setParameter("turma", matricula.getTurma().getIdTurma());
        
        try{
            if(matricula.getIdMatricula() != null && matquery.getResultList().isEmpty()){
                matriculaDao.update(matricula);
            }else if(matricula.getIdMatricula() == null && matquery.getResultList().isEmpty()){
                matricula.setDataMatricula(new Date());
                matriculaDao.save(matricula);
            }else{
                return "Aluno já Matriculado nesta Turma";
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String remover(Integer idMatricula) {
        try{
            Matricula matricula = obter(idMatricula);
            matriculaDao.delete(matricula);
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage(); 
        }
        return null;
    }

    @Override
    public Matricula obter(Integer id) {
        Matricula matricula = matriculaDao.getEntityManager()
                .find(Matricula.class, id);
        return matricula;
    }
    
}
