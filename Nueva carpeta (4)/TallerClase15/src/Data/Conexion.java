/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;


public class Conexion {
    private final String base = "taller03";
    private final String usuario = "root";
    private final String clave = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
   
            
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return con;
    }
    
    public java.sql.Connection AbrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConexion();
        return con;
    }
    
    public void CerrarConexion() throws SQLException
    {
       con.close();
    }
}
