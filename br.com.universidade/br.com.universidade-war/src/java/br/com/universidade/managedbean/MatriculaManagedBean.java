/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.managedbean;

import br.com.universidade.IService.IMatriculaService;
import br.com.universidade.aplicacao.Matricula;
import br.com.universidade.util.MenssagemUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Luis
 */
@Named(value = "matriculaManagedBean")
@RequestScoped
public class MatriculaManagedBean {
    
    @EJB
    private IMatriculaService matriculaService;
    
    private Matricula matricula;
    private Matricula matriculaSelecionada;
    
    public MatriculaManagedBean(){
        matricula = new Matricula();
    }    
    
    public List<Matricula> todos(){
        return matriculaService.listar();
    }
    
    public void novo(){
        this.matricula = new Matricula();
    }
    
    public void salvar(){
        
        String erro = matriculaService.salvar(matricula);
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Matrícula Efetuada com Sucesso!");
            this.matricula = new Matricula();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir(){
        String erro = matriculaService.remover(matriculaSelecionada.getIdMatricula());
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Matrícula Excluída com Sucesso!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar(){
        matricula = matriculaSelecionada;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Matricula getMatriculaSelecionada() {
        return matriculaSelecionada;
    }

    public void setMatriculaSelecionada(Matricula matriculaSelecionada) {
        this.matriculaSelecionada = matriculaSelecionada;
    }
}
