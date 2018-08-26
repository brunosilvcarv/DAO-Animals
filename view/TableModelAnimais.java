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


public class TableModelAnimais extends AbstractTableModel{

    private Animal animal;
    private List<Animal> animais;
    
    public TableModelAnimais(List<Animal> animais)
    {
        this.animais = animais;
    }
    
    @Override
    public int getRowCount() {
        return animais.size();
       
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        animal = animais.get(linha);
        
        switch(coluna){
            case 0 : return animal.getId();
            case 1 : return animal.getNome();
            case 2 : return animal.getProprietario();
            case 3 : return animal.getRaca().getNome();
        }
        
        return null;
    }
    
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Id";
            case 1 : return "Nome do animal";
            case 2 : return "Proprietário";
            case 3 : return "Raça";            
        } 
        return null;
    }
}
