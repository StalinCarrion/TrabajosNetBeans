package BL;

import DAT.DRol_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fRol_Usuario {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Usuario", "Nombre Usuario", "Apellido", "Login", "Password", "ID Rol", "Nombre Rol", "Descripcion"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select u.us_id,u.us_nombre,u.us_apellido,"
                + "u.us_login,u.us_password,r.rol_id,r.rol_nombre,r.rol_descripcion"
                + " from usuario u, rol r, rol_usuario ru where us_nombre like '%" + buscar + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("us_id");
                registro[1] = rs.getString("us_nombre");
                registro[2] = rs.getString("us_apellido");
                registro[3] = rs.getString("us_login");
                registro[4] = rs.getString("us_password");
                registro[5] = rs.getString("rol_id");
                registro[6] = rs.getString("rol_nombre");
                registro[7] = rs.getString("rol_descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarRU(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Usuario", "Nombre Usuario", "Apellido", "Login", "Password", "ID Rol", "Nombre Rol", "Descripcion"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select u.us_id,u.us_nombre,u.us_apellido,"
                + "u.us_login,u.us_password,r.rol_id,r.rol_nombre,r.rol_descripcion"
                + " from usuario u, rol r, rol_usuario ru where u.us_nombre like '%" + buscar + "%' and ru.rol_id=r.rol_id and ru.us_id = u.us_id";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("us_id");
                registro[1] = rs.getString("us_nombre");
                registro[2] = rs.getString("us_apellido");
                registro[3] = rs.getString("us_login");
                registro[4] = rs.getString("us_password");
                registro[5] = rs.getString("rol_id");
                registro[6] = rs.getString("rol_nombre");
                registro[7] = rs.getString("rol_descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    

    public boolean insertar(DRol_Usuario dts) {
        sSQL = "insert into rol_usuario (us_id,rol_id)"
                + "values (?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntUs_id());
            pst.setInt(2, dts.getIntRol_id());

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

    public boolean editar(DRol_Usuario dts) {
        sSQL = "update rol_usuario set us_id=?,rol_id=?"
                + " where rol_id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntUs_id());
            pst.setInt(2, dts.getIntRol_id());
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

    public boolean eliminar(DRol_Usuario dts) {
        sSQL = "delete from rol_usuario where rol_id=?";

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
