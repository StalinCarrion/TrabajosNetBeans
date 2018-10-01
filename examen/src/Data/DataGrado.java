/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Clases.AnioLectivo;
import Clases.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class DataGrado extends Conexion{
    
    public ArrayList<Grado> ListarGrados(AnioLectivo objAnioLectivo) {
        ArrayList<Grado> arrayListGrados = new ArrayList<Grado>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select grado.idGrado, DescripcionGra, Paralelo, Codigo, descripcion from "
                + "grado, aniolectivo "
                + "where grado.idAnioLectivo = aniolectivo.idAnioLectivo "
                + "and grado.idAnioLectivo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objAnioLectivo.getIdAnioLectivo());
            rs = ps.executeQuery();
            while (rs.next()) {
                Grado objGrado = new Grado();
                objGrado.setDescripcion(rs.getString("DescripcionGra"));
                objGrado.setParalelo(rs.getString("Paralelo"));
                objGrado.setCodigo(rs.getString("Codigo"));
                objGrado.setIdGrado(rs.getInt("idGrado"));
                arrayListGrados.add(objGrado);
            }
            return arrayListGrados;
            
        } catch (Exception e) {
            System.err.println(e);
            return arrayListGrados;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
        
    }
    
}
