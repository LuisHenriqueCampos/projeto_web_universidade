/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.managedbean;

import br.com.universidade.IService.ICursoService;
import br.com.universidade.aplicacao.Curso;
import br.com.universidade.model.GraficoCursoModel;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Luis
 */
@Named(value = "cursoManagedBean")
@RequestScoped
public class CursoManagedBean {
    
    @EJB
    private ICursoService cursoService;
    
    private Curso curso;
    private Curso cursoSelecionado;
    
    public CursoManagedBean(){
        curso = new Curso();
    }
    
    public List<Curso> todos(){
        return cursoService.listar();
    }
    
    public void novo(){
        this.curso = new Curso();
    }
    
    public void salvar(){
        String erro = cursoService.salvar(curso);
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Curso salvo com sucesso!!!");
            curso = new Curso();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }                    
    }
    
    public void excluir(){
        String erro = cursoService.remover(cursoSelecionado.getIdCurso());
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Curso excluido com sucesso!!!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public PieChartModel gerarGrafico(){
        PieChartModel pieChartModel =  new PieChartModel();
        
        List<GraficoCursoModel> models =
                cursoService.consultaGrafico();
        
        for(GraficoCursoModel model : models){
            pieChartModel.set(model.getNomeCurso(), model.getQuantidadeMateria());
        }        
        return pieChartModel;
    }
    
     public void atualizar(){
        curso = cursoSelecionado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
    
}
