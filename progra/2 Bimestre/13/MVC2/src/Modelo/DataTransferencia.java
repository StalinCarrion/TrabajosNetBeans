/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Cajero;
import Modelo.Transferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UTPL
 */
public class DataTransferencia extends Conexion {
    
    public boolean BuscarClienteB(Cliente clie) {   
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cliente WHERE Cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clie.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                clie.setCedula(rs.getString("Cedula"));
                clie.setNombres(rs.getString("Apellidos"));
                clie.setApellidos(rs.getString("Nombres"));
                clie.setDireccion(rs.getString("Direccion"));
                //ObjCli.setIdCliente(rs.getInt("idCliente"));
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
    
    public boolean InsertarTransferencia(Transferencia ObjtrTransferencia) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO transferencia (Numero, Fecha, Valor, Observacion, "
                + "CuentaAutorizada_idCuentaAutorizada, Cuenta_idCuenta) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ObjtrTransferencia.getNumero());
            ps.setDate(2, ObjtrTransferencia.getFecha());
            ps.setDouble(3, ObjtrTransferencia.getValor());
            ps.setString(4, ObjtrTransferencia.getObservacion());
            ps.setInt(5, ObjtrTransferencia.getIdCuentaAutorizada());
            ps.setInt(6, ObjtrTransferencia.getIdCuenta());
         
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
    
    public Transferencia BuscarIdTransferencia(){
        Transferencia ObjTra = new Transferencia();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT MAX(idTransferencia) AS idTransferencia FROM transferencia";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjTra.setNumero(rs.getInt("idTransferencia"));

            }
            return ObjTra;
        } catch (Exception e) {
            System.err.println(e);
            return ObjTra;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }

}
