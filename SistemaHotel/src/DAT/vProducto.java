
package DAT;

public class vProducto {
    private int intIdProducto;
    private String strNombre;
    private String strDescripcion;
    private String strUnidad_medida;
    private Double dbPrecio_venta;

    public vProducto() {
    }

    public vProducto(int intIdProducto, String strNombre, String strDescripcion, String strUnidad_medida, Double dbPrecio_venta) {
        this.intIdProducto = intIdProducto;
        this.strNombre = strNombre;
        this.strDescripcion = strDescripcion;
        this.strUnidad_medida = strUnidad_medida;
        this.dbPrecio_venta = dbPrecio_venta;
    }

    public int getIntIdProducto() {
        return intIdProducto;
    }

    public void setIntIdProducto(int intIdProducto) {
        this.intIdProducto = intIdProducto;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrUnidad_medida() {
        return strUnidad_medida;
    }

    public void setStrUnidad_medida(String strUnidad_medida) {
        this.strUnidad_medida = strUnidad_medida;
    }

    public Double getDbPrecio_venta() {
        return dbPrecio_venta;
    }

    public void setDbPrecio_venta(Double dbPrecio_venta) {
        this.dbPrecio_venta = dbPrecio_venta;
    }
    
    
    
}
