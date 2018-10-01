/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Clases.item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FRANZ
 */
public class DataItem extends Conexion{
     public ArrayList<item> BuscarItems() {
        ArrayList<item> ArrayItems = new ArrayList<item>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select codigo, descripcion, p_vent, p_comp, cant, fecha from taller03.item";        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                item ObjItem = new item();
                ObjItem.setCodigo(rs.getString("codigo"));
                ObjItem.setDescripcion(rs.getString("descripcion"));
                ObjItem.setP_vent(rs.getDouble("p_vent"));
                ObjItem.setP_comp(rs.getDouble("p_comp"));                
                ObjItem.setCant(rs.getInt("cant"));
                ObjItem.setFecha(rs.getDate("fecha"));
                ArrayItems.add(ObjItem);
            }
            return ArrayItems;
        } catch (Exception e) {
            System.err.println(e);
            return ArrayItems;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }
     private Connection conn =getConexion();

    public Object[][] Select_Item() {
        int registros = 0;
        String consulta = "select iditem, codigo, descripcion, p_vent, p_comp, cant, fecha from taller03.item";
        String consulta2 = "Select count(*) as total from item ";
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = conn.prepareStatement(consulta2);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][7];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conn.prepareStatement(consulta);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("iditem");
                data[i][1] = res.getString("codigo");
                data[i][2] = res.getString("descripcion");
                data[i][3] = res.getString("p_vent");
                data[i][4] = res.getString("p_comp");
                data[i][5] = res.getString("cant");
                data[i][6] = res.getString("fecha");
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public boolean update(String valores, String id) {
        boolean res = false;
        String q = " UPDATE item SET " + valores + " WHERE iditem = " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }
    public void EliminarItem(int cod){
        String q = "DELETE FROM `taller03`.`item` WHERE `codigo`= " + cod;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
