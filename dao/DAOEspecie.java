/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Especie;


public class DAOEspecie {
    
    public List<Especie> listar() throws ParseException, SQLException, DAOException{
        Connection conexao = null;
        List<Especie> especies = new ArrayList<>();

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "";
            PreparedStatement instrucao;
           
            comando = "SELECT idespecie, nomeespecie FROM especie ";
            instrucao = conexao.prepareStatement(comando);
          
            ResultSet resultado = instrucao.executeQuery();

            while (resultado.next()) {
                Especie eRes = new Especie();

                eRes.setId(resultado.getInt("idespecie"));
                eRes.setNome(resultado.getString("nomeespecie"));
                especies.add(eRes);
           }
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
            throw new DAOException("Ocorreu um erro na consulta.",e);
        }
        finally{
            
            DAO.ControleConexao.closeConnection(conexao); 
        }

        return especies;
    }
    
        public void inserirEspecie(Especie esp) throws DAOException, SQLException
    {
        Connection conexao = null;
        
        try
        {
            conexao = DAO.ControleConexao.getConnection();
            
            String comando = "Insert Into especie(nomeespecie) Values (?)";
            PreparedStatement instrucao = conexao.prepareStatement(comando);
            instrucao.setString(1, esp.getNome());     
           
            instrucao.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
            throw new DAOException("Ocorreu um erro no cadastro.",e);
        }
        finally{
            DAO.ControleConexao.closeConnection(conexao); 
        }
        
    }
    
    
     public List<Especie> pesquisar(String texto) throws ParseException, SQLException, DAOException{
        Connection conexao = null;
        List<Especie> especies = new ArrayList<>();

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "";
            PreparedStatement instrucao = null;
           
            if (texto.equals(""))
            {
                
                comando = "SELECT idespecie, nomeespecie FROM especie ";
                instrucao = conexao.prepareStatement(comando);
            }
            else
            {
                comando = "SELECT idespecie, nomeespecie FROM especie "
                        + "Where nomeespecie Like ?";
                instrucao = conexao.prepareStatement(comando);
                instrucao.setString(1, "%" + texto + "%");
            }
           
                   
            ResultSet resultado = instrucao.executeQuery();

            while (resultado.next()) {
                Especie especie = new Especie();
                                
                especie.setId(resultado.getInt("idespecie"));
                especie.setNome(resultado.getString("nomeespecie"));  
                
                especies.add(especie);
           }
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
            throw new DAOException("Ocorreu um erro na consulta.",e);
        }
        finally{
            
            DAO.ControleConexao.closeConnection(conexao); 
        }

        return especies;
    }    
    
    
    
    
     public void excluir(int id) throws DAOException, SQLException {
        Connection conexao = null;

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "DELETE FROM especie WHERE idespecie = ?";
            PreparedStatement instrucao = conexao.prepareStatement(comando);
            instrucao.setInt(1, id);
            instrucao.execute();
        }
        catch(SQLException e)
        {
            throw new DAOException("Ocorreu um erro na exclusão.",e);
        }
        finally{
            
            DAO.ControleConexao.closeConnection(conexao); 
        }
     } 
}
