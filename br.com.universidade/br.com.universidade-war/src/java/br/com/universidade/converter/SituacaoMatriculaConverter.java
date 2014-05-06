/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.SituacaoMatricula;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luis
 */
@FacesConverter(value = "situacaoMatriculaConverter",forClass = SituacaoMatricula.class)
public class SituacaoMatriculaConverter implements Converter{
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Short id = Short.parseShort(value);
            SituacaoMatricula sit = new SituacaoMatricula();
            sit.setIdSituacaoMatricula(id);
            return sit;
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.getClass() != SituacaoMatricula.class)
            return null;
        SituacaoMatricula sit = (SituacaoMatricula) value;
        return sit.getIdSituacaoMatricula().toString();
        
    }
}