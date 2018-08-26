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
import model.Raca;



public class DAORaca {
    
    public List<Raca> listarRaca(int id) throws ParseException, SQLException, DAOException{
        Connection conexao = null;
        List<Raca> racas = new ArrayList<>();

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "";
            PreparedStatement instrucao;
           
            
            if (id != 0)
            {
            
                comando = "SELECT idraca, espraca, nomeraca, idespecie, nomeespecie FROM raca "
                    + "INNER JOIN especie ON espraca = idespecie "
                    + "Where espraca = ?";
                    instrucao = conexao.prepareStatement(comando);
                    instrucao.setInt(1, id);
            }
            else
            {
                comando = "SELECT idraca, espraca, nomeraca, idespecie, nomeespecie FROM raca "
                    + "INNER JOIN especie ON espraca = idespecie ";
                 instrucao = conexao.prepareStatement(comando); 
            
            }
   
            ResultSet resultado = instrucao.executeQuery();

            while (resultado.next()) {
                Raca rRes = new Raca();
                Especie especie = new Especie();
                
                especie.setId(resultado.getInt("idespecie"));
                especie.setNome(resultado.getString("nomeespecie"));
                
                rRes.setId(resultado.getInt("idraca"));
                rRes.setNome(resultado.getString("nomeraca"));
                
                rRes.setEspecie(especie);
                racas.add(rRes);
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

        return racas;
    } 
    
    public List<Raca> pesquisarRaca(String texto) throws ParseException, SQLException, DAOException{
        Connection conexao = null;
        List<Raca> racas = new ArrayList<>();

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "";
            PreparedStatement instrucao;
           
            if (texto.equals(""))
            {

                comando = "SELECT idraca, nomeraca, idespecie, nomeespecie FROM raca "
                    + "INNER JOIN especie ON espraca = idespecie ";
                    instrucao = conexao.prepareStatement(comando);
            }
            else
            {
                comando = "SELECT idraca, nomeraca, idespecie, nomeespecie FROM raca "
                    + "INNER JOIN especie ON espraca = idespecie "
                    + "WHERE nomeraca LIKE ? ";
                    instrucao = conexao.prepareStatement(comando);
                    instrucao.setString(1, "%" + texto + "%");
            }
                
   
            ResultSet resultado = instrucao.executeQuery();

            while (resultado.next()) {
                Raca rRes = new Raca();
                Especie rEsp = new Especie();
                
                rRes.setId(resultado.getInt("idraca"));
                rRes.setNome(resultado.getString("nomeraca"));
                rEsp.setId(resultado.getInt("idespecie"));
                rEsp.setNome(resultado.getString("nomeespecie"));
                rRes.setEspecie(rEsp);
                racas.add(rRes);
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

        return racas;
    }
    
    public void inserirRaca(Raca r) throws DAOException, SQLException
    {
        Connection conexao = null;
        
        try
        {
            conexao = DAO.ControleConexao.getConnection();
            
            String comando = "Insert Into raca(idraca, espraca, nomeraca) Values (?,?,?)";
            PreparedStatement instrucao = conexao.prepareStatement(comando);
            instrucao.setInt(1, r.getId());
            instrucao.setInt(2, r.getEspecie().getId());
            instrucao.setString(3, r.getNome());
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
     
    public void excluirRaca(int id) throws DAOException, SQLException {
        Connection conexao = null;

        try {
            conexao = DAO.ControleConexao.getConnection();

            String comando = "DELETE FROM raca WHERE idraca= ?";

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
