/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luis
 */
@FacesConverter(value = "cursoConverter",forClass = Curso.class)
public class CursoConverter implements Converter{
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Short id = Short.parseShort(value);
            Curso curso = new Curso();
            curso.setIdCurso(id);
            return curso;
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.getClass() != Curso.class)
            return null;
        Curso curso = (Curso) value;
        return curso.getIdCurso().toString();
        
    }
}