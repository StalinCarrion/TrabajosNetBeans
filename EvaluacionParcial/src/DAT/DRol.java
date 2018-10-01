
package DAT;

public class DRol {
    private int intRol_id;
    private String strRol_nombre;
    private String strRol_descripcion;

    public DRol() {
    }

    public DRol(int intRol_id, String strRol_nombre, String strRol_descripcion) {
        this.intRol_id = intRol_id;
        this.strRol_nombre = strRol_nombre;
        this.strRol_descripcion = strRol_descripcion;
    }

    public int getIntRol_id() {
        return intRol_id;
    }

    public void setIntRol_id(int intRol_id) {
        this.intRol_id = intRol_id;
    }

    public String getStrRol_nombre() {
        return strRol_nombre;
    }

    public void setStrRol_nombre(String strRol_nombre) {
        this.strRol_nombre = strRol_nombre;
    }

    public String getStrRol_descripcion() {
        return strRol_descripcion;
    }

    public void setStrRol_descripcion(String strRol_descripcion) {
        this.strRol_descripcion = strRol_descripcion;
    }
    
    
    
}
