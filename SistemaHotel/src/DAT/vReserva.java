package DAT;

import java.sql.Date;

/**
 *
 * @author STALIN
 */
public class vReserva {

    private int intIdReserva;
    private int intIdHabitacion;
    private int intIdCliente;
    private int intIdTrabajador;
    private String strTipo_reserva;
    private Date dateFecha_reserva;
    private Date dateFecha_ingresa;
    private Date dateFecha_salida;
    private Double dbCosto_alojamiento;
    private String strEstado;

    public vReserva() {
    }

    public vReserva(int intIdReserva, int intIdHabitacion, int intIdCliente, int intIdTrabajador, String strTipo_reserva, Date dateFecha_reserva, Date dateFecha_ingresa, Date dateFecha_salida, Double dbCosto_alojamiento, String strEstado) {
        this.intIdReserva = intIdReserva;
        this.intIdHabitacion = intIdHabitacion;
        this.intIdCliente = intIdCliente;
        this.intIdTrabajador = intIdTrabajador;
        this.strTipo_reserva = strTipo_reserva;
        this.dateFecha_reserva = dateFecha_reserva;
        this.dateFecha_ingresa = dateFecha_ingresa;
        this.dateFecha_salida = dateFecha_salida;
        this.dbCosto_alojamiento = dbCosto_alojamiento;
        this.strEstado = strEstado;
    }

    public int getIntIdReserva() {
        return intIdReserva;
    }

    public void setIntIdReserva(int intIdReserva) {
        this.intIdReserva = intIdReserva;
    }

    public int getIntIdHabitacion() {
        return intIdHabitacion;
    }

    public void setIntIdHabitacion(int intIdHabitacion) {
        this.intIdHabitacion = intIdHabitacion;
    }

    public int getIntIdCliente() {
        return intIdCliente;
    }

    public void setIntIdCliente(int intIdCliente) {
        this.intIdCliente = intIdCliente;
    }

    public int getIntIdTrabajador() {
        return intIdTrabajador;
    }

    public void setIntIdTrabajador(int intIdTrabajador) {
        this.intIdTrabajador = intIdTrabajador;
    }

    public String getStrTipo_reserva() {
        return strTipo_reserva;
    }

    public void setStrTipo_reserva(String strTipo_reserva) {
        this.strTipo_reserva = strTipo_reserva;
    }

    public Date getDateFecha_reserva() {
        return dateFecha_reserva;
    }

    public void setDateFecha_reserva(Date dateFecha_reserva) {
        this.dateFecha_reserva = dateFecha_reserva;
    }

    public Date getDateFecha_ingresa() {
        return dateFecha_ingresa;
    }

    public void setDateFecha_ingresa(Date dateFecha_ingresa) {
        this.dateFecha_ingresa = dateFecha_ingresa;
    }

    public Date getDateFecha_salida() {
        return dateFecha_salida;
    }

    public void setDateFecha_salida(Date dateFecha_salida) {
        this.dateFecha_salida = dateFecha_salida;
    }

    public Double getDbCosto_alojamiento() {
        return dbCosto_alojamiento;
    }

    public void setDbCosto_alojamiento(Double dbCosto_alojamiento) {
        this.dbCosto_alojamiento = dbCosto_alojamiento;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

}
