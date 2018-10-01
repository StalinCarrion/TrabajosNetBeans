package BL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author STALIN
 */
public class Conexion {

    public String db = "mydb";
    public String url = "jdbc:mysql://localhost:3307/" + db;
    public String user = "root";
    public String pass = "";

    public Conexion() {

    }

    public java.sql.Connection conectar() {
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }

        return link;
    }

}
