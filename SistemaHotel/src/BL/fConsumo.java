package BL;

import DAT.vConsumo;
import DAT.vHabitacion;
import DAT.vProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fConsumo {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalconsumo;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "idreserva", "idproducto", "producto", "cantidad", "Precio Venta", "Estado"};

        String[] registro = new String[7];

        totalregistros = 0;
        totalconsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select c.idConsumo,c.idReserva,c.idProducto,p.nombre,c.cantidad,c.precio_venta "
                + ",c.estado from consumo c inner join producto p on c.idProducto=p.idProducto"
                + " where c.idReserva =" + buscar + " order by c.idConsumo desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idConsumo");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("idProducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getDouble("cantidad") * rs.getDouble("precio_venta"));

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    //para poder insertar campos
    public boolean insertar(vConsumo dts) {
        sSQL = "insert into consumo (idReserva,idProducto,cantidad,precio_venta,estado)"
                + "values (?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdreserva());
            pst.setInt(2, dts.getIntIdproducto());
            pst.setDouble(3, dts.getDbCantidad());
            pst.setDouble(4, dts.getDbPrecio_venta());
            pst.setString(5, dts.getStrEstado());

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
    public boolean editar(vConsumo dts) {
        sSQL = "update consumo set idReserva=?,idProducto=?,cantidad=?,precio_venta=?,estado=?"
                + " where idConsumo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdreserva());
            pst.setInt(2, dts.getIntIdproducto());
            pst.setDouble(3, dts.getDbCantidad());
            pst.setDouble(4, dts.getDbPrecio_venta());
            pst.setString(5, dts.getStrEstado());

            pst.setInt(6, dts.getIntIdconsumo());

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
    public boolean eliminar(vConsumo dts) {
        sSQL = "delete from consumo where idConsumo=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdconsumo());

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
