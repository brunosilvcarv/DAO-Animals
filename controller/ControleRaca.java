/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAORaca;
import exception.DAOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Raca;


public class ControleRaca {
    
private List<Raca> racas = new ArrayList<>();
    private Raca raca = new Raca();
    DAORaca daoraca = new DAORaca();
    
    public void setRaca(Raca r){
        this.raca = r;
    }
    
    public List<Raca> listar(int id) throws ParseException, SQLException, DAOException
    {
        this.racas = daoraca.listarRaca(id);
        return racas;
    }
    
    public List<Raca> pesquisar(String texto) throws ParseException, SQLException, DAOException
    {
        
        this.racas = daoraca.pesquisarRaca(texto);
        return racas;
    }
    public void inserir() throws DAOException, SQLException{
        daoraca.inserirRaca(this.raca);
    }
    
    public void excluir() throws DAOException, SQLException{
        daoraca.excluirRaca(this.raca.getId());
    }
    
}
