package br.com.universidade.service;

import br.com.universidade.IService.IAlunoService;
import br.com.universidade.aplicacao.Aluno;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

@Stateless
public class AlunoService implements IAlunoService{
    
    @Inject
    private IGenericDAO<Aluno> alunoDao;

    @Override
    public List<Aluno> listar() {
        
        TypedQuery<Aluno> alunoQuery = alunoDao.getEntityManager()
                .createQuery("SELECT a FROM Aluno a ORDER BY a.pessoa.nome",Aluno.class);
        
        return alunoDao.all(alunoQuery);
        
    }

    @Override
    public String remover(Integer idPessoa) {
        try{
            Aluno aluno = obter(idPessoa);
            alunoDao.delete(aluno);
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String salvar(Aluno aluno) {
     
        TypedQuery<Aluno> alunoQuery = alunoDao.getEntityManager()
                .createQuery("SELECT a FROM Aluno a WHERE a.pessoa.cpf = :cpf",Aluno.class);
        
        alunoQuery.setParameter("cpf", aluno.getPessoa().getCpf());
        
        try{            
            aluno.getPessoa().setAluno(aluno);
            
            if(aluno.getPessoa().getIdPessoa()!= null){
                alunoDao.update(aluno);
            }            
            else if(aluno.getPessoa().getIdPessoa() == null && alunoQuery.getResultList().isEmpty()){
                alunoDao.save(aluno);
            }            
            else{
                return "CPF já cadastrado";
            }            
        }
        
        catch(Exception ex){            
            return ex.getMessage();            
        }
        return null;        
    }
 
    @Override
    public Aluno obter(Integer id) {
        Aluno aluno = alunoDao.getEntityManager()
                .find(Aluno.class, id);
        return aluno;
    }  

    @Override
    public List<Aluno> listarPorNome(String aluno) {
        
        aluno = aluno == null ? "": aluno;
        
        TypedQuery<Aluno> alunosQuery = alunoDao.getEntityManager()
                .createQuery("SELECT a FROM Aluno a where a.pessoa.nome like :nome ORDER BY a.pessoa.nome",Aluno.class);
        alunosQuery.setParameter("nome", "%"+aluno+"%");        
        return alunosQuery.getResultList();

    }  
    
}
