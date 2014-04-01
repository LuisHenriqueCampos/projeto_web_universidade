package br.com.universidade.aplicacao;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {
    
    @Id
    @Basic(optional = false)
    @Column(name = "idPessoa", insertable = false, updatable = false)
    private Integer idPessoa;
    
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    
    @Column(name = "nomeResponsavel", nullable = false, length = 100)
    private String nomeResponsavel;
    
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Pessoa pessoa;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Matricula> matriculas;
    
    public Aluno(){
        pessoa = new Pessoa();
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }    
    
}