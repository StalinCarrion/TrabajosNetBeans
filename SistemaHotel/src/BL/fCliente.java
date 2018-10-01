
package BL;

import DAT.vCliente;
import DAT.vProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fCliente {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Númeo Documento", "Dirección", "Teléfono", "Email", "Código"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idPersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,"
                + "p.direccion,p.telefono,p.email,c.codigo_cliente from persona p inner join cliente c "
                + "on p.idPersona=c.idPersona where num_documento like '%"
                + buscar + "%' order by idPersona desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idPersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigo_cliente");

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
    public boolean insertar(vCliente dts) {
        sSQL = "insert into persona (nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into cliente (idPersona,codigo_cliente)"
                + "values ((select idPersona from persona order by idPersona desc limit 1),?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getStrNombre());
            pst.setString(2, dts.getStrApaterno());
            pst.setString(3, dts.getStrAmaterno());
            pst.setString(4, dts.getStrTipo_documento());
            pst.setString(5, dts.getStrNum_documento());
            pst.setString(6, dts.getStrDireccion());
            pst.setString(7, dts.getStrTelefono());
            pst.setString(8, dts.getStrEmail());

            pst2.setString(1, dts.getStrCodigo_cliente());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    //PAra poder editar datos
    public boolean editar(vCliente dts) {
        sSQL = "update persona set nombre=?,apaterno=?,amaterno=?,tipo_documento=?,num_documento=?,"
                + " direccion=?,telefono=?,email=? where idPersona=?";
        
        sSQL2 = "update cliente set codigo_cliente=?"
                + " where idPersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getStrNombre());
            pst.setString(2, dts.getStrApaterno());
            pst.setString(3, dts.getStrAmaterno());
            pst.setString(4, dts.getStrTipo_documento());
            pst.setString(5, dts.getStrNum_documento());
            pst.setString(6, dts.getStrDireccion());
            pst.setString(7, dts.getStrTelefono());
            pst.setString(8, dts.getStrEmail());
            pst.setInt(9, dts.getIntIdpersona());

            pst2.setString(1, dts.getStrCodigo_cliente());
            pst2.setInt(2, dts.getIntIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    //para poder eliminar registros
    public boolean eliminar(vCliente dts) {
        sSQL = "delete from cliente where idPersona=?";
        sSQL2 = "delete from persona where idPersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIntIdpersona());

            
            pst2.setInt(1, dts.getIntIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}
