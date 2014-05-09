/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.managedbean;

import br.com.universidade.IService.IMateriaService;
import br.com.universidade.aplicacao.Materia;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Luis
 */
@Named(value = "materiaManagedBean")
@RequestScoped
public class MateriaManagedBean {
    
    @EJB
    private IMateriaService materiaService;
    
    private Materia materia;
    private Materia materiaSelecionada;
    
    public MateriaManagedBean(){
        materia = new Materia();
    }
    
    public List<Materia> todos(){
        return materiaService.listar();
    }
    
    public void novo(){
        materia = new Materia();
    }
    
    public void editar(){
        materia = materiaSelecionada;
    }
    
    public void salvar(){
        
        System.out.println("IDMATERIA: "+materia.getIdMateria());
        System.out.println("NOME: "+materia.getDescricao());
        
        String erro = materiaService.salvar(materia);
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Máteria Cadastrada com Sucesso!");
        }
        else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir(){
        String erro = materiaService.remover(materiaSelecionada.getIdMateria());
        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Matéria excluída com Sucesso!");
        }
        else{
            MenssagemUtil.addMensagemError(erro);
        }
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateriaSelecionada() {
        return materiaSelecionada;
    }

    public void setMateriaSelecionada(Materia materiaSelecionada) {
        this.materiaSelecionada = materiaSelecionada;
    }
    
}
