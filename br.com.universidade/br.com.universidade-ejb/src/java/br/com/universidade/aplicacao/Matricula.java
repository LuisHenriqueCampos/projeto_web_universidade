package br.com.universidade.aplicacao;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "matricula")
public class Matricula {
    
    @Column(name = "idMatricula", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
    
    @Column(name = "dataMatricula", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMatricula;
    
    @Column(name = "notaFinal", nullable = true)
    private Double notaFinal;
    
    @NotNull(message = "O campo Aluno não pode ser Nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAluno", referencedColumnName = "idPessoa", nullable = false)
    private Aluno aluno;
    
    @NotNull(message = "O campo Situação da Matrícula não pode ser Nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSituacaoMatricula", nullable = false)
    private SituacaoMatricula situacaoMatricula;
    
    @NotNull(message = "O campo Turma não pode ser Nulo.")
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idMatricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.idMatricula, other.idMatricula)) {
            return false;
        }
        return true;
    }
       
}

