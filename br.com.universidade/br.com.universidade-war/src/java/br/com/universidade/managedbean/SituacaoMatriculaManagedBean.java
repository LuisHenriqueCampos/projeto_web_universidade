package br.com.universidade.managedbean;

import br.com.universidade.IService.ISituacaoMatriculaService;
import br.com.universidade.aplicacao.SituacaoMatricula;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "situacaoMatriculaManagedBean")
@RequestScoped
public class SituacaoMatriculaManagedBean {
    
    @EJB
    private ISituacaoMatriculaService situacaoMatriculaService;
    
    private SituacaoMatricula situacaoMatriculaSelecionado;
    private SituacaoMatricula situacaoMatricula;
    
    public SituacaoMatriculaManagedBean(){
        situacaoMatricula = new SituacaoMatricula();
    }
    
    public List<SituacaoMatricula> todos(){
        return situacaoMatriculaService.listar();
    }
    
    public void novo(){
        this.situacaoMatricula = new SituacaoMatricula();
    }
    
    public void salvar(){
        String erro = situacaoMatriculaService.salvar(situacaoMatricula);
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Situação da Matrícula salvo com sucesso!!!");
            situacaoMatricula = new SituacaoMatricula();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir(){
        String erro = situacaoMatriculaService.remover(situacaoMatriculaSelecionado.getIdSituacaoMatricula());
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Situação da Matrícula excluida com sucesso!!!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void atualizar(){
        situacaoMatricula = situacaoMatriculaSelecionado;
    }

    public SituacaoMatricula getSituacaoMatriculaSelecionado() {
        return situacaoMatriculaSelecionado;
    }

    public void setSituacaoMatriculaSelecionado(SituacaoMatricula situacaoMatriculaSelecionado) {
        this.situacaoMatriculaSelecionado = situacaoMatriculaSelecionado;
    }

    public SituacaoMatricula getSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(SituacaoMatricula situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }    

}
