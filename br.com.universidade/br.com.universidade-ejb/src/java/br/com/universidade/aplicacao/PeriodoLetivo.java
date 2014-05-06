package br.com.universidade.aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "periodoletivo")
public class PeriodoLetivo {
    
    @Column(name = "idPeriodoLetivo", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idPeriodoLetivo;
    
    @Column(name = "descricao", nullable = false, length = 45)
    @NotNull
    private String descricao;
    
    @Column(name = "dataInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Column(name = "dataFim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "periodoLetivo", cascade = CascadeType.ALL)
    private List<Turma> turmas;

    public Short getIdPeriodoLetivo() {
        return idPeriodoLetivo;
    }

    public void setIdPeriodoLetivo(Short idPeriodoLetivo) {
        this.idPeriodoLetivo = idPeriodoLetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
        
    }   

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idPeriodoLetivo);
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
        final PeriodoLetivo other = (PeriodoLetivo) obj;
        if (!Objects.equals(this.idPeriodoLetivo, other.idPeriodoLetivo)) {
            return false;
        }
        return true;
    }
    
}
