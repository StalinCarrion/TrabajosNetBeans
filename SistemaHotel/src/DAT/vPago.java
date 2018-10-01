
package DAT;

import java.sql.Date;

/**
 *
 * @author STALIN
 */
public class vPago {
    private int intIdpago;
    private int intIdreserva;
    private String strTipo_comprobante;
    private String strNum_comprobante;
    private Double dbIgv;
    private Double dbTotal_pago;
    private Date dateFecha_emision;
    private Date dateFecha_pago;

    public vPago() {
    }

    public vPago(int intIdpago, int intIdreserva, String strTipo_comprobante, String strNum_comprobante, Double dbIgv, Double dbTotal_pago, Date dateFecha_emision, Date dateFecha_pago) {
        this.intIdpago = intIdpago;
        this.intIdreserva = intIdreserva;
        this.strTipo_comprobante = strTipo_comprobante;
        this.strNum_comprobante = strNum_comprobante;
        this.dbIgv = dbIgv;
        this.dbTotal_pago = dbTotal_pago;
        this.dateFecha_emision = dateFecha_emision;
        this.dateFecha_pago = dateFecha_pago;
    }

    public int getIntIdpago() {
        return intIdpago;
    }

    public void setIntIdpago(int intIdpago) {
        this.intIdpago = intIdpago;
    }

    public int getIntIdreserva() {
        return intIdreserva;
    }

    public void setIntIdreserva(int intIdreserva) {
        this.intIdreserva = intIdreserva;
    }

    public String getStrTipo_comprobante() {
        return strTipo_comprobante;
    }

    public void setStrTipo_comprobante(String strTipo_comprobante) {
        this.strTipo_comprobante = strTipo_comprobante;
    }

    public String getStrNum_comprobante() {
        return strNum_comprobante;
    }

    public void setStrNum_comprobante(String strNum_comprobante) {
        this.strNum_comprobante = strNum_comprobante;
    }

    public Double getDbIgv() {
        return dbIgv;
    }

    public void setDbIgv(Double dbIgv) {
        this.dbIgv = dbIgv;
    }

    public Double getDbTotal_pago() {
        return dbTotal_pago;
    }

    public void setDbTotal_pago(Double dbTotal_pago) {
        this.dbTotal_pago = dbTotal_pago;
    }

    public Date getDateFecha_emision() {
        return dateFecha_emision;
    }

    public void setDateFecha_emision(Date dateFecha_emision) {
        this.dateFecha_emision = dateFecha_emision;
    }

    public Date getDateFecha_pago() {
        return dateFecha_pago;
    }

    public void setDateFecha_pago(Date dateFecha_pago) {
        this.dateFecha_pago = dateFecha_pago;
    }
    
    
}
