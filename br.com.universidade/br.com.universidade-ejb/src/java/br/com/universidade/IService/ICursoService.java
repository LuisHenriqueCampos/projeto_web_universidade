/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.IService;

import br.com.universidade.aplicacao.Curso;
import br.com.universidade.model.GraficoCursoModel;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface ICursoService {
    
    List<Curso> listar();
    String remover(Short idCurso);
    String salvar(Curso curso);
    Curso obter(Short id);
    List<GraficoCursoModel> consultaGrafico();
}
