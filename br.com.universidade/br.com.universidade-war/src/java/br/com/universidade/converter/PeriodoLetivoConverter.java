/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.PeriodoLetivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luis
 */
@FacesConverter(value = "periodoLetivoConverter",forClass = PeriodoLetivo.class)
public class PeriodoLetivoConverter implements Converter{
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Short id = Short.parseShort(value);
            PeriodoLetivo pl = new PeriodoLetivo();
            pl.setIdPeriodoLetivo(id);
            return pl;
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.getClass() != PeriodoLetivo.class)
            return null;
        PeriodoLetivo pl = (PeriodoLetivo) value;
        return pl.getIdPeriodoLetivo().toString();
        
    }
}