/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.Cajero;
import Clases.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UTPL
 */
public class DataCuenta extends Conexion {

    Conexion cone = new Conexion();

    public Cuenta BuscarCuenta(Cuenta ObjAux) {
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
                System.out.println("si enonctrò");
                ObjCue.setNumero(rs.getString("Numero"));
                ObjCue.setTipo(Integer.parseInt(rs.getString("Tipo")));
                ObjCue.setSaldo(Double.parseDouble(rs.getString("Saldo")));
            }
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

//    public Cuenta Modificar(String nuevoSaldo, String NCuenta) {
//
//        Cuenta ObjCue = new Cuenta();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = getConexion();
//        //UPDATE `taller03`.`cuenta` SET `Saldo`= Saldo+10 WHERE `Numero`='2101';
//        String sql = "UPDATE cuenta SET Saldo=" + "Saldo+" + nuevoSaldo + "WHERE Numero=" + "'" + NCuenta + "'";
//
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ObjAux.getNumero());
//            ps.setS
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                System.out.println("si enonctrò");
//                ObjCue.setNumero(rs.getString("Numero"));
//                ObjCue.setTipo(Integer.parseInt(rs.getString("Tipo")));
//                ObjCue.setSaldo(Double.parseDouble(rs.getString("Saldo")));
//            }
//            return ObjCue;
//        } catch (Exception e) {
//            System.err.println(e);
//            return ObjCue;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.err.println(3);
//            }
//        }
//    }

    public int Modificar(String nuevoSaldo, String NCuenta) throws ClassNotFoundException, SQLException {
        int Retorno=0;
        //PreparedStatement ps = null;
        //ResultSet rs = null;
        //Connection con = getConexion();
        Statement st = cone.AbrirConexion().createStatement();
        String sentencia = "UPDATE cuenta SET Saldo=" +"'"+nuevoSaldo+"'"+"WHERE Numero=" + "'" + NCuenta + "'";
        
        Retorno = st.executeUpdate(sentencia);
        System.out.println("que ay aqui "+ Retorno);
        cone.CerrarConexion();
        return Retorno;
    }
    
//    public int Modificar(String nuevoSaldo, String NCuenta) throws ClassNotFoundException, SQLException {
//        int Retorno=0;
//        //PreparedStatement ps = null;
//        //ResultSet rs = null;
//        //Connection con = getConexion();
//        Statement st = cone.AbrirConexion().createStatement();
//        String sentencia = "UPDATE cuenta SET Saldo=" +"("+ "Saldo+"+nuevoSaldo+")"+"WHERE Numero=" + "'" + NCuenta + "'";
//        
//        Retorno = st.executeUpdate(sentencia);
//        System.out.println("que ay aqui "+ Retorno);
//        cone.CerrarConexion();
//        return Retorno;
//    }
}
