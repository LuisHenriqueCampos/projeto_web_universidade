package br.com.universidade.aplicacao;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {
    
    @Column(name = "idTurma", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;
    
    @Column(name = "nomeTurma", nullable = false, length = 45)
    private String nomeTurma;
    
    @Column(name = "horarioInicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horarioInicio;
    
    @Column(name = "horarioFim", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horarioFim;
    
    @Column(name = "quantidadeVagas", nullable = false)
    private Integer quantidadeVagas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;
    
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
    
}
