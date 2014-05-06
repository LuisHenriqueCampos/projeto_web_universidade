/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.Aluno;
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
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Integer id = Integer.parseInt(value);
            Aluno aluno = new Aluno();
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
        if(value == null || value.getClass() != Aluno.class)
            return null;
        Aluno aluno = (Aluno) value;
        return aluno.getPessoa().getIdPessoa().toString();
        
    }
}

