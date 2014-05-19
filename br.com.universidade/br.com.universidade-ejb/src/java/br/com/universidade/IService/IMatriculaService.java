/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.IService;

import br.com.universidade.aplicacao.Matricula;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface IMatriculaService {
    
    List<Matricula> listar();
    String salvar(Matricula matricula);
    String remover(Integer idMatricula);
    Matricula obter(Integer id);
    
}
