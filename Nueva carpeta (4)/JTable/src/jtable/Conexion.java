package jtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelson Castiblanco
 */
public class Conexion {
        
    private static Connection conexion;
    private static Statement statement;
    private static String IP = "localhost", PUERTO = "5432", BD = "GYM", USER = "postgres", PASS = "admin";

    public Conexion() {
    }        
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://"+IP+":"+PUERTO+"/"+BD, USER, PASS);
            statement = conexion.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);            
        }catch (ClassNotFoundException | SQLException ex){}
        return conexion;
    }
}
