
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOAnimal;
import exception.DAOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;

public class ControleAnimais {
    private Animal animal;
    private List<Animal> animais = new ArrayList<>();
    private DAOAnimal daoanimal = new DAOAnimal();
    
    public void setAnimal(Animal a)
    {
        this.animal = a;
    }
    
    public Animal getAnimal()
    {
        return this.animal;
    }
    
    public List<Animal> listar(String texto) throws ParseException, SQLException, DAOException
    {
       this.animais = daoanimal.pesquisar(texto);
       return this.animais;
    }
    
    public void salvar() throws DAOException, SQLException
    {
        daoanimal.inserirAnimal(this.animal);
    }
    
    public void excluir() throws DAOException, SQLException
    {
        daoanimal.excluir(this.animal.getId());
    }
}
