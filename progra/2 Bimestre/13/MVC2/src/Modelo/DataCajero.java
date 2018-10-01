/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Cajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.misc.Resource;

/**
 *
 * @author UTPL
 */
public class DataCajero extends Conexion {
    public Cajero BuscarCajero(Cajero ObjAux){
        Cajero ObjCaj = new Cajero();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cajero WHERE cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjAux.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjCaj.setCedula(rs.getString("Cedula"));
                ObjCaj.setNombres(rs.getString("Apellidos"));
                ObjCaj.setApellidos(rs.getString("Nombres"));
                ObjCaj.setCaja(Integer.parseInt(rs.getString("caja")));  

            }
            return ObjCaj;
        } catch (Exception e) {
            System.err.println(e);
            return ObjCaj;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
    public boolean BuscarCajeroB (Cajero caj) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cajero WHERE Cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, caj.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                
                caj.setNombres(rs.getString("Nombres"));
                caj.setApellidos(rs.getString("Apellidos"));
                caj.setCedula(rs.getString("Cedula"));
                caj.setCaja(Integer.parseInt(rs.getString("Caja")));
                return true;
            }
            return false;
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
    
    
    public boolean InsertarCajero(Cajero ObjCaj) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO Cajero (cedula, Apellidos, Nombres, Caja) "
                + "VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjCaj.getCedula());
            ps.setString(3, ObjCaj.getNombres());
            ps.setString(2, ObjCaj.getApellidos());
            ps.setInt(4, ObjCaj.getCaja());
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
