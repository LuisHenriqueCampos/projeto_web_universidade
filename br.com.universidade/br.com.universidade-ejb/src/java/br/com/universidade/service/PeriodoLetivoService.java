package br.com.universidade.service;

import br.com.universidade.IService.IPeriodoLetivoService;
import br.com.universidade.aplicacao.PeriodoLetivo;
import br.com.universidade.data.IGenericDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

@Stateless
public class PeriodoLetivoService implements IPeriodoLetivoService{

    @Inject
    private IGenericDAO<PeriodoLetivo> periodoLetivoDao;
    
    @Override
    public List<PeriodoLetivo> listar() {
        TypedQuery<PeriodoLetivo> periodoLetivoQuery =
                periodoLetivoDao.getEntityManager()
                        .createQuery("SELECT pl FROM PeriodoLetivo pl",PeriodoLetivo.class);
        return periodoLetivoDao.all(periodoLetivoQuery);
    }

    @Override
    public String remover(Short idPeriodoLetivo) {
        try{
            PeriodoLetivo periodoLetivo = obter(idPeriodoLetivo);
            periodoLetivoDao.delete(periodoLetivo);
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public String salvar(PeriodoLetivo periodoLetivo) {
        try{
            if(periodoLetivo.getIdPeriodoLetivo() != null){
                periodoLetivoDao.update(periodoLetivo);
            }else{
                periodoLetivoDao.save(periodoLetivo);
            }
        }catch(Exception ex){
            return ex.getMessage();
        }
        return null;
    }

    @Override
    public PeriodoLetivo obter(Short id) {
        PeriodoLetivo periodoLetivo = periodoLetivoDao
                .getEntityManager().find(PeriodoLetivo.class, id);
        return periodoLetivo;
    }
}
