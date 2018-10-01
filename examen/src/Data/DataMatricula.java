/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author STALIN
 */
public class DataMatricula extends Conexion{
    
    public boolean InsertarMatricula(Matricula objMatricula){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql ="INSERT INTO `examen`.`matricula` "
                + "(`mail`, `celular`, `observacion`, "
                + "`idRepresentante`, `idEstudiante`, "
                + "`idGrado`)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, objMatricula.getMail());
            ps.setString(2, objMatricula.getCelular());
            ps.setString(3, objMatricula.getObservacion());
            ps.setInt(4, objMatricula.getRepresentante().getIdRepresentante());
            
            ps.setInt(5, objMatricula.getEstudiante().getIdEstudiante());
            ps.setInt(6, objMatricula.getGrado().getIdGrado());
            System.out.println("1 "+ps);
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
    
}
