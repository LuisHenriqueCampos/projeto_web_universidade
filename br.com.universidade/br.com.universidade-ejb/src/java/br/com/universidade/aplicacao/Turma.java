package br.com.universidade.aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "turma")
public class Turma {
    
    @Column(name = "idTurma", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;
    
    @NotNull(message = "O campo Nome da Turma não pode ser Nulo.")
    @Size(min = 5, max = 45, message = " O campo Nome da Turma deve ter no mínimo 5 e no máximo 45 caracteres ")
    @Column(name = "nomeTurma", nullable = false, length = 45)
    private String nomeTurma;
    
    @NotNull(message = "O campo Horário Início não pode ser Nulo.")
    @Column(name = "horarioInicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horarioInicio;
    
    @NotNull(message = "O campo Horário Fim não pode ser Nulo.")
    @Column(name = "horarioFim", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horarioFim;
    
    @NotNull(message = "O campo Quantidade de Vagas não pode ser Nulo.")
    @Column(name = "quantidadeVagas", nullable = false)
    private Integer quantidadeVagas;
    
    @NotNull(message = "O campo Curso não pode ser Nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;
    
    @NotNull(message = "O campo Período Letivo não pode ser Nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPeriodoLetivo", nullable = false)
    private PeriodoLetivo periodoLetivo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Date horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Integer getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(Integer quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idTurma);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.idTurma, other.idTurma)) {
            return false;
        }
        return true;
    }
    
}
