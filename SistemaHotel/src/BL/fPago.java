package BL;


import DAT.vPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPago {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IdReserva", "Comprobante", "Número", "Igv", "Total", "Fecha Emisión", "Fecha Pago"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from pago where idReserva=" + buscar + " order by idPago desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idPago");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("tipo_comprobante");
                registro[3] = rs.getString("num_comprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("total_pago");
                registro[6] = rs.getString("fecha_emision");
                registro[7] = rs.getString("fecha_pago");

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
    public boolean insertar(vPago dts) {
        sSQL = "insert into pago (idReserva,tipo_comprobante,num_comprobante,igv,total_pago,fecha_emision,fecha_pago)"
                + "values (?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdreserva());
            pst.setString(2, dts.getStrTipo_comprobante());
            pst.setString(3, dts.getStrNum_comprobante());
            pst.setDouble(4, dts.getDbIgv());
            pst.setDouble(5, dts.getDbTotal_pago());
            pst.setDate(6, dts.getDateFecha_emision());
            pst.setDate(7, dts.getDateFecha_pago());

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
    public boolean editar(vPago dts) {
        sSQL = "update pago set idReserva=?,tipo_comprobante=?,num_comprobante=?,igv=?,total_pago=?,fecha_emision=?,fecha_pago=?"
                + " where idPago=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdreserva());
            pst.setString(2, dts.getStrTipo_comprobante());
            pst.setString(3, dts.getStrNum_comprobante());
            pst.setDouble(4, dts.getDbIgv());
            pst.setDouble(5, dts.getDbTotal_pago());
            pst.setDate(6, dts.getDateFecha_emision());
            pst.setDate(7, dts.getDateFecha_pago());
            pst.setInt(8, dts.getIntIdpago());

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
    public boolean eliminar(vPago dts) {
        sSQL = "delete from pago where idPago=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdpago());

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
