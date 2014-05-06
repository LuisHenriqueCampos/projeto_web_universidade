/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.converter;

import br.com.universidade.aplicacao.Materia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luis
 */
@FacesConverter(value = "materiaConverter",forClass = Materia.class)
public class MateriaConverter implements Converter{
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Integer id = Integer.parseInt(value);
            Materia mat = new Materia();
            mat.setIdMateria(id);
            return mat;
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.getClass() != Materia.class)
            return null;
        Materia mat = (Materia) value;
        return mat.getIdMateria().toString();
        
    }
}