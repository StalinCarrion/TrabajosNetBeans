/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Clases.AnioLectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class DataAnio extends Conexion{
    
    public ArrayList<AnioLectivo> ListarAnio() {
        ArrayList<AnioLectivo> arrayListAnioLectivos = new ArrayList<AnioLectivo>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select idAnioLectivo, FechaInicio, FechaFin, Descripcion from examen.aniolectivo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AnioLectivo objAnioLectivo = new AnioLectivo();
                objAnioLectivo.setIdAnioLectivo(rs.getInt("idAnioLectivo"));
                objAnioLectivo.setFechaInicio(rs.getString("FechaInicio"));
                objAnioLectivo.setFechaFin(rs.getString("FechaFin"));
                objAnioLectivo.setDescripcion(rs.getString("Descripcion"));
                arrayListAnioLectivos.add(objAnioLectivo);
            }
            return arrayListAnioLectivos;
            
        } catch (Exception e) {
            System.err.println(e);
            return arrayListAnioLectivos;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
        
    }
    
}
