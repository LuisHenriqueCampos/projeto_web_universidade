package br.com.universidade.managedbean;

import br.com.universidade.IService.IPeriodoLetivoService;
import br.com.universidade.aplicacao.PeriodoLetivo;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "periodoLetivoManagedBean")
@RequestScoped
public class PeriodoLetivoManagedBean {
    
    @EJB
    private IPeriodoLetivoService periodoLetivoService;
    
    private PeriodoLetivo periodoLetivo;
    private PeriodoLetivo periodoLetivoSelecionado;
    
    public PeriodoLetivoManagedBean(){
        periodoLetivo = new PeriodoLetivo();
    }
    
    public List<PeriodoLetivo> todos(){
        return periodoLetivoService.listar();
    }
    
    public void novo(){
        this.periodoLetivo = new PeriodoLetivo();
    }
    
    public void salvar(){
        String erro = periodoLetivoService.salvar(periodoLetivo);
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Periodo Letivo salvo com sucesso!!!");
            periodoLetivo = new PeriodoLetivo();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }                    
    }
    
    public void excluir(){
        String erro = periodoLetivoService.remover(periodoLetivoSelecionado.getIdPeriodoLetivo());
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Período Letivo excluido com sucesso!!!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void atualizar(){
        periodoLetivo = periodoLetivoSelecionado;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public PeriodoLetivo getPeriodoLetivoSelecionado() {
        return periodoLetivoSelecionado;
    }

    public void setPeriodoLetivoSelecionado(PeriodoLetivo periodoLetivoSelecionado) {
        this.periodoLetivoSelecionado = periodoLetivoSelecionado;
    }    
    
}
