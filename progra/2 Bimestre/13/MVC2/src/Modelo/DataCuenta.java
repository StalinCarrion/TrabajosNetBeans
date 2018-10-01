/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Cliente;
import Modelo.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author UTPL
 */
public class DataCuenta extends Conexion {
    
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
    
    public boolean BuscarCuentaB(Cuenta cuen) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cuenta WHERE Numero=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cuen.getNumero());
            rs = ps.executeQuery();
            if (rs.next()) {
                cuen.setNumero(rs.getString("Numero"));
                cuen.setTipo(Integer.parseInt(rs.getString("Tipo")));
                cuen.setSaldo(Double.parseDouble(rs.getString("Saldo")));
                cuen.setIdCuenta(Integer.parseInt(rs.getString("idCuenta")));
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
    
    public ArrayList<Cuenta> ClientesAutorizado(String NumCue){
        ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
//        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cuenta.* ,idCuentaAutorizada FROM cuentaautorizada, cliente, cuenta "
                    + "where cuentaautorizada.Cliente_idCliente = cliente.idCliente  "
                    + "and cuentaautorizada.Cuenta_idCuenta = cuenta.idCuenta and cliente.Cedula = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta ObjCuenta= new Cuenta();
                //CuentaAutorizada objCuentaAutorizada = new CuentaAutorizada();
                
                //objCuentaAutorizada.setIdCuentaAutorizada(rs.getInt("idCuentaAutorizada"));
                ObjCuenta.setNumero(rs.getString("Numero"));
                ObjCuenta.setTipo(rs.getInt("Tipo"));
                ObjCuenta.setSaldo(rs.getDouble("Saldo"));
                ObjCuenta.setIdOficial(rs.getInt("Oficial_idOficial"));
                ObjCuenta.setIdCuenta(rs.getInt("idCuenta"));
                ObjCuenta.setIdCuentaAutorizada(rs.getInt("idCuentaAutorizada"));
                ArrayCuentas.add(ObjCuenta);
            }
            return ArrayCuentas;
        } catch (Exception e) {
            System.err.println(e);
            return ArrayCuentas;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
    
    public ArrayList<Cuenta> ClientesCuenta(String NumCue){
        ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
//        Cliente ObjCli = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT cuenta.*, idCuenta FROM clientecuentas, cliente, cuenta "
                    + "where clientecuentas.Cliente_idCliente = cliente.idCliente  "
                    + "and clientecuentas.Cuenta_idCuenta = cuenta.idCuenta and cliente.Cedula = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NumCue);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta ObjCuenta= new Cuenta();
                ObjCuenta.setNumero(rs.getString("Numero"));
                ObjCuenta.setTipo(rs.getInt("Tipo"));
                ObjCuenta.setSaldo(rs.getDouble("Saldo"));
                ObjCuenta.setIdOficial(rs.getInt("Oficial_idOficial"));
                ObjCuenta.setIdCuenta(rs.getInt("idCuenta"));
                
                ArrayCuentas.add(ObjCuenta);
            }
            return ArrayCuentas;
        } catch (Exception e) {
            System.err.println(e);
            return ArrayCuentas;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
    
    
    

    public Cliente BuscarCliente(Cliente ObjAux) {
        Cliente ObjClie = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cliente WHERE Cedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjAux.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                ObjClie.setCedula(rs.getString("Cedula"));
                ObjClie.setApellidos(rs.getString("Apellidos"));
                ObjClie.setNombres(rs.getString("Saldo"));
      
            }
            return ObjClie;
        } catch (Exception e) {
            System.err.println(e);
            return ObjClie;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }

    public String Buscar_idCuenta(Cuenta ObjAux) {
        String AuxIdCuenta = "";
        Cuenta ObjCue = new Cuenta();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cuenta WHERE numero=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjAux.getNumero());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("si enonctró");
                ObjCue.setNumero(rs.getString("Numero"));
                ObjCue.setTipo(Integer.parseInt(rs.getString("Tipo")));
                ObjCue.setSaldo(Double.parseDouble(rs.getString("Saldo")));
                AuxIdCuenta = rs.getString("idCuenta");
            }
            return AuxIdCuenta;
        } catch (Exception e) {
            System.err.println(e);
            return AuxIdCuenta;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }

    public Cuenta ActualizarSaldo(Cuenta ObjAux) {
        Cuenta ObjCue = new Cuenta();
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE cuenta SET saldo = ? WHERE numero=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, ObjAux.getSaldo());
            ps.setString(2, ObjAux.getNumero());
            ps.executeUpdate();

            return ObjCue;
        } catch (Exception e) {
            System.err.println(e);
            return ObjCue;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }

    public boolean InsertarCuenta(Cuenta ObjCuenta) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO cuenta (Numero, Tipo, Saldo, Oficial_idOficial) "
                + "VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjCuenta.getNumero());
            ps.setInt(2, ObjCuenta.getTipo());
            ps.setDouble(3, ObjCuenta.getSaldo());
            ps.setInt(4, ObjCuenta.getIdOficial());
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
