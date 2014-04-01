package br.com.universidade.aplicacao;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    
    @Column(name = "idMateria", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idMateria;
    
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "materias")
    private List<Curso> cursos;

    public Short getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Short idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    } 
    
}

