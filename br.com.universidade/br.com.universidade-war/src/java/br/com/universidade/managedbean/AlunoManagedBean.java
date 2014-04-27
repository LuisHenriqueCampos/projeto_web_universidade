package br.com.universidade.managedbean;

import br.com.universidade.IService.IAlunoService;
import br.com.universidade.aplicacao.Aluno;
import br.com.universidade.util.MenssagemUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "alunoManagedBean")
@ViewScoped
public class AlunoManagedBean implements Serializable {

    @EJB
    private IAlunoService alunoService;

    private Aluno aluno;
    private Aluno alunoSelecionado;
    private List<Aluno> alunos;
    private String alunoConsulta;

    public AlunoManagedBean() {
        aluno = new Aluno();
    }
    
    @PostConstruct
    public void init(){
        String id= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	if(id != null){
            aluno = alunoService.obter(Integer.parseInt(id));
	} 
    }

    public void salvar() {
        String erro = alunoService.salvar(aluno);

        if (erro == null) {
            MenssagemUtil.addMensagemInfo("Aluno salvo com sucesso");
            aluno = new Aluno();
        } else {
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void excluir() {
        String erro = alunoService.remover(alunoSelecionado.getPessoa().getIdPessoa());

        if (erro == null) {
            MenssagemUtil.addMensagemInfo("Aluno excluído com sucesso");
            this.alunos.remove(alunoSelecionado);
        } else {
            MenssagemUtil.addMensagemError(erro);
        }
    }
    
    public void editar() throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("formulario.html?id="+alunoSelecionado.getPessoa().getIdPessoa());
    }
 
    public void consultarAluno(){
        this.alunos = alunoService.listarPorNome(alunoConsulta);
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAutomoveis(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getAlunoConsulta() {
        return alunoConsulta;
    }

    public void setAlunoConsulta(String alunoConsulta) {
        this.alunoConsulta = alunoConsulta;
    }
    
}
