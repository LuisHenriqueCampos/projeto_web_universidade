package br.com.universidade.aplicacao;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Column(name = "idCurso", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idCurso;
    
    @Size(min = 5, max = 45, message = " O campo SCurso deve ter no mínimo 5 e no máximo 45 caracteres ")
    @NotNull(message = "O campo Curso não pode ser Nulo.")
    @Column(name = "nomeCurso", nullable = false, length = 45)
    private String nomeCurso;
    
    @NotNull(message = "O campo Carga Horária não pode ser Nulo.")
    @Column(name = "cargaHoraria", nullable = false)
    private Integer cargaHoraria;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Turma> turmas;
    
    @NotNull(message = "É necessário selecionar ao menos 1 matéria.")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cursomateria",
            joinColumns = @JoinColumn(name = "idCurso"),
            inverseJoinColumns = @JoinColumn(name = "idMateria"))
    private List<Materia> materias;

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

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idCurso);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.idCurso, other.idCurso)) {
            return false;
        }
        return true;
    }
    
}
