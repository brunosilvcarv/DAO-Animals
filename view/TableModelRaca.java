/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControleAnimais;
import exception.DAOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Animal;
import model.Raca;


public class TableModelRaca extends AbstractTableModel{

    private Raca raca;
    private List<Raca> racas;
    
    public TableModelRaca(List<Raca> racas)
    {
        this.racas = racas;
    }
    
    @Override
    public int getRowCount() {
        return racas.size();
       
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        raca = racas.get(linha);
        
        switch(coluna){
            case 0 : return raca.getId();
            case 1 : return raca.getNome();
            case 2 : return raca.getEspecie().getNome();
        }
        
        return null;
    }
    
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Id";
            case 1 : return "Nome";
            case 2 : return "Espécie";           
        } 
        return null;
    }
}
