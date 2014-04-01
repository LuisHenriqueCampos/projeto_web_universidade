package br.com.universidade.managedbean;

import br.com.universidade.IService.IAlunoService;
import br.com.universidade.aplicacao.Aluno;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "alunoManagedBean")
@RequestScoped
public class AlunoManagedBean {
    
    @EJB
    private IAlunoService alunoService;
    
    private Aluno aluno;
    private Aluno alunoSelecionado;
    
   public AlunoManagedBean(){
       aluno = new Aluno();
   }
    
    public List<Aluno> todos(){
        return alunoService.listar();
    }
    
    public void salvar(){        
        String erro = alunoService.salvar(aluno);        
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Aluno salvo com Sucesso!!!");
            aluno = new Aluno();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void novo(){
        this.aluno = new Aluno();
    }
    
    public void excluir(){
        String erro = alunoService.remover(alunoSelecionado.getPessoa().getIdPessoa());
        if(erro == null){
            MenssagemUtil.addMensagemInfo("Aluno excluído com sucesso!!!");
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void atualizar(){
        aluno = alunoSelecionado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }
    
}