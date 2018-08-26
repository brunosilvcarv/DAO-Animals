/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Raca {
    private int id;
    private String nome;
    private Especie especie;
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setEspecie(Especie esp)
    {
        this.especie = esp;
    }
    
    public Especie getEspecie()
    {
        return this.especie;
    }
}
