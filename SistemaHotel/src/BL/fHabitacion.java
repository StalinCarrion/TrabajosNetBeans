package BL;

import DAT.vHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fHabitacion {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Número", "Piso", "Descripción", "Caracteristicas", "Precio", "Estado", "Tipo habitación"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from habitacion where piso like '%" + buscar + "%' order by idHabitacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_habitacion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    //PAra mostrar la vista
    public DefaultTableModel mostrarvista(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Número", "Piso", "Descripción", "Caracteristicas", "Precio", "Estado", "Tipo habitación"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from habitacion where piso like '%" + buscar + "%' and estado='Disponible' order by idHabitacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_habitacion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    //para poder insertar campos
    public boolean insertar(vHabitacion dts) {
        sSQL = "insert into habitacion (numero,piso,descripcion,caracteristicas,precio_diario,estado,tipo_habitacion)"
                + "values (?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrNumero());
            pst.setString(2, dts.getStrPiso());
            pst.setString(3, dts.getStrDescripcion());
            pst.setString(4, dts.getStrCaracteristicas());
            pst.setDouble(5, dts.getDbPrecio_diario());
            pst.setString(6, dts.getStrEstado());
            pst.setString(7, dts.getStrTipo_habitacion());
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

    //PAra poder editar datos
    public boolean editar(vHabitacion dts) {
        sSQL = "update habitacion set numero=?,piso=?,descripcion=?,caracteristicas=?,precio_diario=?,estado=?,tipo_habitacion=?"
                + " where idHabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrNumero());
            pst.setString(2, dts.getStrPiso());
            pst.setString(3, dts.getStrDescripcion());
            pst.setString(4, dts.getStrCaracteristicas());
            pst.setDouble(5, dts.getDbPrecio_diario());
            pst.setString(6, dts.getStrEstado());
            pst.setString(7, dts.getStrTipo_habitacion());
            pst.setInt(8, dts.getIntIdHabitacion());

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

    //para poder eliminar registros
    public boolean eliminar(vHabitacion dts) {
        sSQL = "delete from habitacion where idHabitacion=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdHabitacion());

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

    public boolean desocupar(vHabitacion dts) {
        sSQL = "update habitacion set estado='Disponible'"
                + " where idHabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdHabitacion());
          

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
    
    public boolean ocupar(vHabitacion dts) {
        sSQL = "update habitacion set estado='Ocupado'"
                + " where idHabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdHabitacion());
          

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
