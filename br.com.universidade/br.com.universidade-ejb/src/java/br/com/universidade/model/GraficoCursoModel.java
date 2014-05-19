/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.universidade.model;

/**
 *
 * @author Luis
 */
public class GraficoCursoModel {
    
    private String nomeCurso;
    private int quantidadeMateria;
    
    public GraficoCursoModel(String nome, int quantidade){
        this.nomeCurso = nome;
        this.quantidadeMateria = quantidade;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getQuantidadeMateria() {
        return quantidadeMateria;
    }

    public void setQuantidadeMateria(int quantidadeMateria) {
        this.quantidadeMateria = quantidadeMateria;
    }
    
    
    
}
