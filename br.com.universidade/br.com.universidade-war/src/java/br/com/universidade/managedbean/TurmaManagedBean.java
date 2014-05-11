/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.managedbean;

import br.com.universidade.IService.ITurmaService;
import br.com.universidade.aplicacao.Turma;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Luis
 */
@Named(value = "turmaManagedBean")
@RequestScoped
public class TurmaManagedBean {
    
    @EJB
    private ITurmaService turmaService;
    
    private Turma turma;
    private Turma turmaSelecionada;
    
    public TurmaManagedBean(){
        turma = new Turma();
        turma.setQuantidadeVagas(40);
    }
    
    public List<Turma> todos(){
        return turmaService.listar();
    }
    
    public void novo(){
        this.turma =  new Turma();
        turma.setQuantidadeVagas(40);
    }
    
    public void salvar(){
        String erro = turmaService.salvar(turma);
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Turma salva com sucesso!");
            this.novo();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir(){
        String erro = turmaService.remover(turmaSelecionada.getIdTurma());
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Turma excluída com sucesso!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar(){
        turma = turmaSelecionada;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(Turma turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }
}
