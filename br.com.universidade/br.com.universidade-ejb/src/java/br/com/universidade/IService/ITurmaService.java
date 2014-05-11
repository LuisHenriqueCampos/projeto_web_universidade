/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.IService;

import br.com.universidade.aplicacao.Turma;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface ITurmaService {
    
    List<Turma> listar();
    String salvar(Turma turma);
    String remover(Integer idTurma);
    Turma obter(Integer id);
    
}
