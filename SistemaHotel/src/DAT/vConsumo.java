
package DAT;

/**
 *
 * @author STALIN
 */
public class vConsumo {
    private int intIdconsumo;
    private int intIdreserva;
    private int intIdproducto;
    private Double dbCantidad;
    private Double dbPrecio_venta;
    private String strEstado;

    public vConsumo() {
    }

    public vConsumo(int intIdconsumo, int intIdreserva, int intIdproducto, Double dbCantidad, Double dbPrecio_venta, String strEstado) {
        this.intIdconsumo = intIdconsumo;
        this.intIdreserva = intIdreserva;
        this.intIdproducto = intIdproducto;
        this.dbCantidad = dbCantidad;
        this.dbPrecio_venta = dbPrecio_venta;
        this.strEstado = strEstado;
    }

    public int getIntIdconsumo() {
        return intIdconsumo;
    }

    public void setIntIdconsumo(int intIdconsumo) {
        this.intIdconsumo = intIdconsumo;
    }

    public int getIntIdreserva() {
        return intIdreserva;
    }

    public void setIntIdreserva(int intIdreserva) {
        this.intIdreserva = intIdreserva;
    }

    public int getIntIdproducto() {
        return intIdproducto;
    }

    public void setIntIdproducto(int intIdproducto) {
        this.intIdproducto = intIdproducto;
    }

    public Double getDbCantidad() {
        return dbCantidad;
    }

    public void setDbCantidad(Double dbCantidad) {
        this.dbCantidad = dbCantidad;
    }

    public Double getDbPrecio_venta() {
        return dbPrecio_venta;
    }

    public void setDbPrecio_venta(Double dbPrecio_venta) {
        this.dbPrecio_venta = dbPrecio_venta;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }
    
    
    
}
