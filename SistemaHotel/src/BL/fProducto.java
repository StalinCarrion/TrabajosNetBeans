package BL;

import DAT.vHabitacion;
import DAT.vProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fProducto {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Producto", "Descripcion", "Unidad de medida", "Precio de venta"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from producto where nombre like '%" + buscar + "%' order by idProducto desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("unidad_medida");
                registro[4] = rs.getString("precio_venta");

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

        sSQL = "select * from habitacion where piso like '%" + buscar + "%' and estado='Disponible' order by idhabitacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idhabitacion");
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
    public boolean insertar(vProducto dts) {
        sSQL = "insert into producto (nombre,descripcion,unidad_medida,precio_venta)"
                + "values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrNombre());
            pst.setString(2, dts.getStrDescripcion());
            pst.setString(3, dts.getStrUnidad_medida());
            pst.setDouble(4, dts.getDbPrecio_venta());
        
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
    public boolean editar(vProducto dts) {
        sSQL = "update producto set nombre=?,descripcion=?,unidad_medida=?,precio_venta=?"
                + " where idProducto=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrNombre());
            pst.setString(2, dts.getStrDescripcion());
            pst.setString(3, dts.getStrUnidad_medida());
            pst.setDouble(4, dts.getDbPrecio_venta());
            pst.setInt(5, dts.getIntIdProducto());

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
    public boolean eliminar(vProducto dts) {
        sSQL = "delete from producto where idProducto=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdProducto());

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
