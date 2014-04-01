package br.com.universidade.IService;

import br.com.universidade.aplicacao.PeriodoLetivo;
import java.util.List;

public interface IPeriodoLetivoService {
    
    List<PeriodoLetivo> listar();
    String remover(Short idPeriodoLetivo);
    String salvar(PeriodoLetivo periodoLetivo);
    PeriodoLetivo obter(Short id);
    
    
}
