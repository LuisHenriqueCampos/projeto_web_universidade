package br.com.universidade.aplicacao;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "situacaomatricula")
public class SituacaoMatricula {
    
    @Column(name = "idSituacaoMatricula", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idSituacaoMatricula;
    
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "situacaoMatricula", cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    public Short getIdSituacaoMatricula() {
        return idSituacaoMatricula;
    }

    public void setIdSituacaoMatricula(Short idSituacaoMatricula) {
        this.idSituacaoMatricula = idSituacaoMatricula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash = 17 * hash + Objects.hashCode(this.idSituacaoMatricula);
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
        final SituacaoMatricula other = (SituacaoMatricula) obj;
        if (!Objects.equals(this.idSituacaoMatricula, other.idSituacaoMatricula)) {
            return false;
        }
        return true;
    }
    
}
