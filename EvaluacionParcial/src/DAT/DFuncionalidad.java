
package DAT;

public class DFuncionalidad {
    private int intFun_id;
    private String strFun_nombre;
    private String strFun_descripcion;

    public DFuncionalidad() {
    }

    public DFuncionalidad(int intFun_id, String strFun_nombre, String strFun_descripcion) {
        this.intFun_id = intFun_id;
        this.strFun_nombre = strFun_nombre;
        this.strFun_descripcion = strFun_descripcion;
    }

    public int getIntFun_id() {
        return intFun_id;
    }

    public void setIntFun_id(int intFun_id) {
        this.intFun_id = intFun_id;
    }

    public String getStrFun_nombre() {
        return strFun_nombre;
    }

    public void setStrFun_nombre(String strFun_nombre) {
        this.strFun_nombre = strFun_nombre;
    }

    public String getStrFun_descripcion() {
        return strFun_descripcion;
    }

    public void setStrFun_descripcion(String strFun_descripcion) {
        this.strFun_descripcion = strFun_descripcion;
    }
    
    
    
}
