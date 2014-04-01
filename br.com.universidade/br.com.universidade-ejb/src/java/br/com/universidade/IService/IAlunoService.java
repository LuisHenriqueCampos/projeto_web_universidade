package br.com.universidade.IService;

import br.com.universidade.aplicacao.Aluno;
import java.util.List;

public interface IAlunoService {
    
    List<Aluno> listar();
    String remover(Integer idPessoa);
    String salvar(Aluno aluno);
    Aluno obter(Integer id);  
    
}
