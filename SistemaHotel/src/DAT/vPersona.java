
package DAT;

public class vPersona {
    private int intIdpersona;
    private String strNombre;
    private String strApaterno;
    private String strAmaterno;
    private String strTipo_documento;
    private String strNum_documento;
    private String strDireccion;
    private String strTelefono;
    private String strEmail;

    public vPersona() {
    }

    public vPersona(int intIdpersona, String strNombre, String strApaterno, String strAmaterno, String strTipo_documento, String strNum_documento, String strDireccion, String strTelefono, String strEmail) {
        this.intIdpersona = intIdpersona;
        this.strNombre = strNombre;
        this.strApaterno = strApaterno;
        this.strAmaterno = strAmaterno;
        this.strTipo_documento = strTipo_documento;
        this.strNum_documento = strNum_documento;
        this.strDireccion = strDireccion;
        this.strTelefono = strTelefono;
        this.strEmail = strEmail;
    }

    public int getIntIdpersona() {
        return intIdpersona;
    }

    public void setIntIdpersona(int intIdpersona) {
        this.intIdpersona = intIdpersona;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrApaterno() {
        return strApaterno;
    }

    public void setStrApaterno(String strApaterno) {
        this.strApaterno = strApaterno;
    }

    public String getStrAmaterno() {
        return strAmaterno;
    }

    public void setStrAmaterno(String strAmaterno) {
        this.strAmaterno = strAmaterno;
    }

    public String getStrTipo_documento() {
        return strTipo_documento;
    }

    public void setStrTipo_documento(String strTipo_documento) {
        this.strTipo_documento = strTipo_documento;
    }

    public String getStrNum_documento() {
        return strNum_documento;
    }

    public void setStrNum_documento(String strNum_documento) {
        this.strNum_documento = strNum_documento;
    }

    public String getStrDireccion() {
        return strDireccion;
    }

    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    public String getStrTelefono() {
        return strTelefono;
    }

    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }
    
    
    
}
