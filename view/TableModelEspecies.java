/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exception.DAOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Especie;


public class TableModelEspecies extends AbstractTableModel{

    private Especie especie;
    private List<Especie> especies;
    
    public TableModelEspecies(List<Especie> especies)
    {
        this.especies = especies;
    }
    
    @Override
    public int getRowCount() {
        return especies.size();
       
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        especie = especies.get(linha);
        
        switch(coluna){
            case 0 : return especie.getId();
            case 1 : return especie.getNome();
            
        }
        
        return null;
    }
    
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Id";
            case 1 : return "Nome";
       
        } 
        return null;
    }
}
