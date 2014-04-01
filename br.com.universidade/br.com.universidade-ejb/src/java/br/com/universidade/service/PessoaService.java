package br.com.universidade.service;

import br.com.universidade.IService.IPessoaService;
import br.com.universidade.aplicacao.Pessoa;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

@Stateless
public class PessoaService implements IPessoaService{

    @Inject
    private IGenericDAO<Pessoa> pessoaDao;
    
    @Override
    public List<Pessoa> listar() {
       TypedQuery<Pessoa> pessoaQuery = 
               pessoaDao.getEntityManager()
               .createQuery("SELECT p FROM Pessoa p",Pessoa.class);
       return pessoaDao.all(pessoaQuery);
    }

    @Override
    public String remover(Integer idPessoa) {
        try{
            Pessoa pessoa = obter(idPessoa);
            pessoaDao.delete(pessoa);
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String salvar(Pessoa pessoa) {
        try{
            if(pessoa.getIdPessoa() != null){
                pessoaDao.update(pessoa);
            }else{
                pessoaDao.save(pessoa);
            }            
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public Pessoa obter(Integer id) {
       Pessoa pessoa = pessoaDao
               .getEntityManager().find(Pessoa.class, id);
       return pessoa;
    }    
}
