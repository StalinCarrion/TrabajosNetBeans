
package DAT;

/**
 *
 * @author STALIN
 */
public class DUsuario {
    private int intUs_id;
    private String strUs_nombre;
    private String strUs_apellido;
    private String strLogin_us;
    private String strUs_password;

    public DUsuario() {
    }

    public DUsuario(int intUs_id, String strUs_nombre, String strUs_apellido, String strLogin_us, String strUs_password) {
        this.intUs_id = intUs_id;
        this.strUs_nombre = strUs_nombre;
        this.strUs_apellido = strUs_apellido;
        this.strLogin_us = strLogin_us;
        this.strUs_password = strUs_password;
    }

    public int getIntUs_id() {
        return intUs_id;
    }

    public void setIntUs_id(int intUs_id) {
        this.intUs_id = intUs_id;
    }

    public String getStrUs_nombre() {
        return strUs_nombre;
    }

    public void setStrUs_nombre(String strUs_nombre) {
        this.strUs_nombre = strUs_nombre;
    }

    public String getStrUs_apellido() {
        return strUs_apellido;
    }

    public void setStrUs_apellido(String strUs_apellido) {
        this.strUs_apellido = strUs_apellido;
    }

    public String getStrLogin_us() {
        return strLogin_us;
    }

    public void setStrLogin_us(String strLogin_us) {
        this.strLogin_us = strLogin_us;
    }

    public String getStrUs_password() {
        return strUs_password;
    }

    public void setStrUs_password(String strUs_password) {
        this.strUs_password = strUs_password;
    }
    
    
}
