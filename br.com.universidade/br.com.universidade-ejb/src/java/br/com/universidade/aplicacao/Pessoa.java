package br.com.universidade.aplicacao;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Column(name = "idPessoa", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;
    
    @Column(name = "nome", nullable = false, length = 100)
    @NotNull(message = "O campo NOME não pode ser NULO.")
    @Size(min = 5, max = 100, message = "O campo NOME tem que ter de 5 a 100 caracteres.")
    private String nome;
    
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "cpf", nullable = false, length = 14)
    //@CPF(message = "CPF inválido.")
    private String cpf;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Aluno aluno;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Professor professor;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }  
    
}

