/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author STALIN
 */
public class DataConsulta extends Conexion{
    Conexion conecta = new Conexion();
    
    public ResultSet ObtenerProvincia()throws ClassNotFoundException, SQLException{
        Statement consulta = conecta.getConexion().createStatement();
        String Sentencia = "SELECT * FROM provincia order by 2 ";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = consulta.executeQuery(Sentencia);//recupera un ResultSet y envio la varible a executeQuery
        return rs;
       
    }
    
     public ResultSet ObtenerCanton()throws ClassNotFoundException, SQLException{
         Statement consulta = conecta.getConexion().createStatement();
         String Sentencia = "SELECT * FROM provincia order by 2 ";/
        
    }
    
    
     
    
}
