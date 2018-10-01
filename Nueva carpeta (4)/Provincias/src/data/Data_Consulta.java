/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import clases.Provincia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Avδρέας
 */
public class Data_Consulta {

    private Conexion conecta = new Conexion();
    
    public ResultSet ObtenerProvincia() throws ClassNotFoundException, SQLException{
        Statement consulta = conecta.getConexion().createStatement();
        String sql = "SELECT * FROM provincia ORDER BY Nombre";
        return consulta.executeQuery(sql);
    }
    
    public ResultSet ObtenerCanton(Provincia objPro) throws ClassNotFoundException, SQLException{
        Statement consulta = conecta.getConexion().createStatement();
        String sql = "select Nombre from canton where idProvincia = "+objPro.getIdPro();
        return consulta.executeQuery(sql);
    }
}
