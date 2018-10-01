/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Cliente;
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

    public ArrayList<Cliente> ClientesCuenta(String NumCue) {
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
//        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cliente.* FROM clientecuentas, cliente, cuenta "
                + "where clientecuentas.Cliente_idCliente = cliente.idCliente  "
                + "and clientecuentas.Cuenta_idCuenta = cuenta.idCuenta and cuenta.numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente ObjCli = new Cliente();
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

    public Cliente ClientesCuentaAutorizado(String NumCue) {
        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cliente.* FROM clientecuentas, cliente, cuenta "
                + "where clientecuentas.Cliente_idCliente = cliente.idCliente  "
                + "and clientecuentas.Cuenta_idCuenta = cuenta.idCuenta "
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

    public Cliente BuscarCliente(Cliente ObjAux) {

        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cliente WHERE Cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjAux.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjCli.setCedula(rs.getString("Cedula"));
                ObjCli.setNombres(rs.getString("Apellidos"));
                ObjCli.setApellidos(rs.getString("Nombres"));
                ObjCli.setDireccion(rs.getString("Direccion"));
                ObjCli.setIdCliente(rs.getInt("idCliente"));

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

    public boolean InsertarCliente(Cliente ObjCli) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO cliente (cedula, Apellidos, Nombres, Direccion) "
                + "VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjCli.getCedula());
            ps.setString(3, ObjCli.getNombres());
            ps.setString(2, ObjCli.getApellidos());
            ps.setString(4, ObjCli.getDireccion());
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
    
     public ArrayList<Cliente> ClientesCuentaCliente(String NumCue) {
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
//        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT clientecuentas.*,cliente.* FROM clientecuentas, cliente, cuenta "
                + "where clientecuentas.Cliente_idCliente = cliente.idCliente "
                + "and clientecuentas.Cuenta_idCuenta = cuenta.idCuenta and cuenta.numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteCuenta ObjCueCli = new ClienteCuenta();
                Cliente ObjCli = new Cliente();
                ObjCli.setCedula(rs.getString("Cedula"));
                ObjCli.setNombres(rs.getString("Nombres"));
                ObjCli.setApellidos(rs.getString("Apellidos"));
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
}
