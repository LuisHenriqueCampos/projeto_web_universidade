/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.IService;

import br.com.universidade.aplicacao.Materia;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface IMateriaService {
    
    String salvar(Materia materia);
    String remover(Integer idMateria);
    List<Materia> listar();
    Materia obter(Integer id);
    
}
