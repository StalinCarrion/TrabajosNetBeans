/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Estudiante;
import Clases.Representante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class DataRepresentante extends Conexion {

    public ArrayList<Representante> ListarRepresentante() {
        ArrayList<Representante> arrayListRepresentantes = new ArrayList<Representante>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select idRepresentante, nombres, cedula, apellidos from examen.representante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Representante objRepresentante = new Representante();
                objRepresentante.setIdRepresentante(rs.getInt("idRepresentante"));
                objRepresentante.setNombres(rs.getString("nombres"));
                objRepresentante.setCedula(rs.getInt("cedula"));
                objRepresentante.setApellidos(rs.getString("apellidos"));
                arrayListRepresentantes.add(objRepresentante);
            }
            return arrayListRepresentantes;
            
        } catch (Exception e) {
            System.err.println(e);
            return arrayListRepresentantes;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
        
    }
    
    public ArrayList<Estudiante> ListarEstudiantes(Representante objRepresentante) {
        ArrayList<Estudiante> arrayListEstudiante = new ArrayList<Estudiante>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select estudiante.idEstudiante, nombres, nombresEst,"
                + " apellidosEst, edadEst from estudiante,"
                + " representante "
                + "where estudiante.idRepresentante = representante.idRepresentante "
                + "and representante.cedula = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objRepresentante.getCedula());
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante objEstudiante = new Estudiante();
                objEstudiante.setNombres(rs.getString("nombresEst"));
                objEstudiante.setApellidos(rs.getString("apellidosEst"));
                objEstudiante.setEdad(rs.getInt("edadEst"));
                objEstudiante.setIdEstudiante(rs.getInt("idEstudiante"));
                arrayListEstudiante.add(objEstudiante);
            }
            return arrayListEstudiante;
            
        } catch (Exception e) {
            System.err.println(e);
            return arrayListEstudiante;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
        
    }

}
