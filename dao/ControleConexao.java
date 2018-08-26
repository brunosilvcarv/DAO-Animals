/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ControleConexao {
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost/ifampig","root"," ");
    }
    
    public static void closeConnection(Connection conexao) throws SQLException{
       try{
           if (conexao != null)
           {
                conexao.close();
           } 
       }
       catch(SQLException e)
       {
           new DAOException("Erro ao fechar a conexão.",e);
       }
       
    }
}
