package DAT;

/**
 *
 * @author STALIN
 */
public class vTrabajador extends vPersona {

    Double dbSueldo;
    String strAcceso;
    String strLogin;
    String strPassword;
    String strEstado;

    public vTrabajador() {
    }

    public vTrabajador(Double dbSueldo, String strAcceso, String strLogin, String strPassword, String strEstado) {
        this.dbSueldo = dbSueldo;
        this.strAcceso = strAcceso;
        this.strLogin = strLogin;
        this.strPassword = strPassword;
        this.strEstado = strEstado;
    }

    public Double getDbSueldo() {
        return dbSueldo;
    }

    public void setDbSueldo(Double dbSueldo) {
        this.dbSueldo = dbSueldo;
    }

    public String getStrAcceso() {
        return strAcceso;
    }

    public void setStrAcceso(String strAcceso) {
        this.strAcceso = strAcceso;
    }

    public String getStrLogin() {
        return strLogin;
    }

    public void setStrLogin(String strLogin) {
        this.strLogin = strLogin;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }
    
}
