
package br.com.universidade.service;

import br.com.universidade.IService.ISituacaoMatriculaService;
import br.com.universidade.aplicacao.SituacaoMatricula;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

@Stateless
public class SituacaoMatriculaService implements ISituacaoMatriculaService{

    @Inject
    private IGenericDAO<SituacaoMatricula> situacaoMatriculaDao;
    
    
    @Override
    public List<SituacaoMatricula> listar() {
        TypedQuery<SituacaoMatricula> situacaoMatriculaQuery =
                situacaoMatriculaDao.getEntityManager()
                .createQuery("SELECT sm FROM SituacaoMatricula sm",SituacaoMatricula.class);
        return situacaoMatriculaDao.all(situacaoMatriculaQuery);
    }

    @Override
    public String remover(Short idSituacaoMatricula) {
        try{
            SituacaoMatricula situacaoMatricula = obter(idSituacaoMatricula);
            situacaoMatriculaDao.delete(situacaoMatricula);
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String salvar(SituacaoMatricula situacaoMatricula) {
        TypedQuery<SituacaoMatricula> sitquery = situacaoMatriculaDao.getEntityManager()
                .createQuery("SELECT s FROM SituacaoMatricula s WHERE s.descricao = :nome",SituacaoMatricula.class);
        sitquery.setParameter("nome", situacaoMatricula.getDescricao());
        
        
        try{
            if(situacaoMatricula.getIdSituacaoMatricula() != null && sitquery.getResultList().isEmpty()){
                situacaoMatriculaDao.update(situacaoMatricula);
            }else if(situacaoMatricula.getIdSituacaoMatricula() == null && sitquery.getResultList().isEmpty()){
                situacaoMatriculaDao.save(situacaoMatricula);
            }else{
                return "A Situação da Matrícula já foi cadastrada!";
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public SituacaoMatricula obter(Short id) {
        SituacaoMatricula situacaoMatricula = situacaoMatriculaDao
                .getEntityManager().find(SituacaoMatricula.class, id);
        return situacaoMatricula;
    }    
}
