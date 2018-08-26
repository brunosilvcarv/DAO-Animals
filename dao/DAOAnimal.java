/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Especie;
import model.Raca;


public class DAOAnimal {
    
    
    public void inserirAnimal(Animal a) throws DAOException, SQLException
    {
        Connection conexao = null;
        
        try
        {
            conexao = ControleConexao.getConnection();
            
            String comando = "Insert Into animal(nomeanimal, propanimal, racaanimal, espanimal) Values (?,?,?,?)";
            PreparedStatement instrucao = conexao.prepareStatement(comando);
            instrucao.setString(1, a.getNome());
            instrucao.setString(2, a.getProprietario());
            instrucao.setInt(3, a.getRaca().getId());
            instrucao.setInt(4, a.getRaca().getEspecie().getId());
            instrucao.execute();
        }
        catch(SQLException e)
        { 
            throw new DAOException("Ocorreu um erro no cadastro.",e);
        }
        finally{
            ControleConexao.closeConnection(conexao); 
        }
        
    }
    
    public List<Animal> pesquisar(String texto) throws ParseException, SQLException, DAOException{
        Connection conexao = null;
        List<Animal> animais = new ArrayList<>();

        try {
            conexao = ControleConexao.getConnection();

            String comando = "";
            PreparedStatement instrucao = null;
           
            if (texto.trim().equals("")){
                comando = "SELECT idanimal, propanimal, racaanimal, nomeanimal, idraca, espraca, nomeraca, idespecie, nomeespecie FROM animal "
                    + " INNER JOIN raca ON racaanimal = idraca " 
                    + " INNER JOIN especie ON espraca = idespecie ";
                instrucao = conexao.prepareStatement(comando);
            }
            else
            {
                
                comando = "SELECT idanimal, propanimal, racaanimal, nomeanimal, idraca, espraca, nomeraca, idespecie, nomeespecie FROM animal "
                    + " INNER JOIN raca ON racaanimal = idraca " 
                    + " INNER JOIN especie ON espraca = idespecie "
                    + " WHERE nomeanimal LIKE ?";
                instrucao = conexao.prepareStatement(comando);
                instrucao.setString(1, "%" + texto + "%");
                
            }
                   
            ResultSet resultado = instrucao.executeQuery();

            while (resultado.next()) {
                Especie especie = new Especie();
                Raca raca = new Raca();
                Animal animal = new Animal();
                
                especie.setId(resultado.getInt("idespecie"));
                especie.setNome(resultado.getString("nomeespecie"));
    
                raca.setId(resultado.getInt("idraca"));
                raca.setNome(resultado.getString("nomeraca"));
                raca.setEspecie(especie);
                
                animal.setId(resultado.getInt("idanimal"));
                animal.setNome(resultado.getString("nomeanimal"));
                animal.setProprietario(resultado.getString("propanimal"));
                animal.setRaca(raca);
                animais.add(animal);
           }
        }
        catch(SQLException e)
        {
            throw new DAOException("Ocorreu um erro na consulta.",e);
        }
        finally{
            
            ControleConexao.closeConnection(conexao); 
        }

        return animais;
    }
   
    public void excluir(int id) throws DAOException, SQLException {
        Connection conexao = null;

        try {
            conexao = ControleConexao.getConnection(); 

            String comando = "DELETE FROM animal WHERE idanimal= ?";

            PreparedStatement instrucao = conexao.prepareStatement(comando);
            instrucao.setInt(1, id);
            instrucao.execute();
        }
        catch(SQLException e)
        {
            throw new DAOException("Ocorreu um erro na exclusão.",e);
        }
        finally{
            
            ControleConexao.closeConnection(conexao); 
        }
    }
}