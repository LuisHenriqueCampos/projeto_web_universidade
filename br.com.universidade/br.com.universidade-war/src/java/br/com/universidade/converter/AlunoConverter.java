/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.Aluno;
import br.com.universidade.aplicacao.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luis
 */
@FacesConverter(value = "alunoConverter",forClass = Aluno.class)
public class AlunoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        System.err.println("Post = "+ value);
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Integer id = Integer.parseInt(value);
            Aluno aluno = new Aluno();
            Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(id);
            aluno.setPessoa(pessoa);
            aluno.setIdPessoa(id);
            return aluno;
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        System.err.println("Value = "+ value);
        if(value == null || value.getClass() != Aluno.class)
            return null;
        Aluno aluno = (Aluno) value;
        return aluno.getPessoa().getIdPessoa().toString();
        
    }
}

