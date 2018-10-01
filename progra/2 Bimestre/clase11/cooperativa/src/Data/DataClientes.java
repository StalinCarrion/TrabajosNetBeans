/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Cajero;
import Clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author UTPL
 */
public class DataClientes extends Conexion {
    public ArrayList<Cliente> ClientesCuenta(String NumCue){
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cliente.* FROM clientecuentas, cliente, cuenta "
                    + "where clientecuentas.idclie = cliente.idclie  "
                    + "and clientecuentas.idcuen = cuenta.idcuen and cuenta.numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            while (rs.next()) {
                ObjCli.setCedula(rs.getString("Cedula"));
                ObjCli.setNombres(rs.getString("Apellidos"));
                ObjCli.setApellidos(rs.getString("Nombres"));
                ObjCli.setDireccion(rs.getString("Direccion")); 
                ArrayClientes.add(ObjCli);
            }
            return ArrayClientes;
        } catch (Exception e) {
            System.err.println(e);
            return ArrayClientes;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
    
    public Cliente ClientesCuentaAutorizado(String NumCue){
        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cliente.* FROM clientecuentas, cliente, cuenta "
                    + "where clientecuentas.idclie = cliente.idclie  "
                    + "and clientecuentas.idcuen = cuenta.idcuen "
                    + "and clientecuentas.autorizado = 1 "
                    + "and cuenta.numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjCli.setCedula(rs.getString("Cedula"));
                ObjCli.setNombres(rs.getString("Apellidos"));
                ObjCli.setApellidos(rs.getString("Nombres"));
                ObjCli.setDireccion(rs.getString("Direccion")); 
                
            }
            return ObjCli;
        } catch (Exception e) {
            System.err.println(e);
            return ObjCli;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
}
