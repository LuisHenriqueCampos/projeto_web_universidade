package br.com.universidade.aplicacao;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "professor")
public class Professor {
    
    @Id
    @Basic(optional = false)
    @Column(name = "idPessoa",  insertable = false, updatable = false)
    private Integer idPessoa;
    
    @Column(name = "salario", nullable = false)
    private Double salario;
    
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Pessoa pessoa;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Turma> turmas;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }    

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }    
        
}
