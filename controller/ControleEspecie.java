/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOEspecie;
import exception.DAOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Especie;

public class ControleEspecie {
    
    private List<Especie> especies = new ArrayList<>();
    DAOEspecie dao_especie = new DAOEspecie();
    Especie especie = new Especie();
      
    public List<Especie> pesquisar(String texto) throws ParseException, SQLException, DAOException
    {
        DAOEspecie dao_especie = new DAOEspecie();
        this.especies = dao_especie.pesquisar(texto);
        return especies;
    }
    
    public void setEspecie(Especie esp)
    {
        this.especie = esp;
    }
    
     public void inserir() throws DAOException, SQLException
    {
        dao_especie.inserirEspecie(this.especie);
    }
    
    public void excluir() throws DAOException, SQLException
    {
        dao_especie.excluir(this.especie.getId());
    }   
}
