/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Cuenta;
import Clases.Oficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UTPL
 */
public class DataOficial extends Conexion {
    public  Oficial BuscarOficialCuenta(String NumCue){
        Oficial ObjOfi = new Oficial();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select oficial.* from oficial, cuenta"
                + " where oficial.idOfic = cuenta.idOfic "
                + "and cuenta.numero = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjOfi.setCedula(rs.getString("Cedula"));
                ObjOfi.setApellidos(rs.getString("Apellidos"));
                ObjOfi.setNombres(rs.getString("Nombres")); 
                ObjOfi.setSucursal(Integer.parseInt(rs.getString("Sucursal")));
            }
            return ObjOfi;
        } catch (Exception e) {
            System.err.println(e);
            return ObjOfi;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
}
