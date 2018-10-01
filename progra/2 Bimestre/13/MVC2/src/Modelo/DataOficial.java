/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Oficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UTPL
 */
public class DataOficial extends Conexion {
    
    public boolean BuscarOficialIdB(Oficial ofi) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM oficial WHERE idOficial=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ofi.getIdOficial());
            rs = ps.executeQuery();
            if (rs.next()) {
                ofi.setIdOficial(rs.getInt("idOficial"));
                ofi.setCedula(rs.getString("Cedula"));
                ofi.setNombres(rs.getString("Apellidos"));
                ofi.setApellidos(rs.getString("Nombres"));
                ofi.setSucursal(rs.getInt("Sucursal"));
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
    
    public boolean BuscarOficialB(Oficial ofi){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM oficial WHERE Cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ofi.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                ofi.setCedula(rs.getString("Cedula"));
                ofi.setNombres(rs.getString("Apellidos"));
                ofi.setApellidos(rs.getString("Nombres"));
                ofi.setSucursal(rs.getInt("Sucursal"));  
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
    public  Oficial BuscarOficialCuenta(String NumCue){
        Oficial ObjOfi = new Oficial();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select oficial.* from oficial, cuenta"
                + " where oficial.idOficial = cuenta.Oficial_idOficial "
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
    
    public Oficial BuscarOficial(Oficial ObjAux){
        
        Oficial ObjOfi = new Oficial();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM oficial WHERE cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjAux.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjOfi.setCedula(rs.getString("Cedula"));
                ObjOfi.setNombres(rs.getString("Apellidos"));
                ObjOfi.setApellidos(rs.getString("Nombres"));
                ObjOfi.setSucursal(rs.getInt("Sucursal"));  

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
    
    
    public boolean InsertarOficial(Oficial ObjOfi) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO oficial (Cedula, Nombres, Apellidos, Sucursal) "
                + "VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjOfi.getCedula());
            ps.setString(2, ObjOfi.getNombres());
            ps.setString(3, ObjOfi.getApellidos());
            ps.setInt(4, ObjOfi.getSucursal());
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
    
    public Oficial BuscarOficialId(Oficial ObjAux) {

        Oficial ObjOfi = new Oficial();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM oficial WHERE idOficial=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ObjAux.getIdOficial());
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjOfi.setIdOficial(rs.getInt("idOficial"));
                ObjOfi.setCedula(rs.getString("Cedula"));
                ObjOfi.setNombres(rs.getString("Apellidos"));
                ObjOfi.setApellidos(rs.getString("Nombres"));
                ObjOfi.setSucursal(rs.getInt("Sucursal"));

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
