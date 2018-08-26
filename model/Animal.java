/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



public class Animal {
    private int id;
    private String nome;
    private String proprietario;
    private Raca raca;
    
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
    
    public void setProprietario(String prop)
    {
        this.proprietario = prop;
    }
    
    public String getProprietario(){
        return this.proprietario;
    }
    
    public void setRaca(Raca raca)
    {
        this.raca = raca;
    }
    
    public Raca getRaca(){
        return this.raca;
    }
            
    
    
}
