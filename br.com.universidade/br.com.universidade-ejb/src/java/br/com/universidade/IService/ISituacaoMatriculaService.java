package br.com.universidade.IService;

import br.com.universidade.aplicacao.SituacaoMatricula;
import java.util.List;

public interface ISituacaoMatriculaService {
    
    List<SituacaoMatricula> listar();
    String remover(Short idSituacaoMatricula);
    String salvar(SituacaoMatricula situacaoMatricula);
    SituacaoMatricula obter(Short id);
    
}
