package br.com.universidade.IService;

import br.com.universidade.aplicacao.Pessoa;
import java.util.List;

public interface IPessoaService {
    
    List<Pessoa> listar();
    String remover(Integer idPessoa);
    String salvar(Pessoa pessoa);
    Pessoa obter(Integer id);
    
}
