package DAT;

/**
 *
 * @author STALIN
 */
public class vHabitacion {

    private int intIdHabitacion;
    private String strNumero;
    private String strPiso;
    private String strDescripcion;
    private String strCaracteristicas;
    private Double dbPrecio_diario;
    private String strEstado;
    private String strTipo_habitacion;

    public vHabitacion(int intIdHabitacion, String strNumero, String strPiso, String strDescripcion, String strCaracteristicas, Double dbPrecio_diario, String strEstado, String strTipo_habitacion) {
        this.intIdHabitacion = intIdHabitacion;
        this.strNumero = strNumero;
        this.strPiso = strPiso;
        this.strDescripcion = strDescripcion;
        this.strCaracteristicas = strCaracteristicas;
        this.dbPrecio_diario = dbPrecio_diario;
        this.strEstado = strEstado;
        this.strTipo_habitacion = strTipo_habitacion;
    }

    public vHabitacion() {
    }

    public int getIntIdHabitacion() {
        return intIdHabitacion;
    }

    public void setIntIdHabitacion(int intIdHabitacion) {
        this.intIdHabitacion = intIdHabitacion;
    }

    public String getStrNumero() {
        return strNumero;
    }

    public void setStrNumero(String strNumero) {
        this.strNumero = strNumero;
    }

    public String getStrPiso() {
        return strPiso;
    }

    public void setStrPiso(String strPiso) {
        this.strPiso = strPiso;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrCaracteristicas() {
        return strCaracteristicas;
    }

    public void setStrCaracteristicas(String strCaracteristicas) {
        this.strCaracteristicas = strCaracteristicas;
    }

    public Double getDbPrecio_diario() {
        return dbPrecio_diario;
    }

    public void setDbPrecio_diario(Double dbPrecio_diario) {
        this.dbPrecio_diario = dbPrecio_diario;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public String getStrTipo_habitacion() {
        return strTipo_habitacion;
    }

    public void setStrTipo_habitacion(String strTipo_habitacion) {
        this.strTipo_habitacion = strTipo_habitacion;
    }

}
