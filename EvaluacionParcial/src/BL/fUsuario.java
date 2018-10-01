package BL;

import DAT.DUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fUsuario {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellido", "Login", "Password"};
        String sentencia = "Select count(*) total from usuarios where identificacion = ";

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from usuario where us_nombre like '%" + buscar + "%' order by us_id";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("us_id");
                registro[1] = rs.getString("us_nombre");
                registro[2] = rs.getString("us_apellido");
                registro[3] = rs.getString("us_login");
                registro[4] = rs.getString("us_password");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(DUsuario dts) {
        sSQL = "insert into usuario (us_nombre,us_apellido,us_login,us_password)"
                + "values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrUs_nombre());
            pst.setString(2, dts.getStrUs_apellido());
            pst.setString(3, dts.getStrLogin_us());
            pst.setString(4, dts.getStrUs_password());

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

    //--------------------
    public ResultSet Consultar(int id) throws ClassNotFoundException, SQLException {
        Statement st = cn.createStatement();
        String sentencia = "Select * from usuario where  id = " + "'" + id + "'";
        ResultSet rs = st.executeQuery(sentencia);

        return rs;

    }
    //---------------------

    public boolean editar(DUsuario dts) {
        sSQL = "update usuario set us_nombre=?,us_apellido=?,us_login=?,us_password=?"
                + " where us_id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getStrUs_nombre());
            pst.setString(2, dts.getStrUs_apellido());
            pst.setString(3, dts.getStrLogin_us());
            pst.setString(4, dts.getStrUs_password());
            pst.setInt(5, dts.getIntUs_id());

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

    public boolean eliminar(DUsuario dts) {
        sSQL = "delete from usuario where us_id=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIntUs_id());

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

    public DefaultTableModel login(String login) {
        DefaultTableModel modelo;

        String[] titulos = {"IDUsuario", "NombreUsuario", "Login", "Pass", "nombreROL", "Nombre Funcionalidad"};

        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select u.us_id,u.us_nombre,u.us_login,"
                + "u.us_password,r.rol_nombre,f.fun_nombre"
                + " from usuario u, rol r, funcionalidad f,rol_usuario ru,rol_funcionalidad rf where u.us_login='" + login + "' and "
                + "r.rol_id = ru.rol_id and ru.us_id = u.us_id and rf.rol_id = r.rol_id and rf.fun_id = f.fun_id";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("us_id");
                registro[1] = rs.getString("us_nombre");
                registro[2] = rs.getString("us_login");
                registro[3] = rs.getString("us_password");
                registro[4] = rs.getString("rol_nombre");
                registro[5] = rs.getString("fun_nombre");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public String desencriptar(String texto, String clave) {
        int tamtext = texto.length();
        int tamclav = clave.length();
        int temp, p = 0;
        String desencriptado = "";
        /* Se crea un array de enteros que contendran los numeros que
       corresponde a los caracteres en Ascii de los String Texto y la Clave */

        int textoAscii[] = new int[tamtext];
        int claveAscii[] = new int[tamclav];

        /* Se guardan los caracteres de cada String en
       numeros correspondientes al Ascii           */
        for (int i = 0; i < tamtext; i++) {
            textoAscii[i] = texto.charAt(i);
        }

        for (int i = 0; i < tamclav; i++) {
            claveAscii[i] = clave.charAt(i);
        }

        //Se procede al DESENCRIPTADO
        for (int i = 0; i < tamtext; i++) {
            p++;

            if (p >= tamclav) {
                p = 0;
            }

            temp = textoAscii[i] - claveAscii[p];

            if (temp < 0) {
                temp = temp + 256;
            }

            desencriptado = desencriptado + (char) temp;
        }
        return desencriptado;
    }

    //ESto va en la capa DAT
    public int consultarExistencia(String strIdentificacion throws ClassNotFoundException 
        ){
        int retorno = 0;

        Statement st = cn.createStatement();
        String sentencia = "Select count(*) total from usuarios where identificacion";
        //ResultSet rs = st.executeUpdate(sentencia);
        retorno = st.executeUpdate(sentencia);
        return retorno;

    }

}
