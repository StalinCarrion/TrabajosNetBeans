package BL;

import DAT.DFuncionalidad;
import DAT.DRol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fFuncionalidad {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Descripcion"};

        String[] registro = new String[3];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from funcionalidad where fun_nombre like '%" + buscar + "%' order by fun_id desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("fun_id");
                registro[1] = rs.getString("fun_nombre");
                registro[2] = rs.getString("fun_descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(DFuncionalidad dts) {
        sSQL = "insert into funcionalidad (fun_nombre,fun_descripcion)"
                + "values (?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrFun_nombre());
            pst.setString(2, dts.getStrFun_descripcion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(DFuncionalidad dts) {
        sSQL = "update funcionalidad set fun_nombre=?,fun_descripcion=?"
                + " where fun_id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrFun_nombre());
            pst.setString(2, dts.getStrFun_descripcion());
            pst.setInt(3, dts.getIntFun_id());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar (DFuncionalidad dts){
       sSQL="delete from funcionalidad where fun_id=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIntFun_id());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }

}
