package DAT;

/**
 *
 * @author STALIN
 */
public class DRol_Usuario {

    private int intUs_id;
    private int intRol_id;

    public DRol_Usuario() {
    }

    public DRol_Usuario(int intUs_id, int intRol_id) {
        this.intUs_id = intUs_id;
        this.intRol_id = intRol_id;

    }

    public int getIntUs_id() {
        return intUs_id;
    }

    public void setIntUs_id(int intUs_id) {
        this.intUs_id = intUs_id;
    }

    public int getIntRol_id() {
        return intRol_id;
    }

    public void setIntRol_id(int intRol_id) {
        this.intRol_id = intRol_id;
    }

}
