package BL;

import DAT.DFuncionalidad_Rol;
import DAT.DRol_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fRol_Funcionalidad {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Rol_id", "Rol_nombre", "Rol_descripcion", "Fun_id", "Fun_nombre", "Fun_descripcion"};

        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select DISTINCT r.rol_id,r.rol_nombre,r.rol_descripcion,f.fun_id,"
                + "f.fun_nombre,f.fun_descripcion "
                + "from funcionalidad f, rol r, rol_funcionalidad rf where rol_nombre like '%" + buscar + "%' order by rol_id";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("rol_id");
                registro[1] = rs.getString("rol_nombre");
                registro[2] = rs.getString("rol_descripcion");
                registro[3] = rs.getString("fun_id");
                registro[4] = rs.getString("fun_nombre");
                registro[5] = rs.getString("fun_descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarRF(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Rol_id", "Rol_nombre", "Rol_descripcion", "Fun_id", "Fun_nombre", "Fun_descripcion"};

        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select r.rol_id,r.rol_nombre,r.rol_descripcion,f.fun_id,"
                + "f.fun_nombre,f.fun_descripcion "
                + "from funcionalidad f, rol r, rol_funcionalidad rf where rf.fun_id like '%" + buscar + "%' and rf.rol_id = r.rol_id and rf.fun_id =f.fun_id ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("rol_id");
                registro[1] = rs.getString("rol_nombre");
                registro[2] = rs.getString("rol_descripcion");
                registro[3] = rs.getString("fun_id");
                registro[4] = rs.getString("fun_nombre");
                registro[5] = rs.getString("fun_descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarRUAdministrador(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Descripcion"};

        String[] registro = new String[3];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from funcionalidad where fun_nombre like '%" + buscar + "order by fun_id desc";

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

    public boolean insertar(DFuncionalidad_Rol dts) {
        sSQL = "insert into rol_funcionalidad (rol_id,fun_id)"
                + "values (?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntRol_id());
            pst.setInt(2, dts.getIntFun_id());

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

    public boolean editar(DFuncionalidad_Rol dts) {
        sSQL = "update rol_funcionalidad set rol_id=?,fun_id=?"
                + " where rol_id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntRol_id());
            pst.setInt(2, dts.getIntFun_id());

            pst.setInt(3, dts.getIntRol_id());

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

    public boolean eliminar(DFuncionalidad_Rol dts) {
        sSQL = "delete from rol_funcionalidad where rol_id=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntRol_id());

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

}
