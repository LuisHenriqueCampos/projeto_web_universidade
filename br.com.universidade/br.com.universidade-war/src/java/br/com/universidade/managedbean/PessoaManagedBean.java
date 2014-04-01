package br.com.universidade.managedbean;

import br.com.universidade.IService.IPessoaService;
import br.com.universidade.aplicacao.Pessoa;
import br.com.universidade.util.MenssagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named(value = "pessoaManagedBean")
@ViewScoped
public class PessoaManagedBean {
    
    @EJB
    private IPessoaService pessoaService;
    
    private Pessoa pessoa;
    private Pessoa pessoaSelecionada;
    
    public PessoaManagedBean(){
        pessoa = new Pessoa();
    }
    
    public List<Pessoa> todos(){
        return pessoaService.listar();
    }
    
    public void novo(){
        this.pessoa = new Pessoa();
    }
    
    public void salvar(){
        String erro = pessoaService.salvar(pessoa);
        if(erro == null){
            pessoa = new Pessoa();
        }else{
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir(){
        String erro = pessoaService.remover(pessoaSelecionada.getIdPessoa());        
        if(erro != null){
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void atualizar(){
        pessoa = pessoaSelecionada;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }    
    
}
