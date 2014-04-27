package br.com.universidade.aplicacao;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Column(name = "idCurso", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idCurso;
    
    @Column(name = "nomeCurso", nullable = false, length = 45)
    private String nomeCurso;
    
    @Column(name = "cargaHoraria", nullable = false)
    private Integer cargaHoraria;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Turma> turmas;

    public Short getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Short idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
}
