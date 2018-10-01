package BL;

import DAT.vHabitacion;
import DAT.vProducto;
import DAT.vReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fReserva {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Idhabitacion", "Numero", "idcliente", "Cliente",
            "idtrabajador", "Trabajador", "Tipo Reserva", "Fecha Reserva",
            "Fecha Ingreso", "Fecha Salida", "Costo", "Estado"};

        String[] registro = new String[13];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select r.idReserva,r.idHabitacion,h.numero,r.idCliente,"
                + "(select nombre from persona where idPersona=r.idCliente)as clienten,"
                + "(select apaterno from persona where idPersona=r.idCliente)as clienteap,"
                + "r.idTrabajador,(select nombre from persona where idPersona=r.idTrabajador)as trabajadorn,"
                + "(select apaterno from persona where idPersona=r.idTrabajador)as trabajadorap,"
                + "r.tipo_reserva,r.fecha_reserva,r.fec"
                + "ha_ingresa,r.fecha_salida,"
                + "r.costo_alojamiento,r.estado from reserva r inner join habitacion h on r.idHabitacion=h.idHabitacion where r.fecha_reserva like '%" + buscar + "%' order by idReserva desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("idHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idCliente");
                registro[4] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[5] = rs.getString("idTrabajador");
                registro[6] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[7] = rs.getString("tipo_reserva");
                registro[8] = rs.getString("fecha_reserva");
                registro[9] = rs.getString("fecha_ingresa");
                registro[10] = rs.getString("fecha_salida");
                registro[11] = rs.getString("costo_alojamiento");
                registro[12] = rs.getString("estado");

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
    public boolean insertar(vReserva dts) {
        sSQL = "insert into reserva (idHabitacion,idCliente,idTrabajador,tipo_reserva,fecha_reserva,fecha_ingresa,fecha_salida,costo_alojamiento,estado)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdHabitacion());
            pst.setInt(2, dts.getIntIdCliente());
            pst.setInt(3, dts.getIntIdTrabajador());
            pst.setString(4, dts.getStrTipo_reserva());
            pst.setDate(5, dts.getDateFecha_reserva());
            pst.setDate(6, dts.getDateFecha_ingresa());
            pst.setDate(7, dts.getDateFecha_salida());
            pst.setDouble(8, dts.getDbCosto_alojamiento());
            pst.setString(9, dts.getStrEstado());

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
    public boolean editar(vReserva dts) {
        sSQL = "update reserva set idHabitacion=?,idCliente=?,"
                + "idTrabajador=?,tipo_reserva=?,fecha_reserva=?,"
                + "fecha_ingresa=?,fecha_salida=?,costo_alojamiento=?,estado=?"
                + " where idReserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIntIdHabitacion());
            pst.setInt(2, dts.getIntIdCliente());
            pst.setInt(3, dts.getIntIdTrabajador());
            pst.setString(4, dts.getStrTipo_reserva());
            pst.setDate(5, dts.getDateFecha_reserva());
            pst.setDate(6, dts.getDateFecha_ingresa());
            pst.setDate(7, dts.getDateFecha_salida());
            pst.setDouble(8, dts.getDbCosto_alojamiento());
            pst.setString(9, dts.getStrEstado());

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

    public boolean pagar(vReserva dts) {
        sSQL = "update reserva set estado='Pagada'"
                + " where idReserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdReserva());

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
    public boolean eliminar(vReserva dts) {
        sSQL = "delete from reserva where idReserva=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntIdReserva());

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
