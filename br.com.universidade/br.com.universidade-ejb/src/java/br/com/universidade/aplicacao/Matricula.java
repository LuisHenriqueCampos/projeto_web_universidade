package br.com.universidade.aplicacao;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {
    
    @Column(name = "idMatricula", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
    
    @Column(name = "dataMatricula", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataMatricula;
    
    @Column(name = "notaFinal", nullable = true)
    private Double notaFinal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAluno", nullable = false)
    private Aluno aluno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSituacaoMatricula", nullable = false)
    private SituacaoMatricula situacaoMatricula;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTurma", nullable = false)
    private Turma turma;

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public SituacaoMatricula getSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(SituacaoMatricula situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    } 

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
       
}

