package BL;

import DAT.vTrabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fTrabajador {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno",
            "Amaterno", "Doc", "Número Documento", "Dirección",
            "Teléfono", "Email", "Sueldo", "acceso", "Login", "Clave", "Estado"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idPersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,"
                + "p.direccion,p.telefono,p.email,t.sueldo,t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t "
                + "on p.idPersona=t.idPersona where num_documento like '%"
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
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");

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
    public boolean insertar(vTrabajador dts) {
        sSQL = "insert into persona (nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into trabajador (idPersona,sueldo,acceso,login,password,estado)"
                + "values ((select idPersona from persona order by idPersona desc limit 1),?,?,?,?,?)";
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

            pst2.setDouble(1, dts.getDbSueldo());
            pst2.setString(2, dts.getStrAcceso());
            pst2.setString(3, dts.getStrLogin());
            pst2.setString(4, dts.getStrPassword());
            pst2.setString(5, dts.getStrEstado());

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
    public boolean editar(vTrabajador dts) {
        sSQL = "update persona set nombre=?,apaterno=?,amaterno=?,tipo_documento=?,num_documento=?,"
                + " direccion=?,telefono=?,email=? where idPersona=?";

        sSQL2 = "update trabajador set sueldo=?,acceso=?,login=?,password=?,estado=?"
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

            pst2.setDouble(1, dts.getDbSueldo());
            pst2.setString(2, dts.getStrAcceso());
            pst2.setString(3, dts.getStrLogin());
            pst2.setString(4, dts.getStrPassword());
            pst2.setString(5, dts.getStrEstado());
            pst2.setInt(6, dts.getIntIdpersona());

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
    public boolean eliminar(vTrabajador dts) {
        sSQL = "delete from trabajador where idPersona=?";
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
    //Para poder logeart
    public DefaultTableModel login(String login,String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno","Acceso","Login","Clave","Estado"};


        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idPersona,p.nombre,p.apaterno,p.amaterno,"
                + "t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t "
                + "on p.idPersona=t.idPersona where t.login='"
                + login + "' and t.password='" + password + "' and t.estado='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idPersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                
              
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
